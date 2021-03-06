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
            resultSet = DatabaseConnection.makeQuery(1,"SELECT \"Nome\", \"Email\", \"Cod_Lead\", \"Idade\", \"Canal\", \"Data_Criacao\" FROM public.\"Lead\" WHERE \"Convertido\" = false ORDER BY \"Cod_Lead\" DESC ;");

            while(resultSet.next()){
                leads.add( new Lead(resultSet.getString(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(4), 
                resultSet.getString(5), resultSet.getString(6)));
            }

            return leads;
            
        } catch (Exception e) {
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

            String selectQuery = "SELECT \"Nome\", \"Email\", \"Cod_Lead\", \"Idade\", \"Canal\", \"Data_Criacao\" FROM public.\"Lead\" ORDER BY \"Cod_Lead\" DESC;";
            System.out.println("Select Query: " + selectQuery);
            resultSet = DatabaseConnection.makeQuery(1,selectQuery);
            

            while(resultSet.next()){
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


    @PostMapping("/updateLead")
    @ResponseBody
    public static Boolean updateLead(@RequestBody Map <String,String> json){

        String nome = json.get("nome");
        String email = json.get("email");
        String idade = json.get("idade");
        String canal = json.get("canal");
        String codLead = json.get("codLead");

        try{

            String updateQuery = "UPDATE public.\"Lead\" SET \"Nome\"=\'" + nome +"\',\"Email\" = \'" +email +"\', \"Idade\" = " +Integer.valueOf(idade)+", \"Canal\" =\'" + canal+ "\' WHERE \"Cod_Lead\"=\'"+ codLead+ "\';";
            System.out.println("Update Query: " + updateQuery);
            DatabaseConnection.makeQuery(0,updateQuery);
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }


    @PostMapping("/deleteLead")
    @ResponseBody
    public static void deleteLead(@RequestBody Map <String,String> json){

        String id = json.get("id");

        try{
            String deleteQuery = "DELETE FROM public.\"Lead\" WHERE \"Cod_Lead\" = \'"+id+"';";
            System.out.println("Delete Query: " + deleteQuery);
            DatabaseConnection.makeQuery(0,deleteQuery);
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    @PostMapping("/convertLead")
    @ResponseBody
    public static boolean convertLead(@RequestBody Map <String,String> json){

        String id = json.get("id");
        Lead lead = LeadController.getLead(id);
        try{
            String convertQuery1 = "UPDATE public.\"Lead\" SET \"Convertido\"= true WHERE \"Cod_Lead\" = \'"+id+"';";
            String convertQuery2 = "INSERT INTO public.\"Cliente\"(\"Cod_Lead\", \"Nome\", \"Email\", \"Idade\", \"Data_Criacao\") VALUES ("+ id +", \'" +lead.name  +"\', \'" + lead.email +"\', " +Integer.valueOf(lead.idade)+", current_timestamp) ;";
            System.out.println("Convert Query 1: " + convertQuery1);
            System.out.println("Convert Query 2: " + convertQuery2);


            DatabaseConnection.makeQuery(0,convertQuery1);
            DatabaseConnection.makeQuery(0,convertQuery2);
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
            
        }

    }

    
}
