package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.HibernateCustomerService;
import com.codegym.service.impl.HibernateCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private HibernateCustomerService hibernateCustomerService;
//    HibernateCustomerService hibernateCustomerService = new HibernateCustomerServiceImpl();

    @GetMapping()
    public ModelAndView showCustomerListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/list");
        List<Customer> customerList = hibernateCustomerService.findAll();
        modelAndView.addObject("customers", customerList);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showCustomerByIdPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/info");
        Customer customer = hibernateCustomerService.findOne(id);
        modelAndView.addObject("customer", customer);
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
    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("customer", hibernateCustomerService.findOne(id));
        return "customer/view";


    }
//    @GetMapping("/customers")
//    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable){
//        Page<Customer> customers;
//        if(search.isPresent()){
//            customers = hibernateCustomerService.findAllByFirstNameContaining(search.get(), pageable);
//        } else {
//            customers = hibernateCustomerService.findAll(pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }
//    @GetMapping("/search")
//    public String search(Customer customer, Model model) {
//        model.addAttribute("customerList", hibernateCustomerService.searchByName(customer));
//        return "customer/list";
//    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute Customer customer) {
        hibernateCustomerService.save(customer);
        return "redirect:/customers";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute Customer customer) {
        hibernateCustomerService.save(customer);
        return "redirect:/customers";
    }
    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Customer customer = hibernateCustomerService.findOne(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        hibernateCustomerService.remove(customer.getId());
        return "redirect:/customers";
    }
}
