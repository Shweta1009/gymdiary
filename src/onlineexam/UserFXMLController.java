/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

import ECUtils.MyUtils;
import exam.bean.ActualUser;
import exam.bean.Question;
import exam.bean.cUser;
import exam.dao.ActualUserDao;
import exam.dao.QuesDAO;
import exam.dao.cUserDao;
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
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import static onlineexam.FXMLConst.ADMIN_FXML;
import static onlineexam.FXMLConst.FXML_FXML;

/**
 * FXML Controller class
 *
 * @author user
 */
public class UserFXMLController implements Initializable {

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
        refreshTbl();
    }    

    @FXML
    private void he(ActionEvent event) {
        if (event.getSource() == btnBack) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(((ADMIN_FXML))));
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
                Parent root = FXMLLoader.load(getClass().getResource("cUserAddFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                        stage.setMaximized(true);
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 

    }
   
    private void refreshTbl() {
        LinkedList<cUser> res = cUserDao.getList();
        MyUtils.populateTable(tblList, res, cUser.class);
    }
}

