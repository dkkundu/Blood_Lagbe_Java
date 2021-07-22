/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodlagbe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author dipto
 */
public class DashboardController implements Initializable {
    

    @FXML
    void btnAddRecord(ActionEvent event) throws IOException {
        System.out.println("Clicked BTN ADD RECORD");
        Parent root = FXMLLoader.load(getClass().getResource("/addRecord/addRecord.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Add Record");
        stage.setScene(scene);
        stage.show();

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
