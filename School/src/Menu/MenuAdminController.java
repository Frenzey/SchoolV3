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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Frenzey
 */
public class MenuAdminController implements Initializable {

    @FXML
    private JFXButton seDecAd;
    @FXML
    private JFXButton versInscript;
    @FXML
    private JFXButton versPaie;
    @FXML
    private JFXButton versEns;
    @FXML
    private JFXButton versAg;
    @FXML
    private JFXButton versHSM;
    @FXML
    private JFXButton versEtud;
    @FXML
    private JFXButton versGroup;
    @FXML
    private JFXButton versSuivi;
    @FXML
    private JFXButton versSess;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goBackToLog(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Login/Login.fxml"));
       
        Scene insc = new Scene(root);
       //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                
        inscStage.setScene(insc);
        inscStage.show(); 
    }

    @FXML
    private void goInscrip(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/Access/Inscription.fxml"));
       
        Scene insc = new Scene(root);
        //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        
        inscStage.setScene(insc);
        inscStage.show(); 
        
    }

    @FXML
    private void goPaie(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Access/GererPaie.fxml"));
       
        Scene insc = new Scene(root);
       //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                
        inscStage.setScene(insc);
        inscStage.show(); 
    }

    @FXML
    private void goEns(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/Access/GererEns.fxml"));
       
        Scene insc = new Scene(root);
       //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                
        inscStage.setScene(insc);
        inscStage.show(); 
    }

    @FXML
    private void goAgent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Access/GererAg.fxml"));
       
        Scene insc = new Scene(root);
       //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                
        inscStage.setScene(insc);
        inscStage.show(); 
    }

    @FXML
    private void goHSM(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/Access/GererSHM.fxml"));
       
        Scene insc = new Scene(root);
       //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                
        inscStage.setScene(insc);
        inscStage.show(); 
    }

    @FXML
    private void goEtud(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/Access/GererEtud.fxml"));
       
        Scene insc = new Scene(root);
       //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                
        inscStage.setScene(insc);
        inscStage.show(); 
        
    }

    @FXML
    private void goGroup(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/Access/GererGroup.fxml"));
       
        Scene insc = new Scene(root);
       //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                
        inscStage.setScene(insc);
        inscStage.show(); 
        
    }

    @FXML
    private void goSuivi(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/Access/GererSuivi.fxml"));
       
        Scene insc = new Scene(root);
       //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                
        inscStage.setScene(insc);
        inscStage.show(); 
        
    }

    @FXML
    private void goSess(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/Access/GererSession.fxml"));
       
        Scene insc = new Scene(root);
       //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                
        inscStage.setScene(insc);
        inscStage.show(); 
        
    }
    
}
