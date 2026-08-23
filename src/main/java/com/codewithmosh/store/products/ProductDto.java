package com.codewithmosh.store.products;

import java.math.BigDecimal;

public record ProductDto(
    Long id,
    String name,
    BigDecimal price,
    String description,
    Byte categoryId
) {}