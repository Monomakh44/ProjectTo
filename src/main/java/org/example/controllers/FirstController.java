package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(Model model, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname) {
        model.addAttribute("message", "Hello, " + name + " " + surname);
        System.out.println("Hello, " + name + " " + surname);
        return "first/hello_first";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye_first";
    }
    @GetMapping("/calculator")
    public String calculator(Model model, @RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("action") String action){
        double result;
        switch (action){
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double)b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "addition":
                result = a + b;
                break;
            default:
                result = 0;
        }
        model.addAttribute("result", result);
        return "first/calculator";
    }
}
