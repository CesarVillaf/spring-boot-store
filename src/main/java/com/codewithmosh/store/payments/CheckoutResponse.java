package com.codewithmosh.store.payments;

public record CheckoutResponse(Long orderId, String checkoutUrl) {}
