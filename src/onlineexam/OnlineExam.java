/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author ajay
 */
public class OnlineExam extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
      
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        Media m= new Media(getClass().getResource("/sound/welcom.mp3").toString());
        MediaPlayer mp= new MediaPlayer(m);
        mp.play();
        mp.setVolume(10);
 
        Image img=null;
        try {
            stage.setTitle("CodeKnack");
            img= new Image("/images/icon.jpg");
            stage.getIcons().add(img);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
         stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
