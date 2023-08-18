package com.udemey.course1.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {

    // expose '/' hello world
    @GetMapping("/")
    public String sayHello() {
        return "Hello world";
    }

    // expose "/funtime" that returns hi there
    @GetMapping("/funtime")
    public String sayHi() {
        return "hi there";
    }
}
