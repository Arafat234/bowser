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
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sun.security.util.Password;

/**
 * FXML Controller class
 *
 * @author mohammedarafatamin
 */
    

public class RegistrationController implements Initializable {
    
    @FXML ChoiceBox<String> degreechoice;
    ObservableList availableChoices = FXCollections.observableArrayList(); 
    

    @FXML private TextField studentid;
    
    @FXML private TextField userid;
    
    @FXML private TextField fullname;
    
    @FXML private TextField username;
   
    @FXML private TextField password1;
    
    @FXML private TextField password2;
    
    @FXML private TextField yearofstudy;
    
    @FXML private TextField email;
    
    @FXML private TextField phonenumber;
    
    @FXML ChoiceBox<String> userrolechoice;
    ObservableList availableChoices2 = FXCollections.observableArrayList();
    
    @FXML
    public void switchToTutorRegister(ActionEvent event) throws IOException{
        Parent tutorRegister = FXMLLoader.load(getClass().getResource("RegisterTutor.fxml"));
        Scene tutorRegisterpage = new Scene(tutorRegister);
        Stage tutorRegisterstage = (Stage)((Node) event.getSource()).getScene().getWindow();
        tutorRegisterstage.setScene(tutorRegisterpage);
        tutorRegisterstage.show();

    }
    
    
    @FXML
    public void switchToHome(ActionEvent event) throws IOException{
        Parent home = FXMLLoader.load(getClass().getResource("homeQMSkills.fxml"));
        Scene homepage = new Scene(home);
        Stage homestage = (Stage)((Node) event.getSource()).getScene().getWindow();
        homestage.setScene(homepage);
        homestage.show();
    }
    
    
    
    @FXML
    private void loadData(){
    availableChoices.removeAll(availableChoices);
    String a = "Computer Science BSC with Honours";
    String b = "Maths BSC with Honours";
    String c = "Chemistry BSC with Honours";
    String d = "English BA with Honours";
    availableChoices.addAll(a,b,c,d);
    degreechoice.getItems().addAll(availableChoices);
    
    availableChoices2.removeAll(availableChoices2);
    String e = "Tutor";
    String f = "Student";
    availableChoices2.addAll(e,f);
    userrolechoice.getItems().addAll(availableChoices2);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }    

    
    @FXML
    private void StoreDetails(ActionEvent event) throws ClassNotFoundException, SQLException {
        try{
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SE","root","root");
        PreparedStatement st = con.prepareStatement("insert into REGISTER(DEGREECHOICE,STUDENTID,USERID,FULLNAME,USERNAME,PASSWORD,YEAROFSTUDY,EMAIL,PHONENUMBER,USERROLECHOICE)values(?,?,?,?,?,?,?,?,?,?)");
        st.setString(1,degreechoice.getValue());
        st.setString(2,studentid.getText());
        st.setString(3,userid.getText());
        st.setString(4,fullname.getText());
        st.setString(5,username.getText());
        st.setString(6,password1.getText());
        st.setString(7,yearofstudy.getText());
        st.setString(8,email.getText());
        st.setString(9,phonenumber.getText());
        st.setString(10,userrolechoice.getValue());
        st.executeUpdate();
        System.out.println("Connection Established!");
        
        Parent home = FXMLLoader.load(getClass().getResource("homeQMSkills.fxml"));
        Scene homepage = new Scene(home);
        Stage homestage = (Stage)((Node) event.getSource()).getScene().getWindow();
        homestage.setScene(homepage);
        homestage.show();    
        }
        catch(Exception e){
            System.out.println("Could not get connection");
        } 
    }
    
}
   /* @FXML 
    private void registrationValidation() throws SQLException{
    
    
    } */
 
    


    
   
