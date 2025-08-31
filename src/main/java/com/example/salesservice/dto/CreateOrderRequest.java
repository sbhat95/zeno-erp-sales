package com.example.salesservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {
    @NotNull
    private Long customerId;
    @NotNull
    private List<Item> items;

    @Data
    public static class Item {
        @NotNull
        private Long productId;
        @Positive
        private Integer quantity;
        @Positive
        private Double unitPrice;
    }
}
