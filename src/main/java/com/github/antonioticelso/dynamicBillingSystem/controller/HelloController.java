package com.github.antonioticelso.dynamicBillingSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
@RequestMapping("/helloBilling")
public class HelloController {

    @GetMapping
    public String hello() {
        return "Welcome to The Dynamic Billing";
    }

}
