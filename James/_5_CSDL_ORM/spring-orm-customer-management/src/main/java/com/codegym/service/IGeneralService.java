package com.codegym.service;

import com.codegym.model.Customer;
import org.hibernate.usertype.CompositeUserType;

import java.awt.print.Pageable;
import java.util.List;

public interface IGeneralService <T>{
    Customer save(Customer customer);
    boolean exists (Long id);
    List<T> findAll();
    T findOne(Long id);
    void delete (Long id);
//    List<Customer> searchByName(Customer customer);

    void delete(Customer customer);
    void remove(Long id);

}
