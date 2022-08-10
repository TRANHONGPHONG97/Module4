package com.codegym.ss7_c0222g1.controller;

import com.codegym.ss7_c0222g1.model.User;
import com.codegym.ss7_c0222g1.service.IRegisterService;
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
        return "registerList";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping("/save")
    public String save(@Valid User user, BindingResult result) {
        if (result.hasErrors()){
            return "registerForm";
        } else {
            iRegisterService.save(user);
            return "redirect:/list";
        }
    }
}
