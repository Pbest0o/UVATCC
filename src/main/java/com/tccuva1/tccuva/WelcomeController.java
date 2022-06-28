package com.tccuva1.tccuva;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping("/lead")
    public String welcome(){
        return "lead";
    }

    @RequestMapping("/helloagain")
    public String display(){
        return "final";
    }
    
}
