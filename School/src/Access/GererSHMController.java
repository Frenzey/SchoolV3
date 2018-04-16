/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author frenzey
 */
public class GererSHMController implements Initializable {

    @FXML
    private JFXButton toSalles;
    @FXML
    private JFXButton toHor;
    @FXML
    private JFXButton toMat;
    @FXML
    private AnchorPane salle;
    @FXML
    private AnchorPane mat;
    @FXML
    private AnchorPane hor;
    @FXML
    private JFXButton versMenu;
    @FXML
    private JFXButton toSal;
    @FXML
    private JFXButton v2Menu;
    @FXML
    private JFXButton vMen;
    @FXML
    private AnchorPane Contain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        hor.toBack();
        mat.toBack();
        salle.toFront();

    }

    
    @FXML
    private void gSalle(ActionEvent event) {
        salle.toFront();
    }

    @FXML
    private void gHor(ActionEvent event) {
        hor.toFront();
    }

    @FXML
    private void gMenu(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/Menu/MenuAdmin.fxml"));

        Scene insc = new Scene(root);
        //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        inscStage.setScene(insc);
        inscStage.show();
    }

    @FXML
    private void gMat(ActionEvent event) {
        mat.toFront();
    }

    /*
    private void gMenu(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Menu/MenuAdmin.fxml"));

        Scene insc = new Scene(root);
        insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        inscStage.setScene(insc);
        inscStage.show();
    }
    */

}
