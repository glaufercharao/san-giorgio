package com.gsamtechnology.sangiorgio.adapter.in;

import com.gsamtechnology.sangiorgio.adapter.in.dto.ChargeRequestDto;
import com.gsamtechnology.sangiorgio.adapter.in.dto.ChargeResponseDto;
import com.gsamtechnology.sangiorgio.adapter.out.persistence.entities.ChargeEntity;
import com.gsamtechnology.sangiorgio.domain.entities.Charge;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChargeMapper {
  Charge toCharge(ChargeRequestDto chargeRequestDto);
  Charge toChargeFromEntity(ChargeEntity chargeEntity);
  ChargeResponseDto toChargeResponseDto(Charge charge);
}
