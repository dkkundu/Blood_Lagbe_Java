/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindDoner;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dipto
 */
public class FindDonerController implements Initializable {
    
    @FXML
    private TextField fintTxtBlood;

    @FXML
    private TableView<Doner> dataTable;

    @FXML
    private TableColumn<Doner, Integer> idColumn;

    @FXML
    private TableColumn<Doner, String> nameColumn;

    @FXML
    private TableColumn<Doner, String> phoneColumn;

    @FXML
    private TableColumn<Doner, String> bloodGroupColumn;

    @FXML
    private TableColumn<Doner, String> addressColumn;

    @FXML
    void btnFind(ActionEvent event) {
        loadFilterData();


    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       loadData();
    }
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
    
//    Normal Load
    
    public ObservableList<Doner> getDonerList(){
        ObservableList<Doner> doneList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM record";
        
        Statement st;
        ResultSet re;
        
        try{
            st=conn.createStatement();
            re = st.executeQuery(query);
            Doner record;
            while (re.next()) {
                System.out.println(re.getInt(1)+"  "+re.getString(2)+"  "+re.getString(3));  
                record = new Doner(
                        re.getInt("id"),
                        re.getString("name"),
                        re.getString("phone"),
                        re.getString("blood_group"),
                        re.getString("address")
                                );
                doneList.add(record);
                
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
        return doneList;
        
    }
    
    
    public void loadData(){
         ObservableList<Doner> list = getDonerList();
         System.out.println(list);
         idColumn.setCellValueFactory(new PropertyValueFactory<Doner,Integer>("id"));
         nameColumn.setCellValueFactory(new PropertyValueFactory<Doner, String>("name"));
         phoneColumn.setCellValueFactory(new PropertyValueFactory<Doner, String>("phone"));
         bloodGroupColumn.setCellValueFactory(new PropertyValueFactory<Doner, String>("blood_group"));
         addressColumn.setCellValueFactory(new PropertyValueFactory<Doner, String>("address"));
         
         dataTable.setItems(list);
    }
    
    
    public ObservableList<Doner> getDonerFilterList(){
        ObservableList<Doner> doneList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM record where blood_group='"+fintTxtBlood.getText()+"'";
        
        Statement st;
        ResultSet re;
        
        try{
            st=conn.createStatement();
            re = st.executeQuery(query);
            Doner record;
            while (re.next()) {
                System.out.println(re.getInt(1)+"  "+re.getString(2)+"  "+re.getString(3));  
                record = new Doner(
                        re.getInt("id"),
                        re.getString("name"),
                        re.getString("phone"),
                        re.getString("blood_group"),
                        re.getString("address")
                                );
                doneList.add(record);
                
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }
        return doneList;
        
    }
    
        
    public void loadFilterData(){
         ObservableList<Doner> list = getDonerFilterList();
         System.out.println(list);
         idColumn.setCellValueFactory(new PropertyValueFactory<Doner,Integer>("id"));
         nameColumn.setCellValueFactory(new PropertyValueFactory<Doner, String>("name"));
         phoneColumn.setCellValueFactory(new PropertyValueFactory<Doner, String>("phone"));
         bloodGroupColumn.setCellValueFactory(new PropertyValueFactory<Doner, String>("blood_group"));
         addressColumn.setCellValueFactory(new PropertyValueFactory<Doner, String>("address"));
         
         dataTable.setItems(list);
    }
 
    
}
