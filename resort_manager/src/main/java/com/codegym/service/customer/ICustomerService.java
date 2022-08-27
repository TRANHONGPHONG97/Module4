package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll2();

    void save(Customer customer);

    Customer findById(String id);

    void delete (String id);

    Page<Customer> searchByNameCustomer(String name,Pageable pageable);
}
