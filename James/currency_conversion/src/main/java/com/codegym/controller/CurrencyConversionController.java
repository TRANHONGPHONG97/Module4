package com.codegym.controller;

import com.codegym.service.Calculator;
import com.codegym.service.ICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyConversionController {

//    @Autowired
//    private ICalculator addAttribute;

    @GetMapping ("/CurrencyConversionController")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("home");

        return modelAndView;
    }
    @PostMapping ("/CurrencyConversionController")
    public String greeting (String amountMoney, Model model){
        ICalculator addAttribute = new Calculator();
        model.addAttribute("oldValue", amountMoney);
        try{
            model.addAttribute("newValue", addAttribute.calculator(Double.parseDouble(amountMoney)));
        }catch (NumberFormatException e){
            model.addAttribute("newValue","Nhập sai. Vui lòng nhập lại!");
        }
        return "home";
    }
}
