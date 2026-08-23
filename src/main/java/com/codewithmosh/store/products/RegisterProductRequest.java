package com.codewithmosh.store.products;

import java.math.BigDecimal;

public record RegisterProductRequest(
        String name,
        String description,
        BigDecimal price,
        Byte category
) {
}
