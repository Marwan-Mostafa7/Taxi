
package Red.driverMang;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class DriverController implements Initializable {

    
    @FXML
    private BorderPane border_All;

    @FXML
    private VBox left_vbox;
    
    @FXML
    private JFXTextField start_Add;

    @FXML
    private JFXTextField end_Add;

    @FXML
    private JFXTextField d_no_Add;

    @FXML
    private JFXTextField f_name_Add;

    @FXML
    private JFXTextField l_name_Add;

    @FXML
    private JFXTextField p_no_Add;

    @FXML
    private ColorPicker color_Add;

    @FXML
    private JFXTextArea comment_Add;

    @FXML
    private JFXCheckBox BH_Add;


// Arrows   
    
    @FXML
    private JFXButton forward_Add;

    @FXML
    private JFXButton backward_Add;
 //---------------------------------------
    
    // Lists
    
    @FXML
    private ListView<?> list_1_Add;

    @FXML
    private ListView<?> list_2_Add;

//---------------------------------------
    
// Tabs 
      @FXML
    private Label add_tab;

    @FXML
    private Label edit_tab;
//---------------------------------------
    
     @FXML
    private ImageView img_driver;
     
     @FXML
    private HBox hbox_of_img;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
        border_All.setLeft(null);
    }
    
    @FXML
    void edit_clicked(ActionEvent event) {
        
//        hbox_of_img.getChildren().remove(img_driver);
        
        hbox_of_img.setSpacing(0);
        add_tab.setStyle("-fx-border-width: 0;");
        edit_tab.setStyle("-fx-border-width: 0 0 3 0; -fx-border-color: transparent transparent #e00f0f transparent;");     
        border_All.setLeft(left_vbox);
    }
    
    @FXML
    void add_clicked(ActionEvent event) {

  //      hbox_of_img.getChildren().add(img_driver);
  
        hbox_of_img.setSpacing(80);
        edit_tab.setStyle("-fx-border-width: 0;");
        add_tab.setStyle("-fx-border-width: 0 0 3 0; -fx-border-color: transparent transparent #e00f0f transparent;");
        border_All.setLeft(null);

    }
}
