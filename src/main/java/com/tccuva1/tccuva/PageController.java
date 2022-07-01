package com.tccuva1.tccuva;

import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/lead")
    public String lead(ModelMap model){
        
        model.addAttribute("leadsList", LeadController.getAllLeads());
        model.addAttribute("newLead", new Lead("", "", "", "", "", ""));

        return "lead.html";
    }

    @PostMapping("/lead")
    public String createLead(@ModelAttribute Lead lead, ModelMap model){
        
        model.addAttribute("leadsList", LeadController.getAllLeads());

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
