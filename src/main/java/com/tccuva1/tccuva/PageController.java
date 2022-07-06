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

        model.addAttribute("client", cliente);
        model.addAttribute("vendasList", VendaController.getAllVendasFromClient(id));
        model.addAttribute("atendimentosList", AtendimentoController.getAllAtendimentos(id));
        
        //model.addAttribute("venda", new Venda("", "", "", "", ""));
        
        return "clienteDetail";
    }

    @GetMapping("/venda")
    public String venda(ModelMap model){
        model.addAttribute("vendasList", VendaController.getAllVendas());

        return "venda";
    }

    @GetMapping("/atendimento")
    public String atendimento(ModelMap model){
        model.addAttribute("atendimentoList", AtendimentoController.getAllAtendimentos());
        return "atendimento";
    }

    @GetMapping("/vendaDetail/{id}")
    public String vendaDetail(@PathVariable String id,ModelMap model){
        Venda venda = VendaController.getVenda(id);
        model.addAttribute("data", venda);
        return "vendaDetail";
    }

    @GetMapping("/atendimentoDetail/{id}")
    public String atendimentoDetail(@PathVariable String id,ModelMap model){
        Atendimento atendimento = AtendimentoController.getAtendimento(id);
        model.addAttribute("data", atendimento);
        return "atendimentoDetail";
    }
    
}
