/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

import ECUtils.GUIValidator;
import exam.bean.ActualUser;
import exam.bean.MyUser;
import exam.bean.cUser;
import exam.bean.pythonUser;
import exam.dao.ActualUserDao;
import exam.dao.UserDAO;
import exam.dao.cUserDao;
import exam.dao.pythonUserDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static onlineexam.FXMLConst.ADMIN_FXML;
import static onlineexam.FXMLConst.FXML_FXML;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CLoginFXMLController implements Initializable {
GUIValidator v1 = new GUIValidator();
public static  String cEmail,pEmail;
    @FXML
    private Label lblOut;
    @FXML
    private Button btnBack;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Button btnLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          v1.addRequiredValidator(txtEmail);
        v1.addRequiredValidator(txtPass);
    }    

    @FXML
    private void he(ActionEvent event) {
        
          if (event.getSource() == btnBack) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(FXML_FXML));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
stage.setFullScreen(true);
stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (event.getSource() == btnLogin) {
            try {
                if (v1.validateAll()) {
                   
                      
                                                  
                      cUser u2 = cUserDao.validate(txtEmail.getText(), txtPass.getText());
                      pythonUser u1 = pythonUserDao.validate(txtEmail.getText(), txtPass.getText());
                       cEmail=txtEmail.getText();
                      if (u2 != null) {
                         
                        try {
                            Parent root = FXMLLoader.load(getClass().getResource("TestFXML.fxml"));
                            Scene scene = new Scene(root);
                            Stage stage = (Stage) btnBack.getScene().getWindow();
stage.setFullScreen(true);
stage.setScene(scene);

              Media m= new Media(getClass().getResource("/sound/start.mp3").toString());
        MediaPlayer mp= new MediaPlayer(m);
        mp.play();
        mp.setVolume(10);
                        } 
                            
                        
                        catch (Exception e) {
                            e.printStackTrace();
                        }}
                      
                      
                       
                   else if (u1 != null) {
                     
                        try {
                            Parent root = FXMLLoader.load(getClass().getResource("PythonTestFXML.fxml"));
                            Scene scene = new Scene(root);
                            Stage stage = (Stage) btnBack.getScene().getWindow();
                                    stage.setFullScreen(true);
                                    stage.setScene(scene);
                                    
                                      Media m= new Media(getClass().getResource("/sound/start.mp3").toString());
        MediaPlayer mp= new MediaPlayer(m);
        mp.play();
        mp.setVolume(10);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    
                    }
                        else  {
                        JOptionPane.showMessageDialog(null, "Invalid user name or password!");
                    }
                }
            } 
            catch (Exception e) {
            }
        }
    }

    }
    

