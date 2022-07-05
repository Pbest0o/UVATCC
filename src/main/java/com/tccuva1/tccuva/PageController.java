package com.tccuva1.tccuva;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
public class PageController {

    

    @GetMapping("/lead")
    public String lead( ModelMap model){
        
        model.addAttribute("leadsList", LeadController.getAllLeads());
        model.addAttribute("lead", new Lead("", "", "", "", "", ""));

        return "lead";
    }


    @GetMapping("/leadDetail/{id}")
    public String leadDetail(@PathVariable String id,ModelMap model){
        Lead lead = LeadController.getLead(id);
        model.addAttribute("data", lead);
        return "leadDetail";
    }


    @GetMapping("/cliente")
    public String cliente(ModelMap model){
        model.addAttribute("clientList", ClienteController.getAllClientes());
        
        return "cliente";
    }

    @GetMapping("/clienteDetail/{id}")
    public String clientDetail(@PathVariable String id,ModelMap model){
        Cliente cliente = ClienteController.getCliente(id);
        Venda venda = null;
        model.addAttribute("client", cliente);
        model.addAttribute("venda", venda);
        
        return "clienteDetail";
    }

    @GetMapping("/venda")
    public String venda(ModelMap model){
        model.addAttribute("vendasList", VendaController.getAllVendas());

        return "venda";
    }

    @GetMapping("/atendimento")
    public String atendimento(){
        return "atendimento";
    }
    
}
