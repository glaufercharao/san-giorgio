package com.gsamtechnology.sangiorgio.adapter.out;

import com.gsamtechnology.sangiorgio.adapter.in.ChargeMapper;
import com.gsamtechnology.sangiorgio.adapter.out.persistence.entities.ChargeEntity;
import com.gsamtechnology.sangiorgio.adapter.out.persistence.repositories.ChargeRepository;
import com.gsamtechnology.sangiorgio.domain.entities.Charge;
import com.gsamtechnology.sangiorgio.ports.out.FindChargePortOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    Optional<ChargeEntity> chargeOptional = repository.findById(charge.getCodeSeller());
    logger.info("Ending search.");
    return chargeOptional.map(chargeMapper::toChargeFromEntity);
  }
}
