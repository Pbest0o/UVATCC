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

    // Type Mapping:
    // 0 = Insert
    // 1 = Select
    public static ResultSet makeQuery(int type,String query) throws ClassNotFoundException, URISyntaxException{
        ResultSet resultSet = null;


        try {
            Connection c = DatabaseConnection.createConnection();
            Statement statement = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            if(type == 0){
                statement.executeQuery(query);
                return null;
            } else if(type == 1){
                resultSet = statement.executeQuery(query);
                return resultSet;
            }
            

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }   
}