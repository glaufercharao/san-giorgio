package com.gsamtechnology.sangiorgio.adapter.out.dto;

import com.gsamtechnology.sangiorgio.adapter.in.dto.PaymentDto;

import java.util.List;

public record ChargeDto(
        String codeSeller,
        PaymentDto payment
){}
