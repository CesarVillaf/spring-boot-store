package com.codewithmosh.store.carts;

import java.math.BigDecimal;

public record CartItemDto(
        ProductDto product,
        int quantity,
        BigDecimal totalPrice
) {}
