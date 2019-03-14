/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qmskills;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

/**
 * FXML Controller class
 *
 * @author mohammedarafatamin
 */
public class CreateSessionController implements Initializable {

    /**
     * Initializes the controller class.
     * @throws java.sql.SQLException
     */
    @FXML ChoiceBox<String> tutor;
    ObservableList list = FXCollections.observableArrayList();
    
    
    @FXML
    public void Loaddata() throws SQLException{
    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SE","root","root");
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("select * from REGISTER");
    list.removeAll(list);
    while(rs.next()){
     list.add(rs.getString(2));
    }
    tutor.getItems().addAll(list);
    }
    
    @FXML
    public void submit() throws SQLException{
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SE","root","root");
                PreparedStatement st = conn.prepareStatement("insert into TEST(MO)values(?)");
                st.setString(1,tutor.getValue());
                st.executeUpdate();
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Loaddata();
        } catch (SQLException ex) {
            Logger.getLogger(CreateSessionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
