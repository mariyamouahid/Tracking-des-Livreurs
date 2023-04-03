package ma.fstt.trackingl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ma.fstt.model.Admin;
import ma.fstt.model.AdminDAO;
import ma.fstt.model.Livreur;
import ma.fstt.model.LivreurDAO;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private Button btnAnn;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private Button btnCon;

    @FXML
    private TextField tname;

    @FXML
    private PasswordField tpass;

    @FXML
    void AnnulerButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) btnAnn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void LoginButtonOnAction(ActionEvent event) throws SQLException, IOException {
        AdminDAO adminDAO = new AdminDAO();
        Admin adm = new Admin(0l, tname.getText(), tpass.getText());
        boolean test = adminDAO.Validation(adm);

        if(test){
            Parent trackingParent = FXMLLoader.load(getClass().getResource("gerer.fxml"));
            Scene trackingScene = new Scene(trackingParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(trackingScene);
            window.show();}
        else{
            loginMessageLabel.setText("Erreur de connexion !!");
        }}
/*
        if (tname.getText().isBlank() == false && tpass.getText().isBlank() == false && b == true) {

            Parent newSceneParent = FXMLLoader.load(getClass().getResource("gerer.fxml"));
            Scene newScene = new Scene(newSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            window.show();
        } else {
            loginMessageLabel.setText("Erreur de connexion !!");
        }

    }*/
}
