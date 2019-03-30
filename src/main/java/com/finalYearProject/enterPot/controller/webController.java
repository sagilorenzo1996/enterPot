package com.finalYearProject.enterPot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class webController {

    @GetMapping("/")
    public Object home() {
        return "index.html";
    }

    @GetMapping("/login")
    public Object login() {
        return "index.html";
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
