/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

import ECUtils.GUIValidator;
import exam.bean.ActualUser;
import exam.bean.MyUser;
import exam.dao.ActualUserDao;
import exam.dao.UserDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static onlineexam.FXMLConst.*;

/**
 * FXML Controller class
 *
 * @author 
 */
public class LoginFXMLController implements Initializable {

    GUIValidator v1 = new GUIValidator();

    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
                        stage.setMaximized(true);
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (event.getSource() == btnLogin) {
            try {
                if (v1.validateAll()) {
                   
                      
                                                  
                      ActualUser u2 = ActualUserDao.validate(txtEmail.getText(), txtPass.getText());
                      MyUser u1 = UserDAO.validate(txtEmail.getText(), txtPass.getText());
                      if (u2 != null) {
                        try {
                            Parent root = FXMLLoader.load(getClass().getResource("PythonAdminFXML.fxml"));
                            Scene scene = new Scene(root);
                            Stage stage = (Stage) btnBack.getScene().getWindow();
                                   stage.setMaximized(true);
                                   stage.setScene(scene);
                        } 
                            
                        
                        catch (Exception e) {
                            e.printStackTrace();
                        }}
                      
                      
                       
                   else if (u1 != null) {
                        try {
                            Parent root = FXMLLoader.load(getClass().getResource(ADMIN_FXML));
                            Scene scene = new Scene(root);
                            Stage stage = (Stage) btnBack.getScene().getWindow();
                                   stage.setMaximized(true);
                                   stage.setScene(scene);
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
