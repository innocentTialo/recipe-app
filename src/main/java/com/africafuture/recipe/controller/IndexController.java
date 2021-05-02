package com.africafuture.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = {"", "/", "/index", "index.html"})
    String getIndex(Model model) {
        System.out.println("we are in the index view 123!");
        return "index";
    }
}
