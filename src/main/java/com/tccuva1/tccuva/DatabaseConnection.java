package com.tccuva1.tccuva;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {


    public static void createConnection() throws ClassNotFoundException, URISyntaxException{
        /* 
        String url = "jdbc:postgres://lirbgwsmobmsbb:45a31ccead123ab78ba6ef0a719744999157d94ef5c0ea69703c05d81095fc62@ec2-3-217-251-77.compute-1.amazonaws.com:5432/diqqotinlaii4";
        Properties props = new Properties();
        props.setProperty("user","lirbgwsmobmsbb");
        props.setProperty("password","45a31ccead123ab78ba6ef0a719744999157d94ef5c0ea69703c05d81095fc62");
        props.setProperty("ssl","true");
        */
        try {

            URI dbUri = new URI(System.getenv("DATABASE_URL"));

            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        
            DriverManager.getConnection(dbUrl, username, password);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}
