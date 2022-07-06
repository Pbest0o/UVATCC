package com.tccuva1.tccuva;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClienteController {

    public static List <Cliente> getAllClientes(){

        List <Cliente> clientes = new ArrayList<>();
        ResultSet resultSet = null;
        
        try {
            resultSet = DatabaseConnection.makeQuery(1,"SELECT \"Cod_Cliente\", \"Cod_Lead\", \"Nome\", \"Email\", \"Idade\", \"Qtd_Compras\", \"Qtd_Atendimentos\", \"Data_Criacao\" FROM public.\"Cliente\" ORDER BY \"Cod_Cliente\" DESC ;");

            //resultSet.next();
            //System.out.println("Here Cliente: " + resultSet.getString(1));

            while(resultSet.next()){
                clientes.add( new Cliente(resultSet.getString(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(4), 
                resultSet.getString(5), resultSet.getString(6), 
                resultSet.getString(7), resultSet.getString(8)));
            }

            //System.out.println("LeadController: " + leads);
            return clientes;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }

    public static Cliente getCliente(String id){
        
        Cliente cliente = null;
        ResultSet resultSet;

        try{
            String query = "SELECT \"Cod_Cliente\", \"Cod_Lead\", \"Nome\", \"Email\", \"Idade\", \"Qtd_Compras\", \"Qtd_Atendimentos\", \"Data_Criacao\"FROM public.\"Cliente\" WHERE \"Cod_Cliente\" =" +id + ";";
            System.out.println("Query: " + query);

            resultSet = DatabaseConnection.makeQuery(1,query);

            while(resultSet.next()){
                cliente = new Cliente(resultSet.getString(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(4), 
                resultSet.getString(5), resultSet.getString(6), 
                resultSet.getString(7), resultSet.getString(8));
            }

            return cliente;
        } catch(Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @PostMapping("/updateCliente")
    @ResponseBody
    public static Boolean updateCliente(@RequestBody Map <String,String> json){

        String nome = json.get("nome");
        String email = json.get("email");
        String idade = json.get("idade");
        String cod_cliente = json.get("cod_cliente");

        try{

            String updateQuery = "UPDATE public.\"Cliente\" SET \"Nome\"=\'" + nome +"\',\"Email\" = \'" + email +"\', \"Idade\" = " + idade+" WHERE \"Cod_Cliente\"=\'"+ cod_cliente+ "\';";
            System.out.println("Update Query: " + updateQuery);
            DatabaseConnection.makeQuery(0,updateQuery);
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }


    @PostMapping("/deleteCliente")
    @ResponseBody
    public static boolean deleteCliente(@RequestBody Map <String,String> json){

        String id = json.get("id");

        try{
            String deleteQueryAtendimento = "DELETE FROM public.\"Atendimento\" WHERE \"Cod_Cliente\" = \'"+id+"';";
            String deleteQueryVenda = "DELETE FROM public.\"Venda\" WHERE \"Cod_Cliente\" = \'"+id+"';";
            String deleteQueryCliente = "DELETE FROM public.\"Cliente\" WHERE \"Cod_Cliente\" = \'"+id+"';";
            System.out.println("Delete Query: " + deleteQueryAtendimento);
            DatabaseConnection.makeQuery(0,deleteQueryAtendimento);
            DatabaseConnection.makeQuery(0,deleteQueryVenda);
            DatabaseConnection.makeQuery(0,deleteQueryCliente);
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    
}
