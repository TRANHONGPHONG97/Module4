package com.codegym.service.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAllContract(Pageable pageable);

    Double getTotalPay();

    Contract findById(Integer id);

    void save(Contract contract);

    List<Contract> findAll2();
}
