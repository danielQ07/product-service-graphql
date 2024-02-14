package com.appOrders.productservice.dto;

public record ProductoRequest(
        String id,
        String name,
        Double price,
        Integer quantity,
        Long categoryId
) {
}
