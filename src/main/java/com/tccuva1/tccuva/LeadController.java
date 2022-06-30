package com.tccuva1.tccuva;

import java.beans.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;

public class LeadController {


    public static List <Lead> getAllLeads(){

        List <Lead> leads = new ArrayList<>();
        ResultSet resultSet = null;
        
        try {
            resultSet = DatabaseConnection.makeQuery("SELECT \"Nome\", \"Email\", \"Cod_Lead\", \"Idade\", \"Canal\", \"Data_Criacao\" FROM public.\"Lead\";");

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
    
}
