package com.gsamtechnology.sangiorgio.adapter.in.controllers;

import com.gsamtechnology.sangiorgio.adapter.in.ChargeMapper;
import com.gsamtechnology.sangiorgio.adapter.in.dto.ChargeRequestDto;
import com.gsamtechnology.sangiorgio.adapter.in.dto.ChargeResponseDto;
import com.gsamtechnology.sangiorgio.ports.in.ChargePortIn;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/charge")
public class ChargeController {
  private static final Logger logger = LoggerFactory.getLogger(ChargeController.class);
  private final ChargePortIn chargePortIn;
  private final ChargeMapper chargeMapper;

  public ChargeController(ChargePortIn chargePortIn, ChargeMapper chargeMapper) {
    this.chargePortIn = chargePortIn;
    this.chargeMapper = chargeMapper;
  }

  @PostMapping
  public ResponseEntity<ChargeResponseDto> processCharge(@Valid @RequestBody ChargeRequestDto chargeRequestDto){
    logger.info("Starting payment registration process..");
   ChargeResponseDto  charge = chargePortIn.processCharge(chargeMapper.toCharge(chargeRequestDto));
    logger.info("Payment process completed successfully.");
   return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(charge);
  }
}
