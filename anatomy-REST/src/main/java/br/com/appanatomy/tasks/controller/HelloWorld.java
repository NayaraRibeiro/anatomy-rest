package br.com.appanatomy.tasks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
    @RequestMapping("/helloWorld")
    public String execute() {
        System.out.println("Spring MVC aqui!");
        return "ok";
    }
}

