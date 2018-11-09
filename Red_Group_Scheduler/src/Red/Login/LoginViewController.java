
package Red.Login;

import Red.Red_main;
import Red.menu.MenuController;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class LoginViewController implements Initializable {
  
    
    public static Stage MainStage;
    private static BorderPane MainLayout;
    
     @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField password;

    
    @Override
    public  void  initialize(URL url, ResourceBundle rb) {}
    
    public static void showLogin() {
         
        LoginViewController.MainStage = Red_main.MainStage;
        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Red_main.class.getResource("Login/loginView.fxml"));
            MainLayout = loader.load();
            Scene scene = new Scene(MainLayout);
            MainStage.setResizable(false);
            MainStage.initStyle(StageStyle.UNDECORATED);
            MainStage.setScene(scene);
            MainStage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    
    // Login Button
     
    // move to Dashboard
     
    @FXML
    void Logged_in(ActionEvent event) {
        
        
        // Data Base Section
        // **********************
        
        
        
        //  **********************
        // if true then go to Dashboard
        MenuController.showMenu();
        
    }
    
    
    @FXML
    void mimize_stage(MouseEvent event) {
            MainStage.setIconified(true);
    }

    
     // close window 
       @FXML
    void close_window(MouseEvent event) {

        MainStage.close();
    }
    
    
    
}
