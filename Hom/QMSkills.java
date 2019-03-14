/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qmskills;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import java.sql.SQLException;
/**
 *
 * @author mohammedarafatamin
 */
public class QMSkills extends Application {
    
    //Replaces the start method which is found within the javaFX Application package when java fx is started
    @Override
    public void start(Stage stage) throws Exception {
       
        Parent root = FXMLLoader.load(getClass().getResource("homeQMSkills.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    
    // Launches The Java FX Application 
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        launch(args);
    }
    
   
    
}
    
    
   
    
   