package com.codewithmosh.store.orders;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
    List<OrderDto> toDtos(List<Order> orders);
}
