package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    private IRegisterService iRegisterService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("userList", iRegisterService.findAll());
        return "list_form";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/list")
    public String save(@Valid User user, BindingResult result) {
        if (result.hasErrors()){
            return "form";
        } else {
            iRegisterService.save(user);
            return "list_form";
        }
    }
}
