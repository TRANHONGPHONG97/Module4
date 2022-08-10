package com.codegym.ss7_c0222g1.service;


import com.codegym.ss7_c0222g1.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    Optional<Product> findById(Integer id);

    void deleteById(String id);

    List<Product> searchByName(Product product);
}
