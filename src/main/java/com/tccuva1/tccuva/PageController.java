package com.tccuva1.tccuva;

import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @RequestMapping(value = "/lead",method = RequestMethod.GET)
    public String lead(ModelMap model){
        
        model.addAttribute("leadsList", LeadController.getAllLeads());
        model.addAttribute("newLead", new Lead("", "", "", "", "", ""));

        return "lead.html";
    }

    @RequestMapping(value = "/lead",method = RequestMethod.POST)
    public String createLead( ModelMap model){
        
        //model.addAttribute("lead", lead);

        return "cliente";
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
