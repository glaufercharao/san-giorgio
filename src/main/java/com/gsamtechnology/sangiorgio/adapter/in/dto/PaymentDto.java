package com.gsamtechnology.sangiorgio.adapter.in.dto;

import com.gsamtechnology.sangiorgio.domain.enums.PaymentStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record PaymentDto(
        @NotBlank(message = "Code payment cannot be empty.")
        String codePayment,
        @DecimalMin(value = "1.0")
        BigDecimal amountPayment,
        PaymentStatus status
) {}
