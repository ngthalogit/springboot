package com.example.baeldung.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping(value = "/view-product")
    public String viewProduct() {
        return "/view-product";
    }
}
