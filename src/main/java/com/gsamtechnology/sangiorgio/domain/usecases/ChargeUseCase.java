package com.gsamtechnology.sangiorgio.domain.usecases;

import com.gsamtechnology.sangiorgio.adapter.in.ChargeMapper;
import com.gsamtechnology.sangiorgio.adapter.in.dto.ChargeResponseDto;
import com.gsamtechnology.sangiorgio.domain.entities.Charge;
import com.gsamtechnology.sangiorgio.domain.enums.PaymentStatus;
import com.gsamtechnology.sangiorgio.domain.exception.ChargeResourceNotFoundException;
import com.gsamtechnology.sangiorgio.ports.in.ChargePortIn;
import com.gsamtechnology.sangiorgio.ports.out.FindChargePortOut;
import com.gsamtechnology.sangiorgio.ports.out.PublishMessagePortOut;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChargeUseCase implements ChargePortIn {
  private final FindChargePortOut findChargePortOut;
  private final PublishMessagePortOut publishMessagePortOut;
  private final ChargeMapper chargeMapper;

  public ChargeUseCase(FindChargePortOut findChargePortOut, PublishMessagePortOut publishMessagePortOut, ChargeMapper chargeMapper) {
    this.findChargePortOut = findChargePortOut;
    this.publishMessagePortOut = publishMessagePortOut;
    this.chargeMapper = chargeMapper;
  }

  @Override
  public ChargeResponseDto processCharge(Charge charge) {
    Optional<Charge> chargeOptional = findChargePortOut.findCharge(charge);
    if(!chargeOptional.isPresent()){
      throw new ChargeResourceNotFoundException("Seller: " + charge.getCodeSeller() + " not found");
    }
    chargeOptional.get().getPayments().stream()
            .map(payment -> {
              charge.getPayments().forEach(
               pay ->{
                 if(payment.getCodePayment().equals(pay.getCodePayment())){
                   payment.setStatus(getStatus(pay.getAmountPayment(), payment.getAmountPayment()));
                   payment.setAmountPayment(pay.getAmountPayment());
                 }
               });
              return payment;})
            .collect(Collectors.toList());
//    publishMessagePortOut.publishCharge(chargeOptional.get());
    return chargeMapper.toChargeResponseDto(chargeOptional.get());
  }
  private PaymentStatus getStatus(BigDecimal receivedAmount, BigDecimal originalAmount){
    if (receivedAmount.doubleValue() < originalAmount.doubleValue()) {
      return PaymentStatus.PARTIAL;
    } else if (receivedAmount.doubleValue() == originalAmount.doubleValue()) {
      return PaymentStatus.TOTAL;
    } else {
      return PaymentStatus.EXCEEDED;
    }
  }
}
