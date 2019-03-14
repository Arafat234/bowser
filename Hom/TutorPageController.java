/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qmskills;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author mohammedarafatamin
 */
public class TutorPageController implements Initializable {
   
    /**
     * Initializes the controller class.
     * @throws java.sql.SQLException
     */
    
    LoginQMSkillsController ds;
    
    @FXML
    public void gain() throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SE","root","root");
        System.out.println(ds.userName);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
