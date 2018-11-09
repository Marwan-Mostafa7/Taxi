package Red;

import Red.Login.LoginViewController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Red_main extends Application {

    
    public static Stage MainStage;

    
     @Override
    public void start(Stage primaryStage) throws Exception {

        MainStage = primaryStage;
        MainStage.setTitle("");

        LoginViewController.showLogin();
    }
    
    public static void main(String[] args){
        launch(args);
    }

   
}
