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
    
}
