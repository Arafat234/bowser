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
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    
    
    public String constant;
    
    @FXML private TextField studentid;
    
    @FXML private TextField userid;
    
    @FXML private TextField fullname;
    
    @FXML private TextField username;
   
    @FXML private TextField password1;
    
    @FXML private TextField password2;
    
    @FXML private TextField yearofstudy;
    
    @FXML private TextField email;
    
    @FXML private TextField phonenumber;
    
    @FXML private CheckBox ATCcheckbox;
    
    @FXML ChoiceBox<String> degreechoice;
    ObservableList availableChoices = FXCollections.observableArrayList(); 
    
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
    
   
    
    /* @FXML ChoiceBox<String> userrolechoice;
    ObservableList availableChoices2 = FXCollections.observableArrayList();
    
    @FXML
    public void Loaddata() throws SQLException{
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SE","root","root")) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from REGISTER");
            availableChoices2.removeAll(availableChoices2);
            while(rs.next()){
                availableChoices2.add(rs.getString(2));
            }
            userrolechoice.getItems().addAll(availableChoices2);
        }
    } */
    
    
    
    
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
        /*try {
            // loadData();
            Loaddata();
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        } */
    }    
    
    @FXML
    private void clearAllFields(ActionEvent event){
    studentid.clear();
    userid.clear();
    fullname.clear();
    username.clear();
    password1.clear();
    password2.clear();
    yearofstudy.clear();
    email.clear();
    phonenumber.clear();
    userrolechoice.setValue(null);
    degreechoice.setValue(null);
    
    }
    
    @FXML
    private void StoreDetails(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        try{
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SE","root","root");
        boolean isSelected = ATCcheckbox.isSelected();
            // Condition not satisfied if none are empty
            if (degreechoice.getValue() == null || studentid.getText() == null || userid.getText() == null || fullname.getText() == null || username.getText() == null || password1.getText()== null ||password2.getText() == null || yearofstudy.getText() == null || email.getText() == null || phonenumber.getText() == null || userrolechoice.getValue() == null){
                   Alert a = new Alert(AlertType.NONE); 
                   a.setAlertType(AlertType.ERROR);
                   a.setContentText("Please make sure all fields have been filled and numeric input has been placed appropriately in the releveant fields."); 
                   a.show();
                }
            else if (!password1.getText().equals(password2.getText())){
                   Alert c = new Alert(AlertType.NONE); 
                   c.setAlertType(AlertType.ERROR);
                   c.setContentText("Make sure passwords are the same."); 
                   c.show();
            
                }
            else if (isSelected == false){
                    Alert b = new Alert(AlertType.NONE); 
                    b.setAlertType(AlertType.ERROR);
                    b.setContentText("Please make sure you have agreed to the terms and conditions as well as making sure all fields have been filled."); 
                    b.show();
                }
            else{
                if (!phonenumber.getText().matches(".*[0-9].*")){
                    Alert b = new Alert(AlertType.NONE); 
                    b.setAlertType(AlertType.ERROR);
                    b.setContentText("Please make sure you have used numeric input for phone number."); 
                    b.show();
                }
                else{    
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

                Parent home = FXMLLoader.load(getClass().getResource("homeQMSkills.fxml"));
                Scene homepage = new Scene(home);
                Stage homestage = (Stage)((Node) event.getSource()).getScene().getWindow();
                homestage.setScene(homepage);
                homestage.show(); 
                
                con.close();
                }  
            }
        }
        catch(SQLException | IOException e){
            
        } 
    }

    
}
   /* @FXML 
    private void registrationValidation() throws SQLException{
    
    
    } */
 
    


    
   
