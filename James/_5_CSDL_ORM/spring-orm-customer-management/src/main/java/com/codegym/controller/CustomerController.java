package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

//    @Autowired
//    private HibernateCustomerService hibernateCustomerService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView showCustomerListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/list");

//        List<Customer> customerList = hibernateCustomerService.findAll();

        List<Customer> customerList = customerService.findAll();

        modelAndView.addObject("customers", customerList);

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showCustomerByIdPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/info");

//        Customer customer = hibernateCustomerService.findById(id);

        Optional<Customer> customer = customerService.findById(id);

        if (!customer.isPresent()) {
            modelAndView.setViewName("error.404");
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

    @GetMapping("/search")
    public ModelAndView showSearchResultPage(@RequestParam String search) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/list");

        search = "%" + search + "%";

//        List<Customer> customerList = customerService.findByFullNameLike(search);

//        List<Customer> customerList = customerService.findByFullNameLikeOrEmailLikeOrPhoneLikeOrAddressLike(search, search, search, search);

        List<Customer> customerList = customerService.findAllBySearchKey(search);

        modelAndView.addObject("customers", customerList);


        return modelAndView;
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute Customer customer) {
//        hibernateCustomerService.save(customer);

        customer.setId(0L);
        customerService.save(customer);
        return "redirect:/customers";
    }


    @PostMapping("/update")
    public String doUpdate(@ModelAttribute Customer customer) {
//        hibernateCustomerService.save(customer);

        customerService.save(customer);

        return "redirect:/customers";
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        } else {

            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.delete(customer);
        return "redirect:customers";
    }
//    @PostMapping("/delete")
//    public String doDelete(@ModelAttribute Customer customer) {
////        hibernateCustomerService.save(customer);
//
//        customerService.save(customer);
//
//        return "redirect:/customers";
//
//    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}
