package com.cg.controller.rest;

import com.cg.exception.DataInputException;
import com.cg.exception.EmailExistsException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.model.LocationRegion;
import com.cg.model.dto.CustomerDTO;
import com.cg.model.dto.DepositDTO;
import com.cg.model.dto.TransferDTO;
import com.cg.model.dto.WithdrawDTO;
import com.cg.service.deposit.DepositService;
import com.cg.service.customer.CustomerService;
import com.cg.service.locationRegion.LocationRegionService;
import com.cg.utils.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;
@Autowired
private DepositService depositService;
    @Autowired
    private LocationRegionService locationRegionService;
    @Autowired
    private AppUtil appUtil;

    @GetMapping
    public ResponseEntity<List<?>> getAllCustomers() {

//        List<Customer> customers = customerService.findAll();

        List<CustomerDTO> customers = customerService.findAllCustomerDTO();

        if (customers.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable long id) {
        Optional<Customer> customerOptional = customerService.findById(id);

        if (!customerOptional.isPresent()){
            throw new ResourceNotFoundException("Id kh??ch h??ng kh??ng h???p l???");
        }

        return new ResponseEntity<>(customerOptional.get().toCustomerDTO(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            return appUtil.mapErrorToResponse(bindingResult);
        }

        customerDTO.setId(0L);
        customerDTO.setBalance(new BigDecimal(0L));
        customerDTO.getLocationRegion().setId(0L);

        Boolean exitsEmail = customerService.existsByEmail(customerDTO.getEmail());

        if (exitsEmail) {
//            return new ResponseEntity<>("Email exits", HttpStatus.CONFLICT);
            throw new EmailExistsException("Email ???? t???n t???i");
        }

        Customer newCustomer = customerService.save(customerDTO.toCustomer());

        return new ResponseEntity<>(newCustomer.toCustomerDTO(), HttpStatus.CREATED);
    }


    @PostMapping("/update")
    public ResponseEntity<?> doUpdate(@Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            return appUtil.mapErrorToResponse(bindingResult);
        }

        Optional<CustomerDTO> optionalCustomerDTO = customerService.findCustomerDTOByEmailAndIdIsNot(customerDTO.getEmail(), customerDTO.getId());

        if (optionalCustomerDTO.isPresent()) {
            throw new EmailExistsException("Email ???? t???n t???i");
        }

        try {
            Customer updateCustomer = customerService.save(customerDTO.toCustomer());

            return new ResponseEntity<>(updateCustomer.toCustomerDTO(), HttpStatus.CREATED);

        } catch (DataIntegrityViolationException ex) {
            throw new DataInputException("C???p nh???t th??ng tin kh??ch h??ng kh??ng h???p l???");
        }
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> doDeposit(@Validated @RequestBody DepositDTO depositDTO, BindingResult bindingResult){
        Long customerId = depositDTO.getCustomerId();
        new DepositDTO().validate(depositDTO, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return appUtil.mapErrorToResponse(bindingResult);
        }

        Optional<Customer> customerOptional = customerService.findById(Long.valueOf(depositDTO.getCustomerId()));

        if (!customerOptional.isPresent()) {
            throw new ResourceNotFoundException("ID kh??ch h??ng kh??ng h???p l???");
        }

        Optional<CustomerDTO> customerDTO = customerService.doDeposit(depositDTO);

        return new ResponseEntity<>(customerDTO.get(), HttpStatus.CREATED);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> doWithdraw(@Validated @RequestBody WithdrawDTO withdrawDTO, BindingResult bindingResult){

        new WithdrawDTO().validate(withdrawDTO, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return appUtil.mapErrorToResponse(bindingResult);
        }

        Optional<Customer> customerOptional = customerService.findById(Long.valueOf(withdrawDTO.getCustomerId()));

        if (customerOptional.isPresent()) {
            BigDecimal currentBalance = customerOptional.get().getBalance();
            BigDecimal transactionAmount = new BigDecimal(Long.parseLong(withdrawDTO.getTransactionAmount()));

            if (currentBalance.compareTo(transactionAmount) >=0) {
                try {
                    Optional<CustomerDTO> customerDTO = customerService.doWithdraw(withdrawDTO);
                    return new ResponseEntity<>(customerDTO.get(), HttpStatus.CREATED);

                } catch (DataIntegrityViolationException ex) {
                    throw new ResourceNotFoundException("ID kh??ch h??ng kh??ng h???p l???");
                }
            }else {
                throw new DataInputException("S??? d?? kh??ng ?????");
            }
        }else {
            throw new ResourceNotFoundException("ID kh??ch h??ng kh??ng h???p l???");

        }
    }
    @PostMapping("/transfer")
    public ResponseEntity<?> doTransfer(@Validated @RequestBody TransferDTO transferDTO, BindingResult bindingResult){

//        new TransferDTO().validate(transferDTO, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return appUtil.mapErrorToResponse(bindingResult);
        }

        Optional<Customer> senderOptional = customerService.findById(Long.valueOf(transferDTO.getSenderId()));

        if (!senderOptional.isPresent()) {
            throw new ResourceNotFoundException("ID ng?????i g???i kh??ng h???p l???");
        }

        Optional<Customer> recipientOptional = customerService.findById(Long.valueOf(transferDTO.getRecipientId()));

        if (!recipientOptional.isPresent()) {
            throw new ResourceNotFoundException("ID ng?????i nh???n kh??ng h???p l???");
        }

        BigDecimal currentBalance = senderOptional.get().getBalance();
        BigDecimal transferAmount = new BigDecimal(Long.parseLong(transferDTO.getTransferAmount()));
        Long fees = 10L;
        BigDecimal fessAmount = transferAmount.multiply(BigDecimal.valueOf(fees)).divide(new BigDecimal(100L));
        BigDecimal transactionAmount = transferAmount.add(fessAmount);

        transferDTO.setFees(String.valueOf(fees));
        transferDTO.setFeesAmount(String.valueOf(fessAmount));
        transferDTO.setTransferAmount(String.valueOf(transferAmount));
        transferDTO.setTransactionAmount(String.valueOf(transactionAmount));

        if (transactionAmount.compareTo(currentBalance) > 0) {
            throw new DataInputException("S??? d?? c???a ng?????i g???i kh??ng ?????");
        }

        try{
            Map<String, CustomerDTO> result = customerService.doTransfer(transferDTO.toTransfer(senderOptional.get(), recipientOptional.get()));

            return new ResponseEntity<>(result, HttpStatus.CREATED);

        }catch (Exception ex) {
            throw new DataInputException("Chuy???n ti???n th???t b???i");
        }
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> doDelete (@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);

        if (customerOptional.isPresent()) {
            try {
                customerOptional.get().setDeleted(true);
                customerService.save(customerOptional.get());

                return new ResponseEntity<>(HttpStatus.CREATED);

            }catch (DataIntegrityViolationException ex) {
                throw new DataInputException("Th??ng tin ????? x??a kh??ng h???p l???");
            }
        }else {
            throw new DataInputException("Th??ng tin kh??ch h??ng kh??ng h???p l???");
        }
    }

}
