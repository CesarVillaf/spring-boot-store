package com.codewithmosh.store.orders;

import java.math.BigDecimal;

public record OrderItemDto(
        ProductDto product,
        int quantity,
        BigDecimal totalPrice
) {
}
