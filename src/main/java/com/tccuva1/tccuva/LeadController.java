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
public class LeadController {

    public static List <Lead> getAllLeads(){

        List <Lead> leads = new ArrayList<>();
        ResultSet resultSet = null;
        
        try {
            resultSet = DatabaseConnection.makeQuery(1,"SELECT \"Nome\", \"Email\", \"Cod_Lead\", \"Idade\", \"Canal\", \"Data_Criacao\" FROM public.\"Lead\" ORDER BY \"Cod_Lead\" DESC;");

            resultSet.next();
            System.out.println("Here 1: " + resultSet.getString(1));

            while(resultSet.next()){
                leads.add( new Lead(resultSet.getString(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(4), 
                resultSet.getString(5), resultSet.getString(6)));
            }

            //System.out.println("LeadController: " + leads);
            return leads;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }

    @PostMapping("/createLead")
    @ResponseBody
    public static String createLead(@RequestBody Map <String,String> json){
        
        String nome = json.get("nome");
        String email = json.get("email");
        String idade = json.get("idade");
        String canal = json.get("canal");
        
        Lead dbLead = null;

        try{
            ResultSet resultSet;
            String insertQuery = "INSERT INTO public.\"Lead\"(\"Nome\", \"Email\", \"Idade\", \"Canal\", \"Data_Criacao\")VALUES ( \'" + nome + " \' , \'" + email +" \' ,  "+Integer.valueOf(idade)+ "  , \' " + canal + "\' ,current_timestamp);";
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
            return dbLead.getCod_lead();
            
        } catch(Exception e) {
            e.printStackTrace();
            return "-1";

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

    public static void deleteLead(String id){

        try{

            String deleteQuery = "DELETE FROM public.\"Lead\" WHERE \"Cod_Lead\" = \'"+id+"';";
            
            
            System.out.println("Delete Query: " + deleteQuery);
            DatabaseConnection.makeQuery(0,deleteQuery);
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    
}
