package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceIplm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    ProductService productService = new ProductServiceIplm();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", this.productService.findAll());
        return "index";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "create";
    }

    @PostMapping("/product/create")
    public String save(Product product, RedirectAttributes redirect) {
        int id = this.productService.findAll().size() + 1;
        product.setId(id);
        this.productService.save(product);
        redirect.addFlashAttribute("success", "Created new successfully");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/update")
    public String update(@PathVariable int id, Model model) {
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect) {
        this.productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Updated product successfully");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "delete";
    }

    @PostMapping("/product/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        this.productService.remove(product.getId());
        redirect.addFlashAttribute("success", "removed product successfully");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/view")
    public String view(@PathVariable int id, Model model) {
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "view";
    }
}