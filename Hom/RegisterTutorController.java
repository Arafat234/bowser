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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author mohammedarafatamin
 */
public class RegisterTutorController implements Initializable {

    

    /**
     * Initializes the controller class.
     */
    
    //RegistrationController a = new RegistrationController();
    
    
    @FXML ChoiceBox<String> module;
    ObservableList availableChoices4 = FXCollections.observableArrayList(); 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Dataload();
    }    

    @FXML
    private void addmoduleChoice(ActionEvent event) throws SQLException {
       try{
            Connection conNN = DriverManager.getConnection("jdbc:derby://localhost:1527/SE","root","root");
            PreparedStatement st = conNN.prepareStatement("insert into REGISTER(MODULE)values(?) WHERE (SELECT TOP 1 * FROM Table ORDER BY ID DESC) ");
            st.setString(11,module.getValue());
            st.executeUpdate();
       }
       catch(Exception e){
            
       }
    }
    
    @FXML
     public void Dataload(){
        availableChoices4.removeAll(availableChoices4);
        String g = "Maths for computing";
        String h = "Organic Chemistry";
        availableChoices4.addAll(g,h);
        module.getItems().addAll(availableChoices4);
    }
    
}

