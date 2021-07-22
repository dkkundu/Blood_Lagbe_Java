/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addRecord;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author dipto
 */
public class AddRecordController implements Initializable {
    
    @FXML
    private TextField textAddress;

    @FXML
    private TextField textBloodGroup;

    @FXML
    private TextField textPhone;

    @FXML
    private TextField textName;
    
    
    
    Connection con;
    PreparedStatement pst;
    
    public void Connect()
    {
        String sql_url = "jdbc:mysql://localhost:3306/blood_lagbe";
        String user_name = "dipto";
        String passwd = "dk60606";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(sql_url, user_name, passwd);
            System.out.println("Sucessfully Database connected");
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Sorry Unable to connect with Database"+ ex);
          
        }
    }
    
    @FXML
    private void addRecord(ActionEvent event) {
        System.out.println("add clicked");
        
        Connect();
        String name = textName.getText();
        String phone = textPhone.getText();
        String blood_group = textBloodGroup.getText();
        String address = textAddress.getText();

       try {
            pst = con.prepareStatement("insert into record(name, phone, blood_group, address)values(?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, phone);
            pst.setString(3, blood_group);
            pst.setString(4, address);
            int status = pst.executeUpdate();
             
             if(status==1)
             { 
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Member");
                alert.setContentText("Record Addedd Successfully");
                alert.showAndWait();
                
                textName.setText("");
                textPhone.setText("");
                textBloodGroup.setText("");
                textAddress.setText("");
                textName.requestFocus();
                
             }
             else
             {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fail");
                alert.setHeaderText("Member");
                alert.setContentText("Record Addedd Failded");
                alert.showAndWait();
             }
            } 
          catch (SQLException ex)
       {
           Logger.getLogger(AddRecordController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connect();
        // TODO
    }    
    
}
