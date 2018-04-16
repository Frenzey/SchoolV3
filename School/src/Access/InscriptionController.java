/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Access;

import JDBC.JDBC;
import classes.Affectation;
import classes.Contrat;
import classes.Etudiant;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author frenzey
 */
public class InscriptionController implements Initializable {
    int idindividu;
    @FXML
    private JFXButton retour;
    @FXML
    private JFXButton retour2;
    @FXML
    private JFXButton Next;
    @FXML
    private AnchorPane page2;
    private AnchorPane page3;
    @FXML
    private AnchorPane page1;
    @FXML
    private JFXButton VersMenu;
    @FXML
    private JFXButton okInscript;
    @FXML
    private JFXButton versListIns;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXRadioButton h;
    @FXML
    private JFXRadioButton f;
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXTextField lnai;
    @FXML
    private JFXTextField add;
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXTextField user;
    @FXML
    private JFXTextField mdp;
    @FXML
    private JFXTextField contrat;

    @FXML
    private ToggleGroup choice;
    /**
     * Initializes the controller class.
     */

    public String c="";
    @FXML
    private JFXTextField fixe;
    @FXML
    private JFXTextField mob;
    @FXML
    private JFXDatePicker dateSdeb;
    @FXML
    private JFXDatePicker dateSfin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        page1.toFront();
        page2.toBack();


