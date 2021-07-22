/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodlagbe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


/**
 *
 * @author dipto
 */
public class DashboardController implements Initializable {
    

    @FXML
    void btnAddRecord(ActionEvent event) {
        System.out.println("Clicked BTN ADD RECORD");

    }

    @FXML
    void btnHome(ActionEvent event) {
        System.out.println("Clicked btnHome");

    }

    @FXML
    void btnMe(ActionEvent event) {
        System.out.println("Clicked btnMe");
    }

    @FXML
    void btnSearch(ActionEvent event) {
        System.out.println("Clicked btnSearch");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
