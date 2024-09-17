package com.gsamtechnology.sangiorgio.ports.out;

import com.gsamtechnology.sangiorgio.domain.entities.Charge;

import java.util.Optional;

public interface FindChargePortOut {
  Optional<Charge> findCharge(Charge charge);
}
