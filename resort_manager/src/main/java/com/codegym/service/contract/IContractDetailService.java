package com.codegym.service.contract;

import com.codegym.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    void Save(ContractDetail contractDetail);

    List<ContractDetail> findByIdOfContract(Integer id);
}
