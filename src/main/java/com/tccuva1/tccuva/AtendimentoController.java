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
public class AtendimentoController {

    public static List <Atendimento> getAllAtendimentos(){

        List <Atendimento> atendimentos = new ArrayList<>();
        ResultSet resultSet = null;
        
        try {
            resultSet = DatabaseConnection.makeQuery(1,"SELECT * FROM public.\"Atendimento\" ORDER BY \"Cod_Atendimento\" ;");

            while(resultSet.next()){
                atendimentos.add( new Atendimento(resultSet.getString(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(4), 
                resultSet.getString(5), resultSet.getString(6)));
            }

            return atendimentos;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }

    public static List <Atendimento> getAllAtendimentos(String clientId){

        List <Atendimento> atendimentos = new ArrayList<>();
        ResultSet resultSet = null;
        
        try {
            resultSet = DatabaseConnection.makeQuery(1,"SELECT * FROM public.\"Atendimento\" WHERE \"Cod_Cliente\" = "+clientId+" ORDER BY \"Cod_Atendimento\" DESC;");

            while(resultSet.next()){
                atendimentos.add( new Atendimento(resultSet.getString(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(4), 
                resultSet.getString(5), resultSet.getString(6)));
            }

            return atendimentos;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }

    @PostMapping("/createAtendimento")
    @ResponseBody
    public static Boolean createAtendimento(@RequestBody Map <String,String> json){
        
        String atendimentoTipo = json.get("atendimentoTipo");
        String atendimentoComentario = json.get("atendimentoComentario");
        String atendimentoStatus = json.get("atendimentoStatus");
        String atendimentoCodCliente = json.get("atendimentoCodCliente");

        try{
            
            String insertQuery = "INSERT INTO public.\"Atendimento\"(\"Cod_Cliente\", \"Tipo_Atendimento\", \"Comentario\", \"Status\", \"Data_Criacao\")VALUES ( \'" + atendimentoCodCliente + "\' , \'" + atendimentoTipo +" \' , \'"+atendimentoComentario+ "\'  , \'" + atendimentoStatus + "\' ,current_timestamp);";
            System.out.println("Query: " + insertQuery);
            DatabaseConnection.makeQuery(0,insertQuery);
            return true;
            
        } catch(Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public static Atendimento getAtendimento(String id){
        
        Atendimento atendimento = null;
        ResultSet resultSet;

        try{
            String query = "SELECT * FROM public.\"Atendimento\" WHERE \"Cod_Atendimento\" = "+id+" ORDER BY \"Cod_Atendimento\" DESC;";
            System.out.println("Query: " + query);

            resultSet = DatabaseConnection.makeQuery(1,query);

            while(resultSet.next()){
                atendimento = new Atendimento(resultSet.getString(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(4), 
                resultSet.getString(5), resultSet.getString(6));
            }

            return atendimento;
        } catch(Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @PostMapping("/updateAtendimento")
    @ResponseBody
    public static Boolean updateAtendimento(@RequestBody Map <String,String> json){

        String cod_atendimento = json.get("cod_atendimento");
        String tipo_atendimento = json.get("tipo_atendimento");
        String comentario = json.get("comentario");
        String status = json.get("status");

        try{

            String updateQuery = "UPDATE public.\"Atendimento\" SET \"Tipo_Atendimento\"=\'" + tipo_atendimento +"\',\"Comentario\" = \'" + comentario +"\',\"Status\" = \'" +status +"\' WHERE \"Cod_Atendimento\"=\'"+ cod_atendimento+ "\';";
            System.out.println("Update Query: " + updateQuery);
            DatabaseConnection.makeQuery(0,updateQuery);
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }


    @PostMapping("/deleteAtendimento")
    @ResponseBody
    public static boolean deleteAtendimento(@RequestBody Map <String,String> json){

        String id = json.get("id");

        try{
            String deleteQueryVenda = "DELETE FROM public.\"Atendimento\" WHERE \"Cod_Atendimento\" = \'"+id+"';";
            
            System.out.println("Delete Query: " + deleteQueryVenda);
            DatabaseConnection.makeQuery(0,deleteQueryVenda);
            
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    
}
