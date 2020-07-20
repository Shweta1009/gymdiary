/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineexam;

import exam.bean.Answer;
import exam.bean.Participant;
import exam.bean.Question;
import exam.dao.AnswerDao;
import exam.dao.QuesDAO;
import exam.dao.participantDao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.time.Clock;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import static onlineexam.TestFXMLController.Correcount;
import static onlineexam.TestFXMLController.curQuesNo;
import static onlineexam.TestFXMLController.numQuesInTest;
import static onlineexam.TestFXMLController.score;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PythonTestFXMLController implements Initializable {

     private LinkedList<Participant> quesList;
 public static int curQuesNo,selectedCount;
   
   
    public static int numQuesInTest;
    public static int score;
    public static int Correcount;
    Answer a1=new Answer();
   // Question q1;
    private boolean isAnswered;
    Random rn;

    ToggleGroup toggleGroup = new ToggleGroup();

    @FXML
    private Label lblQues;
    //private Label lblTimer1;
    //private Label lblTimer2;
    @FXML
    private Button btnNext;
   // private Label lblMsg;
    //private Label lblScore;
    @FXML
    private RadioButton rb3;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb4;
    @FXML
    private RadioButton rb1;
    //private Button btnSubmit;
    @FXML
    private Label lblTimer21;
    @FXML
    private Label lblTimer11;
    @FXML
    private Label lblQuesNo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          quesList = participantDao.getList();
        randomizeQuestion();

        score = 0;
        Correcount=0;
        selectedCount=0;

        // Set No. of Questions to be asked
        numQuesInTest = quesList.size();

        rb1.setToggleGroup(toggleGroup);
        rb2.setToggleGroup(toggleGroup);
        rb3.setToggleGroup(toggleGroup);
        rb4.setToggleGroup(toggleGroup);

        curQuesNo = 0;
       // lblScore.setText("Score: 0");
        stopWatch();
        startTest();

    }    
     private void startTest() {
       // btnNext.setDisable(true);
        isAnswered = false;
        if (curQuesNo < numQuesInTest) {
            populate(curQuesNo);
        } else {
            try {
                System.out.println("\n\n\n\n\n\n"+numQuesInTest+"\n\n\n\n\n\n");
              //  printInvoice();
              
                a1.setQues(CLoginFXMLController.cEmail );
                    a1.setScore(score);
                    a1.setCorretAns(""+Correcount);
                    a1.setSelectAns(""+selectedCount);
                    AnswerDao.insert(a1);
                Stage stage = (Stage) lblQues.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("ResultFXML.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setFullScreen(true);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void he(ActionEvent event) {
        
        if (event.getSource() == btnNext) {
            if (toggleGroup.getSelectedToggle() != null) {
                if (!isAnswered) 
                    btnNext.setDisable(false);
                   // disableRadioButtons(true);
                    isAnswered = true;
                    

                    String userAns = toggleGroup.getSelectedToggle().getUserData().toString();
                    Participant ques = quesList.get(curQuesNo);
                    String correctAns = ques.getAnswer();
                   ++selectedCount;
/*insert value in Answer table*/
                    
                   
                   
                    if (userAns.equals(correctAns)) {
                       ++ Correcount;
                        score += 4;
                       // lblScore.setText("Score: " + score);
                       // lblMsg.setText("Right Answer, +10");
                        System.out.println(score);
                    } else {
                       // lblMsg.setText("Wrong answer. The right answer is " + correctAns);
                        //System.out.println("Wrong answer. The right answer is " + correctAns);
                    }
                    
                  /*  a1.setId(ques.getId());
                    a1.setQues(ques.getQuestion());
                    a1.setScore(score);
                    a1.setCorretAns(correctAns);
                    a1.setSelectAns(userAns);
                    
                    AnswerDao.insert(a1);*/
                    

                } else {

                }
                     
          //  System.out.println("\n\n\n\ncurQuesNo="+curQuesNo);
            ++curQuesNo;
            startTest();
            }
            
     /*    else if (event.getSource() == btnSubmit) {
            //disableRadioButtons(false);
            if(curQuesNo==0){
                
            }
            else{
                 --curQuesNo;
                  score -= 10;
                        lblScore.setText("Score: " + score);
                        lblMsg.setText("Right Answer, -10");
                        System.out.println(score);
            startTest();
            }
          

        }*/
    }
    
     private void disableRadioButtons(boolean bool) {
        rb1.setDisable(bool);
        rb2.setDisable(bool);
        rb3.setDisable(bool);
        rb4.setDisable(bool);
    }

    private void unSelectRadioButtons() {
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        rb4.setSelected(false);
    }

    private void populate(int quesNo) {
        unSelectRadioButtons();
       // lblQues.setText("");
        lblQuesNo.setText("QuesNo: "+(quesNo+1));
       Participant q1 = quesList.get(quesNo);
        lblQues.setText(q1.getQuestion());

        // Original Options
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(0, q1.getAnswer());
        hm.put(1, q1.getOptionOne());
        hm.put(2, q1.getOptionTwo());
        hm.put(3, q1.getOptionThree());

        hm = randomizeOptions(hm);

        populateRadioButton(rb1, hm.get(0));
        populateRadioButton(rb2, hm.get(1));
        populateRadioButton(rb3, hm.get(2));
        populateRadioButton(rb4, hm.get(3));
    }

    private void populateRadioButton(RadioButton rb, String str) {
        rb.setText(str);
        rb.setUserData(str);
    }

    public void randomizeQuestion() {
        LinkedList<Participant> randomList = new LinkedList<Participant>();
        HashSet<Integer> set = new HashSet<>();
        Random rn = new Random();
        int i = 0;
        int numOfQues = quesList.size();
        while (true) {
            i = (i + rn.nextInt(numOfQues)) % numOfQues;
            if (set.contains(i)) {
                continue;
            }
            set.add(i);

            // Add Random Question
            randomList.add(quesList.get(i));
            if (randomList.size() == numOfQues) {
                break;
            }
        }
        quesList = randomList;
    }

    private HashMap<Integer, String> randomizeOptions(HashMap<Integer, String> hm) {
        // Randomizing Options;
        HashMap<Integer, String> randomHm = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        Random rn = new Random();
        int i = 0;
        int numOfOptions = 4;
        int key = 0;
        while (true) {
            i = (i + rn.nextInt(100)) % numOfOptions;
            if (set.contains(i)) {
                continue;
            }
            set.add(i);

            // Add Random Option
            randomHm.put(key++, hm.get(i));
//            System.out.println(key - 1 + " " + i);
            if (numOfOptions == randomHm.size()) {
                break;
            }
        }

        return randomHm;
    }
   //coding for timer
    Timer timer;
    int interval ,count=1;
    public void stopWatch(){
        int delay=1000;
        int period=1000;
        Timer timer=new Timer();
        interval=61;
        timer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
               //lblTimer.setText(""+setInterval());
                Platform.runLater(new Runnable() {
                   @Override
                   public void run() {
                      // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   lblTimer11.setText(":" + setInterval());
                   lblTimer21.setText(""+count);
                   }
               });
            }
            
        },delay,period);
        
    }
    public int setInterval(){
        interval--;
        if(count==0){
            count=0;
            interval=60;
        }
        if(interval== 0){
            count--;
            interval=60;
                        }
        
        if(count==0 && interval==0){
             try {
                 
                  a1.setQues(CLoginFXMLController.cEmail );
                    a1.setScore(score);
                    a1.setCorretAns(""+Correcount);
                    a1.setSelectAns(""+selectedCount);
                    AnswerDao.insert(a1);
                Stage stage = (Stage) lblQues.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("ResultFXML.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setFullScreen(true);
                
                  Media m= new Media(getClass().getResource("/sound/end.mp3").toString());
        MediaPlayer mp= new MediaPlayer(m);
        mp.play();
        mp.setVolume(10);
        
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            timer.cancel();

        }
        return interval;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     private  void printInvoice(){
         try {
            // Product p1= new Product();
            //  p1 = ProductDao.searchById(id);
                
             // Customer c1=new Customer();
             
             //  c1=CustomerDao.searchById(UserFXMLController.custId);
             Date obj=new Date();
             String a=CLoginFXMLController.cEmail;
            File f = new File("c:\\programdata\\"+a+".html");
            FileOutputStream out = new FileOutputStream(f);
            PrintWriter pr = new PrintWriter(out);
            
            pr.write("<html>"
                    + "<head><title>Your Statement</title></head>"
                    + "<body>"
                    + "<table border = '1'>"
                    + "<tr><td colspan = 4 style='font-size:80px;color:#006756'>Account Statement</td></tr>"
                    + "<tr><td colspan = 2>User ID :</td><td colspan = 2>"+CLoginFXMLController.cEmail +"</td></tr>"
                    + "<tr ><td colspan = 2>Total Question :</td><td colspan = 2>"+numQuesInTest+"</td></tr>"
                    + "<tr><td colspan = 2>Attempt Question :</td><td colspan = 2>"+selectedCount+"</td></tr>"                            
                            + "<tr><td colspan = 2>Corrected Question:</td><td colspan = 2>"+Correcount+"</td></tr>"
                                    + "<tr><td colspan = 2>Score :</td><td colspan = 2>"+score+"</td></tr>"
                   
                            + "<tr><td colspan = 2>Date :</td><td colspan = 2>"+obj.toString()+"</td></tr>"+ "<h1>Result</h1>");
            pr.println("</table></body></html>");
            pr.close();
           // Runtime.getRuntime().exec("explorer.exe \"c:\\programdata\\invoice1.html\"");
        } catch (Exception ex) {
            ex.printStackTrace();
        }     
    }  

}


    

