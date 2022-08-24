package com.cg.service.customer;

import com.cg.model.Customer;
import com.cg.model.Transfer;
import com.cg.model.dto.CustomerDTO;
import com.cg.model.dto.DepositDTO;
import com.cg.model.dto.WithdrawDTO;
import com.cg.service.IGeneralService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CustomerService extends IGeneralService<Customer> {

    List<Customer> findByIdIsNot(Long id);

    List<CustomerDTO> findAllCustomerDTO();
    Optional<CustomerDTO> findCustomerDTOByEmailAndIdIsNot(String email, Long id);
    Optional<CustomerDTO> findCustomerDTOBy(Long id);
    Optional<CustomerDTO> doDeposit(DepositDTO depositDTO);
    Boolean existsByEmail(String email);
    Optional<CustomerDTO> doWithdraw(WithdrawDTO withdrawDTO);

    Map<String, CustomerDTO> doTransfer(Transfer transfer);
    List<Customer> findAllByDeletedFalse();

    List<CustomerDTO> findAllCustomerDTOByDeletedIsFalse();

    Optional<CustomerDTO> getCustomerDTOById(Long id);

}