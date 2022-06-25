package com.tccuva1.tccuva;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping("/hello")
    public String welcome(){
        return "hello";
    }

    @RequestMapping("/helloagain")
    public String display(){
        return "final";
    }
    
}
