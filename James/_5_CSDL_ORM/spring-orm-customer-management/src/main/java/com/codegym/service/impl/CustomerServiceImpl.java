package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ICustomerRepository ICustomerRepository;


    @Override
    public boolean existsById(Long id) {
        return ICustomerRepository.existsById(id);
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) ICustomerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return ICustomerRepository.findById(id);
    }

    @Override
    public Customer getById(Long id) {return ICustomerRepository.getById(id);
    }


    @Override
    public List<Customer> findByFullNameLike(String fullName) {
        return ICustomerRepository.findByFullNameLike(fullName);
    }

    @Override
    public List<Customer> findByFullNameLikeOrEmailLikeOrPhoneLikeOrAddressLike(String fullName, String email, String phone, String address) {
        return ICustomerRepository.findByFullNameLikeOrEmailLikeOrPhoneLikeOrAddressLike(fullName, email, phone, address);
    }

    @Override
    public List<Customer> findAllBySearchKey(String searchKey) {
        return ICustomerRepository.findAllBySearchKey(searchKey);
    }

    @Override
    public Customer save(Customer customer) {
        return ICustomerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        ICustomerRepository.deleteById(id);
    }

    @Override
    public void delete(Customer customer) {
        ICustomerRepository.delete(customer);
    }
    @Override
    public void remove(Long id) {
        ICustomerRepository.deleteById(id);
    }
}