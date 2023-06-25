package com.homebakery.homebakery.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homebakery.homebakery.service.CategoryService;
import com.homebakery.homebakery.service.ProductService;

@Controller
public class HomeController {

    // Fields
    private CategoryService categoryService;
    private ProductService productService;

    // Constructor
    public HomeController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    // Mappings
    @GetMapping({ "/", "/home" })
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("products", productService.findAll());
        return "shop/products";
    }

    @GetMapping("/shop/category")
    public String shopByCategory(@RequestParam("id") int id, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("products", productService.findAllProductByCategoryId(id));

        return "shop/products";
    }

    @GetMapping("/shop/product")
    public String viewProduct(@RequestParam("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));

        return "/shop/product-details";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

}
