package Red.menu;

import Red.Login.LoginViewController;
import static Red.Login.LoginViewController.MainStage;
import Red.Red_main;
import Red.dashboard.DashboardController;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController implements Initializable {

    
    
    
 //----------------------------
     @FXML
    private JFXButton dash;

    @FXML
    private FontAwesomeIconView house;

    @FXML
    private JFXButton userM;

    @FXML
    private FontAwesomeIconView human;

    @FXML
    private JFXButton driverM;

    @FXML
    private FontAwesomeIconView car;

    @FXML
    private JFXButton schedM;

    @FXML
    private FontAwesomeIconView sched;

    @FXML
    private JFXButton roro;

    @FXML
    private FontAwesomeIconView location;

    @FXML
    private JFXButton payH;

    @FXML
    private FontAwesomeIconView clock;

    @FXML
    private JFXButton sett;

    @FXML
    private FontAwesomeIconView setti;

    
//----------------------------
   
    public static Stage LStage;
    public static BorderPane mainLayout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
   
    }
    
    public static void showMenu(){
        
         
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Red_main.class.getResource("menu/menu.fxml"));
            mainLayout = loader.load();

            FXMLLoader loader2 = new FXMLLoader();
           loader2.setLocation(Red_main.class.getResource("dashboard/dashboard.fxml"));
            mainLayout.setCenter(loader2.load());
            
            Scene scene = new Scene(mainLayout);

            LStage = new Stage();
            LStage.setTitle("");
            LStage.setScene(scene);
            LStage.setMaximized(true);   // to be full screen
            LStage.initStyle(StageStyle.UNDECORATED);
            LStage.show();

            // Close the login stage
            LoginViewController.MainStage.close();
            
            
             
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
          //  activeBtn(dash  , house);
        
    }
    
    
    
    @FXML
    void show_dashboard(ActionEvent event) {

         try {
            
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(Red_main.class.getResource("dashboard/dashboard.fxml"));
           mainLayout.setCenter(loader.load());
            
         }catch(IOException ex){
              Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
     activeBtn(dash  , house);
    }
    
    @FXML
   public void showUserMang(ActionEvent event) {
    
         try {
            
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(Red_main.class.getResource("userMang/userManagement.fxml"));
           mainLayout.setCenter(loader.load());
            
         }catch(IOException ex){
              Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         
         activeBtn(userM , human );
    }

    @FXML
    void show_Rota(ActionEvent event) {
  
        activeBtn(roro , location );
    }

    
    @FXML
   public void show_driver_mang(ActionEvent event) {
        
         try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Red_main.class.getResource("driverMang/driver.fxml"));
            mainLayout.setCenter(loader.load());
            
         }catch(IOException ex){
              Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       activeBtn(driverM , car );
    }

    @FXML
    void show_pay_hours(ActionEvent event) {

        activeBtn(payH  , clock);
    }

    @FXML
    void show_settings(ActionEvent event) {

        activeBtn(sett  , setti);
    }

    @FXML
    void show_shedule_mang(ActionEvent event) {

        activeBtn(schedM  , sched);
    }
    
    @FXML
    void mimize_stage(MouseEvent event) {
            LStage.setIconified(true);
    }

    
    // close window 
    @FXML
    void  close_window(MouseEvent event) {
        LStage.close();
    }
    
    @FXML
    void log_Out(MouseEvent event) {
        
        DashboardController.k = 0;
        DashboardController.MAX = 15;
        LStage.close();
        MainStage.show();
    }
    
  
     private void activeBtn(JFXButton btn , FontAwesomeIconView img) {
         
         System.out.println("Called !! ");
         
        JFXButton[] btns = {dash, userM, driverM, schedM, roro, payH , sett};
        FontAwesomeIconView[] imgs = {house , human , car, sched, location, clock, setti};

        for (JFXButton b : btns)
            b.setStyle("-fx-border-width: 0;"
                    + "-fx-background-color: transparent;"
                    + "-fx-text-fill : #797676;");
         for(FontAwesomeIconView i : imgs)
             i.setStyle("-fx-fill : #969494");
        

        btn.setStyle(
                 "-fx-background-color: #599bd6;"
                +"-fx-border-width: 0 4 0 0;"
                + "-fx-border-color: transparent #e00f0f transparent transparent;"
                + "-fx-text-fill :#FFFFFF;"
                + "-fx-background-insets:4;");
        
        img.setStyle("-fx-fill : #FFFFFF");
        
         
         
    }
//setImage(new Image("/imgs/icons8-home-50 (1).png"));
     
     // #055a8e  blue color
     // #e00f0f  red  color
     // #797676  gray color
     // #969494  dark grey
     
}// end of class