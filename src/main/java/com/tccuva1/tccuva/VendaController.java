package com.tccuva1.tccuva;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendaController {

    public static List <Venda> getAllVendas(){

        List <Venda> vendas = new ArrayList<>();
        ResultSet resultSet = null;
        
        try {
            resultSet = DatabaseConnection.makeQuery(1,"SELECT * FROM public.\"Vendas\" ORDER BY \"Cod_Vendas\" ;");

            resultSet.next();
            System.out.println("Here 1: " + resultSet.getString(1));

            while(resultSet.next()){
                vendas.add( new Venda(resultSet.getString(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(4), 
                resultSet.getString(5)));
            }

            //System.out.println("LeadController: " + leads);
            return vendas;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }

    public static Lead createLead(Lead lead){
        
        Lead dbLead = null;

        try{
            ResultSet resultSet;
            String insertQuery = "INSERT INTO public.\"Lead\"(\"Nome\", \"Email\", \"Idade\", \"Canal\", \"Data_Criacao\")VALUES ( \' 1" + lead.name + " \' , \'" + lead.email +" \' ,  "+lead.idade+ "  , \' " + lead.canal + "\' ,current_timestamp);";
            System.out.println("Query: " + insertQuery);

            DatabaseConnection.makeQuery(0,insertQuery);

            String selectQuery = "SELECT \"Nome\", \"Email\", \"Cod_Lead\", \"Idade\", \"Canal\", \"Data_Criacao\" FROM public.\"Lead\" ;";
            System.out.println("Select Query: " + selectQuery);
            resultSet = DatabaseConnection.makeQuery(1,selectQuery);
            resultSet.afterLast();

            while(resultSet.previous()){
                dbLead = new Lead(resultSet.getString(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(4), 
                resultSet.getString(5), resultSet.getString(6));
                break;
            }
            return dbLead;
            
        } catch(Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public static Lead getLead(String id){
        
        Lead lead = null;
        ResultSet resultSet;

        try{
            String query = "SELECT \"Nome\", \"Email\", \"Cod_Lead\", \"Idade\", \"Canal\", \"Data_Criacao\" FROM public.\"Lead\" WHERE \"Cod_Lead\" = \'"+id+"\';";
            System.out.println("Query: " + query);

            resultSet = DatabaseConnection.makeQuery(1,query);

            while(resultSet.next()){
                lead = new Lead(resultSet.getString(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(4), 
                resultSet.getString(5), resultSet.getString(6));
            }

            return lead;
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
