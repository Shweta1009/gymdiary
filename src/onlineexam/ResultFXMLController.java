/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

import exam.bean.Participant;
import exam.bean.Question;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static onlineexam.FXMLConst.*;
import static onlineexam.TestFXMLController.numQuesInTest;

/**
 * FXML Controller class
 *
 * @author 
 */
public class ResultFXMLController implements Initializable {

    @FXML
    private Button btnHome;
    @FXML
    private Label lblResult;
    @FXML
    private Label lblScore;
    Participant p1=new Participant();
    Question q1;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      /*  p1.setNo_ques(numQuesInTest); 
                    p1.getNo_correctAns()*/
       //printInvoice();
        lblScore.setText("answer are being evaulating\n");
       
    }

    @FXML
    private void he(ActionEvent event) {
        if (event.getSource() == btnHome) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(FXML_FXML));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnHome.getScene().getWindow();
                        stage.setMaximized(true);
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        /*else {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(TEST_FXML));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnHome.getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }
    
    
    /* private  void printInvoice(){
         try {
            // Product p1= new Product();
            //  p1 = ProductDao.searchById(id);
                
             // Customer c1=new Customer();
             
             //  c1=CustomerDao.searchById(UserFXMLController.custId);
             Date obj=new Date();
            File f = new File("c:\\programdata\\invoice1.html");
            FileOutputStream out = new FileOutputStream(f);
            PrintWriter pr = new PrintWriter(out);
            pr.write("<html>"
                    + "<head><title>Your Statement</title></head>"
                    + "<body>"
                    + "<table border = '1'>"
                    + "<tr><td colspan = 4 style='font-size:80px;color:#006756'>Account Statement</td></tr>"
                    + "<tr><td colspan = 2>User ID :</td><td colspan = 2>"+CLoginFXMLController.cEmail +"</td></tr>"
                    + "<tr ><td colspan = 2>Total Question :</td><td colspan = 2>"+TestFXMLController.numQuesInTest+"</td></tr>"
                    + "<tr><td colspan = 2>Attempt Question :</td><td colspan = 2>"+TestFXMLController.selectedCount+"</td></tr>"                            
                            + "<tr><td colspan = 2>Corrected Question:</td><td colspan = 2>"+TestFXMLController.Correcount+"</td></tr>"
                                    + "<tr><td colspan = 2>Score :</td><td colspan = 2>"+TestFXMLController.score+"</td></tr>"
                   
                            + "<tr><td colspan = 2>Date :</td><td colspan = 2>"+obj.toString()+"</td></tr>"+ "<h1>Result</h1>");
            pr.println("</table></body></html>");
            pr.close();
          //  Runtime.getRuntime().exec("explorer.exe \"c:\\programdata\\invoice1.html\"");
        } catch (Exception ex) {
            ex.printStackTrace();
        }     
    }  */
    
                

}
