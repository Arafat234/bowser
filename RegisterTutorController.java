/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qmskills;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mohammedarafatamin
 */
public class RegisterTutorController implements Initializable {

    /**
     * Initializes the controller class.
     * @param event
     * @throws java.io.IOException
     */
    
    @FXML
    AnchorPane hello;
    
    @FXML
    public void switchToHome(ActionEvent event) throws IOException{
        Parent home = FXMLLoader.load(getClass().getResource("homeQMSkills.fxml"));
        Scene homepage = new Scene(home);
        Stage homestage = (Stage)((Node) event.getSource()).getScene().getWindow();
        homestage.setScene(homepage);
        homestage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
