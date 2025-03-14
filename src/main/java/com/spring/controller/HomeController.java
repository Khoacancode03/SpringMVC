package com.spring.controller;

import com.spring.model.Author;
import com.spring.model.Product;
import com.spring.model.Student;
import com.spring.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;

    @RequestMapping("/home")
    public String homePage(HttpServletRequest request){
        //model of MVC
        String message = "Hello Spring MVC!";
        request.setAttribute("mess", message);

        Student student = new Student();
        student.setName("Student");

        request.setAttribute("std", student);
        // Return the view name for the home page (src/resources/templates/layout.html)
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage(HttpServletRequest request){
        return "about";
    }

    @GetMapping("/products")
    public String productPage(Model model){
        model.addAttribute("productList", productService.getAll());
        return "product";
    }

    @GetMapping("/products/{id}")
    public String productPage(@PathVariable String id, ModelMap modelMap){
        modelMap.addAttribute("product",productService.getOne(id));
        return "product_detail";
    }
}
