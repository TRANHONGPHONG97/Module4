package com.codegym.repository.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface ContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select * from contract where status_delete = 0 ", nativeQuery = true)
    Page<Contract> findAll(Pageable pageable);

    @Query(value = "select * from contract where contract_id = :id ", nativeQuery = true)
    Contract findById2(@Param("id") Integer id);
}
