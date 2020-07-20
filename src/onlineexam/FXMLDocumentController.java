/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import static onlineexam.FXMLConst.*;

/**
 *
 * @author 
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnStart;
    @FXML
    private Hyperlink btnAdmin;
    @FXML
    private Button btnUser;
    @FXML
    private Label lblStart;
    @FXML
    private Label lblRules;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblStart.setText("Start Test");
        lblRules.setText("Time : 30 minutes\nTatal number of questions: 25\nTotal marks: 100 (4 marks per question)\nNo rewind or back option\nDo not close or minimise the exam window");
    }

    @FXML
    private void he(ActionEvent event) {
        if (event.getSource() == btnStart) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("cLoginFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnStart.getScene().getWindow();
                        
                        stage.setScene(scene);stage.setMaximized(true);
                        stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == btnAdmin) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(LOGIN_FXML));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnAdmin.getScene().getWindow();
                        stage.setMaximized(true);
                        stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
        else if (event.getSource() == btnUser) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("cLoginFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnStart.getScene().getWindow();
                        stage.setFullScreen(true);
                        stage.setMaximized(true);
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
       

    }

}
