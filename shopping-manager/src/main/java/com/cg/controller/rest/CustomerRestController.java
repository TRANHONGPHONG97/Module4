package com.cg.controller.rest;

import com.cg.model.Customer;
import com.cg.model.dto.CustomerDTO;
import com.cg.model.dto.ProductDTO;
import com.cg.service.customer.ICustomerService;
import com.cg.utils.AppUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;


    @GetMapping
    public ResponseEntity<?> showListCustomer() {
        List<CustomerDTO> customers = customerService.findAllCustomerDTO();

        if (customers.isEmpty()) {
            return new ResponseEntity<>("Danh sách trống!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        Optional<CustomerDTO> customerDTO = customerService.findCustomerDTOById(id);

        if (!customerDTO.isPresent()) {
            return new ResponseEntity<>("Không tìm thấy sản phẩm có id là:" + id + "!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerDTO.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {

        new CustomerDTO().validate(customerDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            return AppUtils.errors(bindingResult);
        }

        try {
            Customer customer = customerDTO.toCustomer();
            customer.setId(0L);
            customer.setDeleted(false);
            customer = customerService.save(customer);

            return new ResponseEntity<>(customer.toCustomerDTO(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Server không xử lý được", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> doEdit(@PathVariable Long id,@Validated @RequestBody CustomerDTO customerDTO,
                                    BindingResult bindingResult) {
        Optional<Customer> c = customerService.findById(id);

        if (!c.isPresent()) {
            return new ResponseEntity<>("Không tồn tại sản phẩm", HttpStatus.NOT_FOUND);
        }

        new CustomerDTO().validate(customerDTO,bindingResult);

        if (bindingResult.hasErrors()) {
            return AppUtils.errors(bindingResult);
        }

        try {
            Customer customer = customerDTO.toCustomer();

            customer.setId(c.get().getId());
            customer.setDeleted(c.get().isDeleted());

            customerDTO = customer.toCustomerDTO();

            customerService.save(customer);

            return new ResponseEntity<>(customerDTO, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Server không xử lý được", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/block/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> doBlock(@PathVariable Long id, @Validated @RequestBody ProductDTO productDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return AppUtils.errors(bindingResult);
        }

        try{
            customerService.deleteCustomerById(id);

            return new ResponseEntity<>(id,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Server không xử lý được", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
