package com.homebakery.homebakery.controller.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.homebakery.homebakery.dto.ProductDTO;
import com.homebakery.homebakery.model.Product;
import com.homebakery.homebakery.service.CategoryService;
import com.homebakery.homebakery.service.ProductService;

@Controller
@RequestMapping("/admin/products")
public class ProductController {

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

    private ProductService productService;
    private CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String productList(Model model) {
        List<Product> products = productService.findAll();

        model.addAttribute("products", products);

        return "/admin/products";
    }

    @GetMapping("/add")
    public String productAdd(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categories", categoryService.findAll());

        return "admin/product-add";
    }

    @PostMapping("/add")
    public String productSave(@ModelAttribute("productDTO") ProductDTO productDTO,
            @RequestParam("productImage") MultipartFile file,
            @RequestParam("imgName") String imgName) throws IOException {

        Product product = new Product();

        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCategory(categoryService.findById(productDTO.getCategoryId()));

        String imageUUID;
        if (!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            imageUUID = imgName;

        }

        product.setImageName(imageUUID);

        productService.save(product);

        return "redirect:/admin/products";
    }

    @GetMapping("/update")
    public String productUpdate(@RequestParam("id") int id, Model model) {
        // find the product by id
        Product product = productService.findById(id);

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setImageName(product.getImageName());

        // att it to the model attribute
        model.addAttribute("productDTO", productDTO);
        model.addAttribute("categories", categoryService.findAll());
        return "/admin/product-add";
    }

    @GetMapping("/delete")
    public String productDelete(@RequestParam("id") int id) {
        productService.deleteById(id);

        return "redirect:/admin/products";
    }

}
