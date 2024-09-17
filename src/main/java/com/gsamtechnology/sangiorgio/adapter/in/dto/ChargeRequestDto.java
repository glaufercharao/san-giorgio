package com.gsamtechnology.sangiorgio.adapter.in.dto;

import java.util.List;

public record ChargeRequestDto(
        String codeSeller,
        List<PaymentDto> payments
) {}
