package com.tccuva1.tccuva;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping("/lead")
    public String welcome(){
        return "lead";
    }

    @RequestMapping("/cliente")
    public String display(){
        return "cliente";
    }

    @RequestMapping("/venda")
    public String welcome(){
        return "venda";
    }

    @RequestMapping("/atendimento")
    public String welcome(){
        return "atendimento";
    }
    
}
