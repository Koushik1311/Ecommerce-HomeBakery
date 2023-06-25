package com.homebakery.homebakery.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homebakery.homebakery.model.Category;
import com.homebakery.homebakery.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String categoryList(Model model) {

        List<Category> categories = categoryService.findAll();

        model.addAttribute("categories", categories);

        return "admin/categories";
    }

    @GetMapping("/add")
    public String categoryAdd(Model model) {
        model.addAttribute("category", new Category());

        return "admin/category-add";
    }

    @PostMapping("/add")
    public String categorySave(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/update")
    public String categoryUpdate(@RequestParam("id") int id, Model model) {

        Category tempCategory = categoryService.findById(id);
        model.addAttribute("category", tempCategory);
        return "admin/category-add";
    }

    @GetMapping("/delete")
    public String categoryDelete(@RequestParam("id") int id) {
        categoryService.deleteById(id);
        return "redirect:/admin/categories";
    }

}
