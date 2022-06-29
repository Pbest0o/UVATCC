package com.tccuva1.tccuva;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/lead")
    public String lead(){

        DatabaseConnection.createConnection();
        return "lead";
    }

    @RequestMapping("/cliente")
    public String cliente(){
        return "cliente";
    }

    @RequestMapping("/venda")
    public String venda(){
        return "venda";
    }

    @RequestMapping("/atendimento")
    public String atendimento(){
        return "atendimento";
    }
    
}
