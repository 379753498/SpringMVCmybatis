package com.devtest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HellowordController {
    @GetMapping
    @RequestMapping("/print")
    public String  PrintHelloController()
    {
        String Print="helloworld";
        System.out.println(Print);
        return Print;
    }

    @GetMapping
    @RequestMapping("/print2")
    public String  PrintHelloController(String Print)
    {
        System.out.println(Print);
        return Print;
    }

}
