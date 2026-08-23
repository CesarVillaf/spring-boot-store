package com.codewithmosh.store.payments;

import com.codewithmosh.store.orders.PaymentStatus;

public record PaymentResult(
        Long orderId,
        PaymentStatus paymentStatus
) {}
