package ru.paermakov.product_app.service;

import org.springframework.http.ResponseEntity;
import ru.paermakov.product_app.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> getAllProductsByUserId(Long userId);

    ResponseEntity<?> getProductById(Long id);
}
