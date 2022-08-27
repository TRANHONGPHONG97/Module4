package com.codegym.repository.customer;

import com.codegym.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CustomerTypeRepository extends JpaRepository<CustomerType,Integer> {

}
