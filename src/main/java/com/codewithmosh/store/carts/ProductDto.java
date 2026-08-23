package com.codewithmosh.store.carts;

import java.math.BigDecimal;

public record ProductDto(
        Long id,
        String name,
        BigDecimal price
) {}