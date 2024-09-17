package com.gsamtechnology.sangiorgio.adapter.out;

import com.gsamtechnology.sangiorgio.adapter.in.ChargeMapper;
import com.gsamtechnology.sangiorgio.adapter.in.PaymentMapper;
import com.gsamtechnology.sangiorgio.adapter.out.persistence.entities.ChargeEntity;
import com.gsamtechnology.sangiorgio.adapter.out.persistence.entities.PaymentEntity;
import com.gsamtechnology.sangiorgio.adapter.out.persistence.repositories.ChargeRepository;
import com.gsamtechnology.sangiorgio.domain.entities.Charge;
import com.gsamtechnology.sangiorgio.domain.entities.Payment;
import com.gsamtechnology.sangiorgio.ports.out.FindChargePortOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FindChargeAdapterOut implements FindChargePortOut {
  private static final Logger logger = LoggerFactory.getLogger(FindChargeAdapterOut.class);
  private final ChargeRepository repository;
  private final ChargeMapper chargeMapper;

  public FindChargeAdapterOut(ChargeRepository repository, ChargeMapper chargeMapper) {
    this.repository = repository;
    this.chargeMapper = chargeMapper;
  }

  @Override
  public Optional<Charge> findCharge(Charge charge) {
    logger.info("Finding seller: {}", charge.getCodeSeller());
    List<String> payments = charge.getPayments().stream()
            .map(Payment::getCodePayment)
            .collect(Collectors.toList());
    String code = charge.getCodeSeller();
    Optional<ChargeEntity> chargeOptional = repository.getPayment(code, payments);
    logger.info("Ending search.");
    return chargeOptional.map(chargeMapper::toChargeFromEntity);
  }
}
