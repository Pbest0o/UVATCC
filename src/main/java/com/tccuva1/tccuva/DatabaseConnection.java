package com.tccuva1.tccuva;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {


    public static Connection createConnection() throws ClassNotFoundException, URISyntaxException{
         try {

            URI dbUri = new URI(System.getenv("DATABASE_URL"));

            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        
            return DriverManager.getConnection(dbUrl, username, password);
            
        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet makeQuery(String query) throws ClassNotFoundException, URISyntaxException{
        ResultSet resultSet = null;
        try {
            Connection c = DatabaseConnection.createConnection();
            Statement statement = c.createStatement();
            String selectSql = "Select \"Nome\" from public.\"Lead\"" ;
            resultSet = statement.executeQuery(selectSql);

            while(resultSet.next()){
                System.out.println(resultSet.getString(1));

                
            }
            return resultSet;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }   
}