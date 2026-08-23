package com.codewithmosh.store.carts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record CartDto(
        UUID id,
        List<CartItemDto> items,
        BigDecimal totalPrice
) {
    public CartDto {
        items = (items == null) ? new ArrayList<>() : items;
        totalPrice = (totalPrice == null) ? BigDecimal.ZERO : totalPrice;
    }
}
