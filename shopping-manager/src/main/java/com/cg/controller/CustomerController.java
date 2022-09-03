package com.cg.controller;

import com.cg.model.Customer;
import com.cg.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
//    @GetMapping
//    public ModelAndView showListUser() {
//        return new ModelAndView("/customer/list");
//    }

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/list");
        return modelAndView;
    }

//    @GetMapping("/search")
//    public ModelAndView showSearchResultPage(@RequestParam String search) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("customer/list");
//
//        search = "%" + search + "%";
//
////        List<Customer> customerList = customerService.findByFullNameLike(search);
//
////        List<Customer> customerList = customerService.findByFullNameLikeOrEmailLikeOrPhoneLikeOrAddressLike(search, search, search, search);
//
//        List<Customer> customerList = customerService.findAllBySearchKey(search);
//
//        modelAndView.addObject("customers", customerList);
//
//
//        return modelAndView;
//    }


    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/modal_createCus");

        modelAndView.addObject("customer", new Customer());

        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/modal_updateCus");

        Optional<Customer> customer = customerService.findById(id);

        if (customer.isPresent()) {
            modelAndView.addObject("customer", customer);
        }
        else {
            modelAndView.addObject("customer", new Customer());
        }

        return modelAndView;
    }


    @PostMapping("/create")
    public ModelAndView doCreate(@ModelAttribute Customer customer) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/modal_createCus");

        try {
            customerService.save(customer);

            modelAndView.addObject("success", "New customer add success");
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("error", "Bad data");
        }

        modelAndView.addObject("customer", new Customer());

        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView doUpdate(@PathVariable Long id, @ModelAttribute Customer customer) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/modal_updateCus");

        try {
            customer.setId(id);
            customerService.save(customer);

            modelAndView.addObject("customer", customer);
            modelAndView.addObject("success", "Update customer success");
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("error", "Bad data");
            modelAndView.addObject("customer", new Customer());
        }

        return modelAndView;
    }
}

