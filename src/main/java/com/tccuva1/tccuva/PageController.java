package com.tccuva1.tccuva;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/lead")
    public String lead(ModelMap model) throws ClassNotFoundException, URISyntaxException{

        //DatabaseConnection.createConnection();
        //DatabaseConnection.makeQuery();
        model.addAttribute("codigo", "codigo1");

        List<Lead> myList = new ArrayList<>();

        myList.add(new Lead("Pedro","test@test.com","","","",""));


        model.addAttribute("list", myList);

        return "lead.html";
    }

    @RequestMapping("/test")
    public String test(ModelMap model) throws ClassNotFoundException, URISyntaxException{

        model.addAttribute("codigo", "codigo");

        return "webapp/web-inf/jsp/final.jsp";
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
