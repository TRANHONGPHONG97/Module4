package com.codegym.ss7_c0222g1.controller;



import com.codegym.ss7_c0222g1.model.Product;
import com.codegym.ss7_c0222g1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("productList",productList);
        return "listProduct";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "createProduct";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if(result.hasErrors()) {
            return "createProduct";
        } else {
            productService.save(product);
            return "redirect:/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "editProduct";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if(result.hasErrors()) {
            return "editProduct";
        } else {
            productService.save(product);
            return "redirect:/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, Model model) {
        productService.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/viewProduct";
    }

    @GetMapping("/search")
    public String search(Product product, Model model) {
        model.addAttribute("productList", productService.searchByName(product));
        return "listProduct";
    }
}