        choice.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
         if (choice.getSelectedToggle() != null) {
                   RadioButton button = (RadioButton) choice.getSelectedToggle();
                  c=button.getText();
                  System.out.println(c);
               }
      }
    });


    }


    @FXML
    private void goBackToM(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Menu/MenuAdmin.fxml"));

        Scene insc = new Scene(root);
       //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        inscStage.setScene(insc);
        inscStage.show();
    }


    private void goBackToMen(ActionEvent event) throws IOException {

         Parent root = FXMLLoader.load(getClass().getResource("/Menu/MenuAdmin.fxml"));

        Scene insc = new Scene(root);
       //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        inscStage.setScene(insc);
        inscStage.show();

    }

    @FXML
    private void vers2(ActionEvent event) {

        String d = date.getValue().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        mdp.setText(d);

        if(nom.getText().isEmpty()||prenom.getText().isEmpty()||c.isEmpty()|d.isEmpty()||lnai.getText().isEmpty()||add.getText().isEmpty()||fixe.getText().isEmpty()||mob.getText().isEmpty()||mail.getText().isEmpty()){
        page2.toBack();
        PasBon();
    }


        else{
        page1.toBack();
        page2.toFront();
        user.setText(nom.getText()+"."+prenom.getText());
        }

    }



    @FXML
    private void vers1(ActionEvent event) {
        page2.toBack();
        page1.toFront();
    }


    @FXML
    private void toMenu(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/Menu/MenuAdmin.fxml"));

        Scene insc = new Scene(root);
       //insc.getStylesheets().add(School.class.getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        inscStage.setScene(insc);
        inscStage.show();

    }

    @FXML
    private void goListIns(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/Cequilsvoient/listInscript.fxml"));

        Scene insc = new Scene(root);
       //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        inscStage.setScene(insc);
        inscStage.show();

    }

    private void goListEtud(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/Cequilsvoient/listEtud.fxml"));

        Scene insc = new Scene(root);
       //insc.getStylesheets().add(this.getClass().getResource("../Style/sty.css").toExternalForm());
        Stage inscStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        inscStage.setScene(insc);
        inscStage.show();

    }

    @FXML
    private void valider(ActionEvent event) throws SQLException{

        String d = date.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        mdp.setText(d);
        String a = dateSdeb.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String b = dateSfin.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));


       Etudiant e1 =new Etudiant(nom.getText(), prenom.getText(),c, add.getText(), d, lnai.getText() , fixe.getText(), mob.getText());
       Contrat c1 = new Contrat(contrat.getText(),a, b, 0);
       int idcontrat= attribCont(c1);

       Affectation a1 =new Affectation(idcontrat,user.getText(),mdp.getText(),a,b, 0.0, 0);


       int idetudiant= inscrireEtudiant(e1);
       int idaffectation=attribAffect(a1,idindividu,idcontrat);
       if(idetudiant==1){
           Bon();
       }
       else{
           PasBon();
       }




    }

    public int inscrireEtudiant(Etudiant e1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int id;
		try {
			String sql="INSERT INTO individus(nom,prenom,genre,adresse,datedenaissance,lieudenaissance,telephoneFixe,telephoneMobile) VALUES(?,?,?,?,?,?,?,?);";

			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setString(1,e1.getNom());
			JDBC.ps.setString(2,e1.getPrenom());
			JDBC.ps.setString(3, e1.getGenre());
			JDBC.ps.setString(4, e1.getAdresse());
			JDBC.ps.setString(5, e1.getDatedenaissance());
			JDBC.ps.setString(6, e1.getLieudenaissance());
			JDBC.ps.setString(7, e1.getTelephoneFixe());
			JDBC.ps.setString(8, e1.getTelephoneMobile());
			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				id=JDBC.rs.getInt(1);
				System.out.println(id);
                                idindividu=id;
				sql="INSERT INTO etudiants(individus_idindividus) VALUES(?);";
				JDBC.ps =JDBC.connexion.prepareStatement(sql);
				JDBC.ps.setInt(1,id);
				JDBC.ps.executeUpdate();
			}
			return 1;
		} catch (SQLException e) {
			int errCode = e.getErrorCode();
			if(errCode == 1062) {
				System.out.println("user deja existant");
				//inserer code alerte
			}
			else {
				System.out.println("erreur");
			}
			return 0;
		}
	}


    private void Bon() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succes");

        alert.setHeaderText(null);
        alert.setContentText("Etudiant ajouté!");

        alert.showAndWait();
    }

    private void PasBon() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");

        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les chants!");

        alert.showAndWait();
    }


    public int attribCont(Contrat c1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int id=0;
		try {
			String sql="INSERT INTO contrats(libelContrat,dateEntrContrat,datesortContrat,salaireContrat) VALUES(?,?,?,?);";

			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setString(1,"Etudiant");
			JDBC.ps.setString(2,c1.getDateEntrContrat());
			JDBC.ps.setString(3,c1.getDateSortContrat());
                        JDBC.ps.setString(4, "0");
			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				id=JDBC.rs.getInt(1);
				System.out.println(id);
                          return id;
			}

                }
                        catch(SQLException e) {
                            e.printStackTrace();
                             return 0;
                        }
        return 0;
}


    public int attribAffect(Affectation a1,int idindi,int idcontrat) throws SQLException {
		JDBC.getInstance();
		JDBC.getConnexion();
		int id = 0;
		try {
			String sql="INSERT INTO affectations(loginAffectation,motPasseAffectation,dateEntrAffectation,datesortAffectation,referentAffectation, validAffectation,contrats_idContrat,individus_idindividus) VALUES(?,?,?,?,?,?,?,?);";

			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setString(1,a1.getLogin());
			JDBC.ps.setString(2,a1.getPass());
			JDBC.ps.setString(3,a1.getDateEntrContrat());
			JDBC.ps.setString(4,a1.getDateSortContrat());
			JDBC.ps.setString(5, "ADMIN");
                        JDBC.ps.setString(6, "0");
                        JDBC.ps.setInt(7, idcontrat);
                        JDBC.ps.setInt(8, idindi);
			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				sql="INSERT INTO auth(user,pass,level) VALUES(?,?,?);";
                                JDBC.ps =JDBC.connexion.prepareStatement(sql);
                                JDBC.ps.setString(1,a1.getLogin());
                                JDBC.ps.setString(2,a1.getPass());
                                JDBC.ps.setInt(3, 5);
                                JDBC.ps.executeUpdate();

                          return id;
			}

                }
                        catch(SQLException e) {
                            e.printStackTrace();

                        }
        return 0;
}


    }
