package com.gsamtechnology.sangiorgio.ports.out;

import com.gsamtechnology.sangiorgio.adapter.out.dto.ChargeDto;
import com.gsamtechnology.sangiorgio.domain.entities.Charge;

public interface PublishMessagePortOut {
  void publishCharge(Charge charge);
}
