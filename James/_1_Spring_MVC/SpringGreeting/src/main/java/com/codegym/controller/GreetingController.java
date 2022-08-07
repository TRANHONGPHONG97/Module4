package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
    @GetMapping("/greeting")

//    public String greeting( String name, Model model) {
//        name="ázexdcfvgbhnjmk";
//        model.addAttribute("name", name);
//        return "views";
@ResponseBody
    public String greeting(@RequestParam String message) {
        return message;
    }
}
