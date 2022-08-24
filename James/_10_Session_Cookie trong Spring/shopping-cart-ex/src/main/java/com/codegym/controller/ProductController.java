package com.codegym.controller;


import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(Long.valueOf(id)).get());
        return "/view";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(Long.valueOf(id));
        if (!productOptional.isPresent()) {
            return "/error";
        }
        if (action.equals("increase")) {
            cart.addProduct(productOptional.get());
            cart.countItemQuantity();
            return "redirect:/shopping-cart";
        }
        if (action.equals("decrease")) {
            cart.removeProduct(productOptional.get());
            cart.countItemQuantity();
            return "redirect:/shopping-cart";
        }
        if (action.equals("delete")) {
            cart.deleteNowProduct(productOptional.get());
            cart.countItemQuantity();
            return "redirect:/shopping-cart";
        }
        if (action.equals("pay")) {
            cart.pay();
            cart.countItemQuantity();
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/remove")
    public String addToCart(@ModelAttribute Cart cart, @RequestParam("action") String action) {
        if (action.equals("pay")) {
            cart.pay();
            cart.countItemQuantity();
        }
        return "redirect:/shop";
    }
}