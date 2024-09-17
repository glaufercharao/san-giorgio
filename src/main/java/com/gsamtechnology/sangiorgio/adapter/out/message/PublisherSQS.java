package com.gsamtechnology.sangiorgio.adapter.out.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsamtechnology.sangiorgio.adapter.in.PaymentMapper;
import com.gsamtechnology.sangiorgio.adapter.out.dto.ChargeDto;
import com.gsamtechnology.sangiorgio.domain.entities.Charge;
import com.gsamtechnology.sangiorgio.domain.enums.PaymentStatus;
import com.gsamtechnology.sangiorgio.ports.out.PublishMessagePortOut;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PublisherSQS implements PublishMessagePortOut {
  private static final Logger logger = LoggerFactory.getLogger(PublisherSQS.class);
  private final SqsTemplate sqsTemplate;
  private final PaymentMapper paymentMapper;
  private final ObjectMapper objectMapper;

  public PublisherSQS(SqsTemplate sqsTemplate, PaymentMapper paymentMapper, ObjectMapper objectMapper) {
    this.sqsTemplate = sqsTemplate;
    this.paymentMapper = paymentMapper;
    this.objectMapper = objectMapper;
  }

  @Override
  public void publishCharge(Charge charge) {
    logger.info("Initializing payment sending to queue...");
    charge.getPayments().forEach(payment -> {
      ChargeDto chargeDto = new ChargeDto(charge.getCodeSeller(), paymentMapper.toPaymentDto(payment));
      String queue = "";

      if (payment.getStatus().equals(PaymentStatus.TOTAL)) {
        queue = "aws-total-queue";
      } else if (payment.getStatus().equals(PaymentStatus.PARTIAL)) {
        queue = "aws-partial-queue";
      } else {
        queue = "aws-exceeded-queue";
      }

      try {
        String finalQueue = queue;
        sqsTemplate.send(sqsSendOptions -> {
          try {
            sqsSendOptions.queue(finalQueue)
                    .payload(objectMapper.writeValueAsString(chargeDto));
          } catch (JsonProcessingException e) {
            logger.error("Queue Exception Message: {}", e.getMessage());
          }
        });
      } catch (Exception e) {
        logger.error("Queue Exception Message: {}", e.getMessage());
      }
    });
    logger.info("Submission completed successfully.");
  }
}
