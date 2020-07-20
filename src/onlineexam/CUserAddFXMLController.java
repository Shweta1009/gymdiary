/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

import ECUtils.GUIValidator;
import exam.bean.Question;
import exam.bean.cUser;
import exam.dao.QuesDAO;
import exam.dao.cUserDao;
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
import static onlineexam.FXMLConst.ADMIN_FXML;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CUserAddFXMLController implements Initializable {
 GUIValidator v1 = new GUIValidator();

    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnAdd;
    @FXML
    private PasswordField txtpass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         v1.addRequiredValidator(txtpass);
        v1.addRequiredValidator(txtEmail);
    }    

    @FXML
    private void he(ActionEvent event) {
         if (event.getSource() == btnBack) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("UserFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                if (v1.validateAll()) {
                    cUser q1 = new cUser();
                    q1.setEmail(txtEmail.getText());
                    q1.setPass(txtpass.getText());
                    /*q1.setQuestion(txtQues.getText());
                    q1.setAnswer(txtAns.getText());
                    q1.setOptionOne(txtOpt1.getText());
                    q1.setOptionTwo(txtOpt2.getText());
                    q1.setOptionThree(txtOpt3.getText());*/
                    cUserDao.insert(q1);

                    Parent root = FXMLLoader.load(getClass().getResource("UserFXML.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) btnBack.getScene().getWindow();
                    stage.setScene(scene);
                }
            } catch (Exception e) {
            }
        }
    }
    
}
