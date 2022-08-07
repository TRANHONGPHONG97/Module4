package com.codegym.controller;

import com.codegym.service.Dictionary;
import com.codegym.service.IDictionary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryAppController {
    @GetMapping("/DictionaryAppController")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @PostMapping("/DictionaryAppController")
    public String greeting(String inputWord, Model model) {
        IDictionary addAttribute = new Dictionary();
        model.addAttribute("oldValue", inputWord);
        model.addAttribute("newValue", addAttribute.search(inputWord));
        return "home";
    }
}
