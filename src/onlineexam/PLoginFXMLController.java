/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

import ECUtils.GUIValidator;
import ECUtils.MyUtils;
import exam.bean.ActualUser;
import exam.bean.MyUser;
import exam.bean.pythonUser;
import exam.dao.ActualUserDao;
import exam.dao.UserDAO;
import exam.dao.pythonUserDao;
import java.net.URL;
import java.util.LinkedList;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static onlineexam.FXMLConst.ADMIN_FXML;
import static onlineexam.FXMLConst.FXML_FXML;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PLoginFXMLController implements Initializable {
GUIValidator v1 = new GUIValidator();
   // private Button btnLogin;
   // private PasswordField txtPass;
   // private TextField txtEmail;
    @FXML
    private Button btnBack;
    @FXML
    private TableView<?> tblList;
    @FXML
    private Button btnAdd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //   v1.addRequiredValidator(txtEmail);
       // v1.addRequiredValidator(txtPass);
       refreshTbl();

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
          
          
          
           if (event.getSource() == btnAdd) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("pUserAddFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                        stage.setMaximized(true);
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
     /*   else if (event.getSource() == btnLogin) {
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
        }*/}
      private void refreshTbl() {
          LinkedList<pythonUser> res = pythonUserDao.getList();
          MyUtils.populateTable(tblList, res, pythonUser.class);
    }
    }

    
    

