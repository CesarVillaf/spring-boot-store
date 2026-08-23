package com.codewithmosh.store.carts;

import jakarta.validation.constraints.NotNull;

public record AddItemToCartRequest(
        @NotNull(message = "ProductId must be provided")
        Long productId
) {}
