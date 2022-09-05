package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login");
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView showUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/list");
        return modelAndView;
    }

    @GetMapping("/products")
    public ModelAndView showProductPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/product/list");
        return modelAndView;
    }
}
