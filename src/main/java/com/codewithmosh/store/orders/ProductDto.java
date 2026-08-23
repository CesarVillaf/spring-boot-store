package com.codewithmosh.store.orders;

import java.math.BigDecimal;

public record ProductDto(
        Long id,
        String name,
        BigDecimal price
) {}
