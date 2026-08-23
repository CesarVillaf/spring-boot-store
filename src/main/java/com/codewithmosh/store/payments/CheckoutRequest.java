package com.codewithmosh.store.payments;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CheckoutRequest(
        @NotNull(message = "Cart ID is required.")
        UUID cartId
) {}
