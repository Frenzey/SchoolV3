/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import JDBC.JDBC;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Frenzey
 */
public class LoginController implements Initializable {

    @FXML
    private JFXButton seCon;
    @FXML
    private JFXButton sinsCr;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXSpinner logProg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        logProg.setVisible(false);
    }    


    @FXML
    private void goToSin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Inscript/Inscript.fxml"));
       
        Scene insc = new Scene(root);
        //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
                
        inscStage.setScene(insc);
        inscStage.show(); 
        
    }

    @FXML
    private void goMenu(ActionEvent event) throws IOException {
        int n = Authentification(username.getText(),password.getText());
        
        if(n==1){
            logProg.setVisible(true);
        alertConnectTrue();
        Parent root = FXMLLoader.load(getClass().getResource("/Menu/MenuAdmin.fxml"));
        Scene insc = new Scene(root);
        //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        inscStage.setScene(insc);
        inscStage.show(); 
    }
        
        else if(n==2){
            Parent root = FXMLLoader.load(getClass().getResource("/Menu/MenuSecretaire.fxml"));
        Scene insc = new Scene(root);
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        inscStage.setScene(insc);
        inscStage.show(); 
            
        }
        
        else if(n==3){
            Parent root = FXMLLoader.load(getClass().getResource("/Menu/MenuCompta.fxml"));
        Scene insc = new Scene(root);
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        inscStage.setScene(insc);
        inscStage.show(); 
            
        }
        
        else if(n==4){
            
            Parent root = FXMLLoader.load(getClass().getResource("/Menu/MenuEnseignant.fxml"));
        Scene insc = new Scene(root);
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        inscStage.setScene(insc);
        inscStage.show(); 
            
        }
        
        else if(n==5){
            
            Parent root = FXMLLoader.load(getClass().getResource("/Menu/MenuEtu.fxml"));
        Scene insc = new Scene(root);
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        inscStage.setScene(insc);
        inscStage.show(); 
        }
        
        else {
            alertConnectFalse();
        }
    }
    
    
    public static int Authentification(String user,String pass){
                JDBC.getInstance();
		JDBC.getConnexion();
		int level = 0;
		try{
			String sql = "SELECT * FROM auth WHERE user ='"+user+"' and pass='"+pass+"'";
			JDBC.st = JDBC.connexion.createStatement();
			JDBC.rs = JDBC.st.executeQuery(sql);
			if(JDBC.rs.next()){
				level=JDBC.rs.getInt("level");
			}
			else{
				level=0;
			}
		}
		catch(SQLException e){
			//mettre une alerte !!!
			System.out.println("Erreur");
			e.printStackTrace();
		}
		return level;
	    
	}
    
    
     private void alertConnectTrue() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Connection");

        alert.setHeaderText(null);
        alert.setContentText("Connection réussi!");
 
        alert.showAndWait();
    }

    private void alertConnectFalse() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");

        alert.setHeaderText(null);
        alert.setContentText("NOM D'UTILISATEUR OU MOT DE PASSE INCORRECT");
 
        alert.showAndWait();
    }
}
