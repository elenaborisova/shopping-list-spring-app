package com.example.shoppinglistapp.web;

import com.example.shoppinglistapp.models.entities.enums.CategoryNameEnum;
import com.example.shoppinglistapp.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("totalProductsPrice", productService.getTotalProductsPrice());
        model.addAttribute("allDrinks", productService.getAllProductsByCategoryName(
                CategoryNameEnum.DRINK));
        model.addAttribute("allFoods", productService.getAllProductsByCategoryName(
                CategoryNameEnum.FOOD));
        model.addAttribute("allHouseholds", productService.getAllProductsByCategoryName(
                CategoryNameEnum.HOUSEHOLD));
        model.addAttribute("allOthers", productService.getAllProductsByCategoryName(
                CategoryNameEnum.OTHER));

        return "home";
    }
}
