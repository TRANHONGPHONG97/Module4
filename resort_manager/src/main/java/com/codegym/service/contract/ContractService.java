package com.codegym.service.contract;

import com.codegym.repository.contract.ContractRepository;
import com.codegym.model.contract.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private ContractRepository contractRepository;



    @Override
    public Page<Contract> findAllContract(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Double getTotalPay() {
        return 5000000.0;
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById2(id);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll2() {
        return contractRepository.findAll();
    }


}
