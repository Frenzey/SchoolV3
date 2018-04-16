/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Frenzey
 */
public class MenuEtuController implements Initializable {

    @FXML
    private JFXButton seDeco;
    @FXML
    private AnchorPane main;
    @FXML
    private AnchorPane menu;
    @FXML
    private AnchorPane etatInsc;
    @FXML
    private JFXButton versEtat;
    @FXML
    private JFXButton versF;
    @FXML
    private JFXButton versInfofact;
    @FXML
    private JFXButton gMenu;
    @FXML
    private AnchorPane infoFact;
    @FXML
    private JFXButton gMenu1;
    @FXML
    private AnchorPane mesInf;
    @FXML
    private JFXButton gMenu2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        etatInsc.toBack();
        infoFact.toBack();
        mesInf.toBack();
        
        
        // TODO
    }    

    @FXML
    private void goBackToLog(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Login/Login.fxml"));
       
        Scene insc = new Scene(root);
       
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                
        inscStage.setScene(insc);
        inscStage.show(); 
    }

    @FXML
    private void gEtat(ActionEvent event) {
        
        menu.toBack();
        etatInsc.toFront();
    }

    @FXML
    private void gF(ActionEvent event) {
        menu.toBack();
        infoFact.toFront();
    }

    @FXML
    private void gInfofact(ActionEvent event) {
        menu.toBack();
        mesInf.toFront();
    }

    @FXML
    private void versM(ActionEvent event) {
        menu.toFront();
    }
    
}
