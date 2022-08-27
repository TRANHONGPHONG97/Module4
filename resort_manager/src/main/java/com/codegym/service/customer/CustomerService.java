package com.codegym.service.customer;

import com.codegym.repository.customer.CustomerRepository;
import com.codegym.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll2() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        customerRepository.delete(id);
    }

    @Override
    public Page<Customer> searchByNameCustomer(String name, Pageable pageable) {
        return customerRepository.searchByNameCustomer(name,pageable);
    }
}
