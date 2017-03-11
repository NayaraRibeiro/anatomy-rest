package br.com.appanatomy.tasks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest")
public class HelloWorld {
    @RequestMapping("/helloWorld")
    public String execute() {
        System.out.println("Spring MVC aqui!");
        return "ok";
    }
}
