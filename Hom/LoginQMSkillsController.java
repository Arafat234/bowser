/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qmskills;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author mohammedarafatamin
 */

public class LoginQMSkillsController implements Initializable {
    @FXML public TextField userName;
    @FXML public PasswordField password;
    private String userID;
   
    
    
    
    
    @FXML
    public void switchToHome(ActionEvent event) throws IOException{
        Parent home = FXMLLoader.load(getClass().getResource("homeQMSkills.fxml"));
        Scene homepage = new Scene(home);
        Stage homestage = (Stage)((Node) event.getSource()).getScene().getWindow();
        homestage.setScene(homepage);
        homestage.show();
    }
    
    @FXML
    public void clearFields(){
        userName.clear();
        password.clear();
    }
    
    @FXML
    private void StoreDetails(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        try{
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SE","root","root");
        
        
        Statement st = con.createStatement();
        PreparedStatement sta = con.prepareStatement("insert into LOGIN(USERID) values (?)");
        ResultSet rs = st.executeQuery("select * from REGISTER ");
       
            
            while(rs.next()){
                if ((userName.getText().equals(rs.getString(5)) && password.getText().equals(rs.getString(6))) && rs.getString(10).equals("Student")){
                    sta.setString(1,rs.getString(3));
                    sta.executeUpdate();
                    
                    Parent student = FXMLLoader.load(getClass().getResource("StudentPage.fxml"));
                    Scene studentpage = new Scene(student);
                    Stage studentstage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    studentstage.setScene(studentpage);
                    studentstage.show();
                    con.close();
                }
                
                else if ((userName.getText().equals(rs.getString(5)) && password.getText().equals(rs.getString(6))) && rs.getString(10).equals("Tutor")){
                    sta.setString(1,rs.getString(3));
                    sta.executeUpdate();
                    
                    Parent tutor = FXMLLoader.load(getClass().getResource("TutorPage.fxml"));
                    Scene tutorpage = new Scene(tutor);
                    Stage tutorstage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    tutorstage.setScene(tutorpage);
                    tutorstage.show();
                    con.close();
                }
            }
        }
        catch(Exception e){
            
        } 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}  


