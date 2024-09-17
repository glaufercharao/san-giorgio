package com.gsamtechnology.sangiorgio.adapter.in.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record ChargeRequestDto(
        @NotBlank(message = "Code seller cannot be empty.")
        String codeSeller,
        @Valid
        List<PaymentDto> payments
) {}
