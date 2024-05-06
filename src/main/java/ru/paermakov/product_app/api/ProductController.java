package ru.paermakov.product_app.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.paermakov.product_app.entity.ProductEntity;
import ru.paermakov.product_app.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all/{userId}")
    public List<ProductEntity> getAllProductsByUserId(@PathVariable Long userId) {
        return productService.getAllProductsByUserId(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

}
