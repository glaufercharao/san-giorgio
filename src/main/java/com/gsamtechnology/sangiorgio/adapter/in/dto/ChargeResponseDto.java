package com.gsamtechnology.sangiorgio.adapter.in.dto;

import com.gsamtechnology.sangiorgio.domain.entities.Payment;

import java.util.ArrayList;
import java.util.List;

public record ChargeResponseDto(
        String codeSeller,
        List<Payment>payments
){}
