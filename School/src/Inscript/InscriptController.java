/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inscript;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Frenzey
 */
public class InscriptController implements Initializable {

    @FXML
    private JFXButton valid;
    @FXML
    private JFXButton prec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToEt(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/Menu/MenuEtu.fxml"));
       
        Scene insc = new Scene(root);
        //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                
        inscStage.setScene(insc);
        inscStage.show(); 
        
    }

    @FXML
    private void goToLog(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Login/Login.fxml"));
       
        Scene insc = new Scene(root);
       //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                
        inscStage.setScene(insc);
        inscStage.show(); 
    }
    
}