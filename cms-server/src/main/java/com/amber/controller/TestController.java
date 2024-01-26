package com.amber.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String getTest() {
        return "Hello, World!";
    }
}
