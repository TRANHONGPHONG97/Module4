package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping({"/", "/home"})
    public String index() {
        return "home";
    }

    @GetMapping("/myLogin")
    public String showLogin() {
        return "/login/myLogin";
    }

    @GetMapping("/403")
    public String showAccessDenied() {
        return "/login/403";
    }
}
