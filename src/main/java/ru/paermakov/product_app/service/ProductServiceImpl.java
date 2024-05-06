package ru.paermakov.product_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.paermakov.product_app.entity.ProductEntity;
import ru.paermakov.product_app.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<ProductEntity> getAllProductsByUserId(Long userId) {
        return productRepository.getAllProductsByUserId(userId);
    }

    @Override
    public ResponseEntity<?> getProductById(Long id) {
        Optional<ProductEntity> product = productRepository.getProductById(id);
        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(String.format("{Продукт с ID %d не найден}", id));
        }

        return ResponseEntity.ok().body(product);
    }
}
