package com.finalYearProject.enterPot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class webController {

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/register")
    public String register() {
        return "register.html";
    }

    @GetMapping("/myAccount")
    public String myAccount() {
        return "myAccount.html";
    }

    @GetMapping("/all")
    public String all() {
        return "all.html";
    }

    @GetMapping("/category/{category}")
    public String category(@PathVariable String category) {
        return "category.html";
    }

    @GetMapping("/cart")
    public String itemPage(@RequestParam Long id) {
        return "item.html";
    }

    @GetMapping("/location")
    public String orderPage(@RequestParam Long id) {
        return "location.html";
    }



//    @GetMapping("/listing")
//    public Object listing() {
//        return "listing.html";
//    }
//
//    @GetMapping("/error")
//    public Object error() {
//        return "404.html";
//    }
}
