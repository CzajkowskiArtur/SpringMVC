package pl.sdacademy.dao.impl;

import pl.sdacademy.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getTopProducts(int count);
}
