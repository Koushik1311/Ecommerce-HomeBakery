package com.homebakery.homebakery.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Admin {
    // endpoint for "/admin" -> Admin Home Page
    @GetMapping("")
    public String adminHome() {
        return "admin/home"; // returns the home.html which is on "resourses/template/admin"
    }

    // endpoint for "/admin/users" -> Admin Users Management page

    // endpoint for "/admin/products" -> Admin Products page
    // @GetMapping("/products")
    // public String products() {
    // return "admin/products"; // returns the products.html which is on
    // "resourses/template/admin"
    // }

}
