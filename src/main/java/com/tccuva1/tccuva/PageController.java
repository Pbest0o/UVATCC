package com.tccuva1.tccuva;

import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @GetMapping("/lead")
    public String lead( ModelMap model){
        
        model.addAttribute("leadsList", LeadController.getAllLeads());
        model.addAttribute("lead", new Lead("", "", "", "", "", ""));

        return "lead";
    }

    @PostMapping("/lead")
    public String createLead(@ModelAttribute Lead lead, ModelMap model){
        System.out.println("Criou Lead: " + LeadController.createLead(lead).getCod_lead());

        model.addAttribute("lead",lead);
        return "leadDetail";
    }

    @GetMapping("/leadDetail")
    public String leadDetail(){
        return "leadDetail";
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
