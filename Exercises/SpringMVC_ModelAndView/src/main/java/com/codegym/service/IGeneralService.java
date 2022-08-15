package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {

    boolean existsById(Long id);

    List<T> findAll();

    Optional<T> findById(Long id);

    Customer getById(Long id);

    T save(T customer);

    void delete(Long id);

    void delete(T customer);
    void remove(Long id);
}
