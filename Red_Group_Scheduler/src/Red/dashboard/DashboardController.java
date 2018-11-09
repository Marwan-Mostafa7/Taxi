package Red.dashboard;

import Red.Red_main;
import Red.menu.MenuController;
import static Red.menu.MenuController.mainLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.shape.Rectangle;



public class DashboardController implements Initializable {

    @FXML
    private LineChart<?, ?> Linechart;
    
    @FXML
    private LineChart<?, ?> Linechart2;

    @FXML
    private BarChart<String, Number> Barchart;
    
    @FXML
    private NumberAxis bary;
    
    @FXML
    private CategoryAxis linex;
    
    final double SCALE_DELTA = 1.1;
    
    public static int MAX = 15
            , k = 1;
    
    final static MenuController MENU = new MenuController();
    
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        XYChart.Series seriesL = new XYChart.Series();      // X-axis Only
        
        XYChart.Series seriesL2 = new XYChart.Series();     //X-axis Only
        
        XYChart.Series seriesB = new XYChart.Series();      // Y-axis Only
        
        //seriesL.getData().add(new XYChart.Data("Jan" , Math.random()*100));
        //seriesL2.getData().add(new XYChart.Data("Jan" , Math.random()*100));
        
        // For Line Chart graphs
        for (int i = k; i < MAX; i++) {                 
                                                //    x         y
//                                                 String,   Integer
            seriesL.getData().add(new XYChart.Data(""+i , Math.random()*100));          // Graph1
            seriesL2.getData().add(new XYChart.Data("0"+i , Math.random()*100));        // Graph2
            // Graph2 howa elly zaher ... ya3ny lw 3aiz tekteb
            // Jan 02 03 04 .. 3al X-axis zy el Sora
            // Tedeef fe Graph2 ... seriesL2 ... mesh seriesL ...3asha mesh 7yzHar 7aga
        }
        
        //For barchart
        for (int i = k; i < MAX; i++) {              
                                                //    x       y
//                                                 String, Integer
            seriesB.getData().add(new XYChart.Data(""+i , Math.random()*2000));             // Graph3        
            
            // el X-axis mesh zaher bard... nafs el kalam ... Graph 2 howa el Top ...
            // ana 3amel Hide lel Y-axis bta3etHom ... we Visible lel Y-axis bta3 el dah .. el BarChart
            // Fa 7yzHar el ArQam 3ala el Y-axis .. bta3et dah bas ... mesh  Graph2
            // Zy el Sora ... men 200 -> 650
        }

        
        
        // Lw 3aiz tebda2 el Graph men range Lower Bound mo3ayan
        
// **** Code
        //bary.setAutoRanging(false);
        //bary.setLowerBound(200);
// ******
        // LAzem ne3mel el Auto Ranging -> False 
        // 3'er Kda ... 7ybda2 men 0 kol marra
        
        
        seriesL.setName("latitude/city");
        seriesL2.setName("duration");
        seriesB.setName("distance\ttotal:"+5458+" mi");

       Linechart.getData().addAll(seriesL);
       Linechart2.getData().addAll(seriesL2);
       Barchart.getData().addAll(seriesB);

// Css .. sebak menHom dool
        Linechart.setId("linec");
        Barchart.setId("barc");
        Linechart2.setId("linecc");
    }    
        
    @FXML
    void origin_Size(MouseEvent event) {
         if (event.getClickCount() == 2) {
            Linechart2.setScaleX(1.0);
            Linechart2.setScaleY(1.0);
            Linechart.setScaleX(1.0);
            Linechart.setScaleY(1.0);
            Barchart.setScaleX(1.0);
            Barchart.setScaleY(1.0);
         }

    }
    
    @FXML
    void zoom_in_out(ScrollEvent event) {
        
          event.consume();

        if (event.getDeltaY() == 0) {
            return;
        }

        double scaleFactor = (event.getDeltaY() > 0) ? SCALE_DELTA : 1 / SCALE_DELTA;
        
        
       
        if(scaleFactor>1 )  // Move Forward ... show Nect Data ... next 15 Observation
        {
            k = MAX;
            MAX += 15;
            Linechart.getData().clear();
            Linechart2.getData().clear();
            Barchart.getData().clear();
            initialize(null, null);
            
        }
        
        
        else if(scaleFactor < 1)        // Move Backward ... show previous Data
        {
            
            if(k == 1|| k == 0) return;
            
             k -= 15;
             MAX -= 15;
             
            Linechart.getData().clear();
            Linechart2.getData().clear();
            Barchart.getData().clear();
            initialize(null, null);
            
            
        }
        
            
            
        
        

//        Linechart2.setScaleX(Linechart2.getScaleX() * scaleFactor);
//        Linechart2.setScaleY(Linechart2.getScaleY() * scaleFactor);
//        
//        Linechart.setScaleX(Linechart.getScaleX() * scaleFactor);
//        Linechart.setScaleY(Linechart.getScaleY() * scaleFactor);
//        
//        Barchart.setScaleX(Barchart.getScaleX() * scaleFactor);
//        Barchart.setScaleY(Barchart.getScaleY() * scaleFactor);

    }
    
    @FXML
    void go_to_driver(ActionEvent event) {
        
         MENU.show_driver_mang(event);
         
    }

    @FXML
    void go_to_user(ActionEvent event) {

       MENU.showUserMang(event);
       
    }


}
