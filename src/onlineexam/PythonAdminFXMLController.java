/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

import ECUtils.MyUtils;
import exam.bean.Participant;
import exam.bean.Question;
import exam.dao.QuesDAO;
import exam.dao.participantDao;
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
import javax.swing.JOptionPane;
import static onlineexam.FXMLConst.ADD_FXML;
import static onlineexam.FXMLConst.FXML_FXML;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PythonAdminFXMLController implements Initializable {

    @FXML
    private Button btnResult;
    @FXML
    private Button btnAdd;
    @FXML
    private TableView<?> tblList;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnUser;

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
                Parent root = FXMLLoader.load(getClass().getResource(FXML_FXML));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == btnAdd) {
            try {
                        
                Parent root = FXMLLoader.load(getClass().getResource("PythonAddFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                        stage.setMaximized(true);
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } 
        
        else if (event.getSource() == btnAdd) {
            try {
                        
                Parent root = FXMLLoader.load(getClass().getResource("PythonAddFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                        stage.setMaximized(true);
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } 
        
        
        
        else if (event.getSource() == btnUser) {
            try {
                               
                Parent root = FXMLLoader.load(getClass().getResource("pLoginFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                        stage.setMaximized(true);
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } 
        
        
        
        
        else if (event.getSource() == btnDelete) {
            try {
                String id = MyUtils.getSelColValue("id", tblList);
                if (id == null || "".equals(id)) {
                    JOptionPane.showMessageDialog(null, "Please select a value!!");
                } else {
                    int ch = JOptionPane.showConfirmDialog(null, "R u sure!");
                    if (ch == 0) {
                        QuesDAO.delete(id);
                        refreshTbl();
                        JOptionPane.showMessageDialog(null, "Deleted!!");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void refreshTbl() {
        LinkedList<Participant> res = participantDao.getList();
        MyUtils.populateTable(tblList, res, Participant.class);
    }

    }
    

