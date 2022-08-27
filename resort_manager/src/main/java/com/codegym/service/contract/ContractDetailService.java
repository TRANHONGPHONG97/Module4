package com.codegym.service.contract;

import com.codegym.repository.contract.ContractDetailRepository;
import com.codegym.model.contract.ContractDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void Save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findByIdOfContract(Integer id) {
        return contractDetailRepository.findByIdOfContract(id);
    }
}
