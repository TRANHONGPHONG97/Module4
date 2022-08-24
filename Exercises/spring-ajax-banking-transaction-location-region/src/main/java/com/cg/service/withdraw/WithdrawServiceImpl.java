package com.cg.service.withdraw;

import com.cg.model.Customer;
import com.cg.model.Withdraw;
import com.cg.repository.CustomerRepository;
import com.cg.repository.WithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class WithdrawServiceImpl implements WithdrawService {

    @Autowired
    WithdrawRepository withDrawRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Optional<Withdraw> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Withdraw save(Withdraw withdraw) {
        return withDrawRepository.save(withdraw);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<Withdraw> findAll() {
        return null;
    }

    @Override
    public Withdraw getById(Long id) {
        return null;
    }

    @Override
    public Customer withdraw(Withdraw withdraw) {
        withdraw.setId(0L);
        withDrawRepository.save(withdraw);

        Customer customer = withdraw.getCustomer();
        customerRepository.reduceBalance(customer.getId(), withdraw.getTransactionAmount());
        customer.setBalance(customer.getBalance().add(withdraw.getTransactionAmount()));

        return customer;
    }
}