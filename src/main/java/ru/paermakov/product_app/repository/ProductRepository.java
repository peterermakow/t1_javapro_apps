package ru.paermakov.product_app.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.paermakov.product_app.config.DataSource;
import ru.paermakov.product_app.entity.ProductEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final String GET_ALL_PRODUCTS_BY_USERID_QUERY = "SELECT product_id, user_id, account_number, account_balance, product_type FROM product_app WHERE user_id = ?";
    private final String GET_PRODUCT_BY_ID_QUERY = "SELECT product_id, user_id, account_number, account_balance, product_type FROM product_app WHERE product_id = ?";

    private final DataSource dataSource;

    public List<ProductEntity> getAllProductsByUserId(Long userId) {
        List<ProductEntity> products;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(GET_ALL_PRODUCTS_BY_USERID_QUERY);
            pst.setLong(1, userId);
            ResultSet rs = pst.executeQuery();
            products = new ArrayList<>();
            ProductEntity product;
            while (rs.next()) {
                product = new ProductEntity(
                        rs.getLong("product_id"),
                        rs.getLong("user_id"),
                        rs.getLong("account_number"),
                        rs.getBigDecimal("account_balance"),
                        rs.getString("product_type"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public Optional<ProductEntity> getProductById(Long id)  {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(GET_PRODUCT_BY_ID_QUERY);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return Optional.of(new ProductEntity(
                        rs.getLong("product_id"),
                        rs.getLong("user_id"),
                        rs.getLong("account_number"),
                        rs.getBigDecimal("account_balance"),
                        rs.getString("product_type")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
