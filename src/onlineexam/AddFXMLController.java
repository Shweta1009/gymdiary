/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

import ECUtils.GUIValidator;
import exam.bean.Question;
import exam.dao.QuesDAO;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import static onlineexam.FXMLConst.*;

/**
 * FXML Controller class
 *
 * @author ajay
 */
public class AddFXMLController implements Initializable {

    GUIValidator v1 = new GUIValidator();

    @FXML
    private TextArea txtQues;
    @FXML
    private TextField txtAns;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnBack;
    @FXML
    private TextField txtOpt1;
    @FXML
    private TextField txtOpt3;
    @FXML
    private TextField txtOpt2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // v1.addRequiredValidator(txtQues);
        v1.addRequiredValidator(txtAns);
        v1.addRequiredValidator(txtOpt1);
        v1.addRequiredValidator(txtOpt2);
        v1.addRequiredValidator(txtOpt3);
    }


    @FXML
    private void he(ActionEvent event) {
        if (event.getSource() == btnBack) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(ADMIN_FXML));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                if (v1.validateAll()) {
                    Question q1 = new Question();
                    q1.setQuestion(txtQues.getText());
                    q1.setAnswer(txtAns.getText());
                    q1.setOptionOne(txtOpt1.getText());
                    q1.setOptionTwo(txtOpt2.getText());
                    q1.setOptionThree(txtOpt3.getText());
                    QuesDAO.insert(q1);

                    Parent root = FXMLLoader.load(getClass().getResource(ADMIN_FXML));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) btnBack.getScene().getWindow();
                    stage.setScene(scene);
                }
            } catch (Exception e) {
            }
        }
    }

}
