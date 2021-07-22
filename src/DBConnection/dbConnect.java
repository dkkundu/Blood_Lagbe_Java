/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dipto
 */
public class dbConnect {
    public Connection getConnection(){
        String sql_url = "jdbc:mysql://localhost:3306/blood_lagbe";
        String user_name = "dipto";
        String passwd = "dk60606";
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(sql_url, user_name, passwd);
            System.out.println("Sucessfully Database connected");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Sorry Unable to connect with Database"+ ex);
            return null;
          
        }
        
    }
    
}
