package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceIplm implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "fan", 2000, "so cold"));
        products.put(2, new Product(2, "laptop", 20000, "run very stable"));
        products.put(3, new Product(3, "Iphone7", 15500, "style"));
        products.put(4, new Product(4, "fridge", 12000, "saving electricity"));
        products.put(5, new Product(5, "television", 15000, "fashionable style"));
        products.put(6, new Product(6, "air conditioning", 10000, "energy saving"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }


    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }
}