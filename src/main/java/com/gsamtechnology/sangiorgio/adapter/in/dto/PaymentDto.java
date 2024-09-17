package com.gsamtechnology.sangiorgio.adapter.in.dto;

import com.gsamtechnology.sangiorgio.domain.enums.PaymentStatus;

import java.math.BigDecimal;

public record PaymentDto(
        String codePayment,
        BigDecimal amountPayment,
        PaymentStatus status
) {}
