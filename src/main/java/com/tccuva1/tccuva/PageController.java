package com.tccuva1.tccuva;

import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/lead")
    public String lead(ModelMap model) throws ClassNotFoundException, URISyntaxException{

        //DatabaseConnection.createConnection();
        //DatabaseConnection.makeQuery();
        model.addAttribute("codigo", "codigo");

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
