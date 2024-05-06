package ru.paermakov.product_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductEntity {

    private Long productId;
    private Long userId;
    private Long accountNumber;
    private BigDecimal accountBalance;
    private String productType;

}
