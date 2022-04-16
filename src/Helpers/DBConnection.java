/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author Abdalaziz Abdallah
 */
public class DBConnection {
       
    private static DBConnection instance=null;
    private String oracleDrive = "jdbc:oracle:thin:";
    private String oracleLocalHost = "@//";
    private String oraclePort = "/XE";
    private Connection conn=null;
    
    
    public static DBConnection getInstance() {
        if(instance ==null){
            instance = new DBConnection();
        }
        return instance;
    }

    public DBConnection() {
        conn = createDBConnection("localhost","1521","lab1","lab1");
    }
    
    
    private String getFullUri(String localhost,String portNumber){
        return oracleDrive+oracleLocalHost+localhost+":"+portNumber+oraclePort;
    }
    
    private Connection createDBConnection(String localhost,String portNumber,String username,String password){
     try {
            DriverManager.registerDriver(new OracleDriver());    //This is for loading the odbc driver
            System.out.println("Driver loaded Successfully");
            String fullUri = getFullUri(localhost,portNumber);
            conn = DriverManager.getConnection(fullUri, username, password); //connecting to the database
            System.out.println("Connection Successful");
        
           return conn;

        } catch (SQLException e) {
            System.out.println("Some problem in connection");
            e.printStackTrace();
        }

        return null;
    }
    
    //TODO: "DBConnection class" insert all queries as function here 
    
    
    
    
    
    
}
