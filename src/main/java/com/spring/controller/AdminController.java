package com.spring.controller;

import com.spring.model.Author;
import com.spring.model.Product;
import com.spring.service.AuthorService;
import com.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ProductService productService;

    @Autowired
    AuthorService authorService;

    @GetMapping("/products")
    public String products(Model model,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "size", defaultValue = "5") int size) {
        model.addAttribute("products",productService.getAll(page,size));
        return "admin/products/list";
    }

    @GetMapping("/products/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "admin/products/add";
    }

    @PostMapping("/products/add")
    public String addProduct(@RequestParam String id,
                             @RequestParam String name,
                             @RequestParam Double price,
                             @RequestParam Integer totalSold,
                             @RequestParam String image,
                             @RequestParam String authorId) {
        productService.addProduct(id, name, price, totalSold, image, authorId);
        return "redirect:/admin/products";
    }



    @GetMapping("/products/edit/{id}")
    public String editProduct(Model model,@PathVariable String id) {
        Product existingProduct = productService.getById(id);
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("product", existingProduct);
        model.addAttribute("authors", authors);
        return "admin/products/edit";
    }

    @PostMapping("/products/edit/{id}")
    public String editProduct(@PathVariable String id,
                              @RequestParam String name,
                              @RequestParam Double price,
                              @RequestParam Integer totalSold,
                              @RequestParam String image,
                              @RequestParam String authorId) {
        productService.updateProduct(id, name, price, totalSold, image, authorId);
        return "redirect:/admin/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        productService.delete(id);
        return "redirect:/admin/products";
    }
}
