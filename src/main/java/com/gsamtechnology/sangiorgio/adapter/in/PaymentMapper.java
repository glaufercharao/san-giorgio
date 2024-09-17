package com.gsamtechnology.sangiorgio.adapter.in;

import com.gsamtechnology.sangiorgio.adapter.in.dto.PaymentDto;
import com.gsamtechnology.sangiorgio.adapter.out.persistence.entities.PaymentEntity;
import com.gsamtechnology.sangiorgio.domain.entities.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PaymentMapper {
  @Mapping(source = "codePayment", target = "codePayment")
  @Mapping(source = "amountPayment", target = "amountPayment")
  @Mapping(source = "status", target = "status")
  PaymentDto toPaymentDto(Payment payment);
}
