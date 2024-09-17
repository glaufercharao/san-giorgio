package com.gsamtechnology.sangiorgio.ports.in;

import com.gsamtechnology.sangiorgio.adapter.in.dto.ChargeResponseDto;
import com.gsamtechnology.sangiorgio.domain.entities.Charge;

public interface ChargePortIn {
  ChargeResponseDto processCharge(Charge charge);
}
