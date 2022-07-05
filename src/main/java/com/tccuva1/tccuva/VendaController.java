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
public class VendaController {

    public static List <Venda> getAllVendas(){

        List <Venda> vendas = new ArrayList<>();
        ResultSet resultSet = null;
        
        try {
            resultSet = DatabaseConnection.makeQuery(1,"SELECT \"Cod_Vendas\", \"Cod_Cliente\", \"Qnt_Itens\", \"Vlr_Compra\", \"Data_Criacao\" FROM public.\"Vendas\" ORDER BY \"Cod_Vendas\" DESC;");

            while(resultSet.next()){
                vendas.add( new Venda(resultSet.getString(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(4), 
                resultSet.getString(5)));
            }

            return vendas;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }

    public static List <Venda> getAllVendasFromClient(String clientId){

        String id = clientId;

        List <Venda> vendas = new ArrayList<>();
        ResultSet resultSet = null;
        
        try {
            resultSet = DatabaseConnection.makeQuery(1,"SELECT \"Cod_Vendas\", \"Cod_Cliente\", \"Qnt_Itens\", \"Vlr_Compra\", \"Data_Criacao\" FROM public.\"Vendas\" WHERE \"Cod_Cliente\" = " + id + " ORDER BY \"Cod_Vendas\" DESC;");

            while(resultSet.next()){
                vendas.add( new Venda(resultSet.getString(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(4), 
                resultSet.getString(5)));
            }

            return vendas;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }

    @PostMapping("/createVenda")
    @ResponseBody
    public static String createVenda(@RequestBody Map <String,String> json ){

        String vendaVlr = json.get("vendaVlr");
        String vendaQtnItems = json.get("vendaQtdItems");
        String vendaCodCliente = json.get("vendaCodCliente");
        
        Venda dbVenda = null;

        try{
            ResultSet resultSet;
            String insertQuery = "INSERT INTO public.\"Vendas\"(\"Cod_Cliente\", \"Qnt_Itens\", \"Vlr_Compra\", \"Data_Criacao\") VALUES ( \'" + vendaCodCliente + "\' , " + vendaQtnItems +" ,  "+vendaVlr+ "  , current_timestamp);";
            System.out.println("Query: " + insertQuery);

            DatabaseConnection.makeQuery(0,insertQuery);

            String selectQuery = "SELECT * FROM public.\"Vendas\" ;";
            System.out.println("Select Query: " + selectQuery);
            resultSet = DatabaseConnection.makeQuery(1,selectQuery);
            resultSet.afterLast();

            while(resultSet.previous()){
                dbVenda = new Venda(resultSet.getString(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(4), 
                resultSet.getString(5));
                break;
            }
            return dbVenda.cod_vendas;
            
        } catch(Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public static Venda getVenda(String id){
        
        Venda venda = null;
        ResultSet resultSet;

        try{
            String query = "SELECT \"Cod_Vendas\", \"Cod_Cliente\", \"Qnt_Itens\", \"Vlr_Compra\", \"Data_Criacao\" FROM public.\"Vendas\" WHERE \"Cod_Vendas\" = " + id + " ;";
            System.out.println("Query: " + query);

            resultSet = DatabaseConnection.makeQuery(1,query);

            while(resultSet.next()){
                venda = new Venda(resultSet.getString(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(4), 
                resultSet.getString(5));
                break;
            }

            return venda;
        } catch(Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public static Lead updateLead(Lead lead,String id){

        try{

            String updateQuery = "UPDATE public.\"Lead\" SET \"Nome\"=\'" + lead.name +"\',\"Email\" = \'" +lead.email +"\', \"Idade\" = " +lead.idade+", \"Canal\" =\'" + lead.canal+ "\' WHERE \"Cod_Lead\"=\'"+ id+ "\';";
            System.out.println("Update Query: " + updateQuery);
            DatabaseConnection.makeQuery(0,updateQuery);
            return lead;
        } catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    
}
