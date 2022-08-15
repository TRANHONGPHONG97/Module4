package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView showCustomerListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/index");

//        List<Customer> customerList = hibernateCustomerService.findAll();

        List<Customer> customerList = customerService.findAll();

        modelAndView.addObject("customers", customerList);

        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView showCustomerByIdPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/edit");

//        Customer customer = hibernateCustomerService.findById(id);

        Optional<Customer> customer = customerService.findById(id);

        if (!customer.isPresent()) {
            modelAndView.setViewName("/error.404");
            return modelAndView;
        }

        modelAndView.addObject("customer", customer.get());

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/create");

        Customer customer = new Customer();
        modelAndView.addObject("customer", customer);

        return modelAndView;
    }


    @PostMapping("/create")
    public ModelAndView doCreate(@ModelAttribute Customer customer) {
//        hibernateCustomerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create");

        customer.setId(0L);
        customerService.save(customer);

        modelAndView.addObject("message", "Đã thêm thành công");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }


    @PostMapping("/update/{id}")
    public String doUpdate(@ModelAttribute Customer customer) {
//        hibernateCustomerService.save(customer);

        customerService.save(customer);

        return "redirect:/customers";
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("customer/suspended");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customer")
    public ModelAndView deleteCustomer(@ModelAttribute("customer") Customer customer) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/suspended");
        customerService.remove(customer.getId());
        modelAndView.addObject("message", "Đã xóa thành công");
        return modelAndView;
    }
}
