/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;

/**
 *
 * @author Abdalaziz Abdallah
 */
public class DAO {

    //TODO: "DAO class" insert all queries as function here 

    private Connection connection;

    public DAO() {
        try {
            connection = DBConnection.getInstance().getConn();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
