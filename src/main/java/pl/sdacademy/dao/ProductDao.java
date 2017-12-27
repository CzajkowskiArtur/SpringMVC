package pl.sdacademy.dao;

import pl.sdacademy.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getTopProducts(int count);
}
