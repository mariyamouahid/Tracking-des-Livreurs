package ma.fstt.trackingl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ma.fstt.model.Commande;
import ma.fstt.model.CommandeDAO;
import ma.fstt.model.Livreur;
import ma.fstt.model.LivreurDAO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CommandeController implements Initializable {
    @FXML
    private Button okk;

    @FXML
    private Button supp;

    @FXML
    private TextField nomm;


    @FXML
    private TextField Date ;


    @FXML
    private TableView<Commande> mytable ;


    

    @FXML
    private TableColumn<Commande, String> col_nomLvr ;

    @FXML
    private TableColumn<Commande, String> col_date ;
    private int id = 0;
    @FXML
    private TableColumn<Commande ,Long> col_idd ;


    @FXML
    protected void onSaveButtonClick() {

        // accees a la bdd

        try {
            CommandeDAO commandeDAO = new CommandeDAO();

            Commande cmd = new Commande(0l , nomm.getText() , Date.getText() );

            commandeDAO.save(cmd);

            UpdateTable();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void UpdateTable(){
        if (col_idd != null) {
            col_idd.setCellValueFactory(new PropertyValueFactory<Commande, Long>("id_Commande"));
        }
        if (col_nomLvr != null){
            col_nomLvr.setCellValueFactory(new PropertyValueFactory<Commande,String>("Livreur_Cmd"));
        }
        if (col_date != null){
            col_date.setCellValueFactory(new PropertyValueFactory<Commande,String>("Date"));
        }


        mytable.setItems(this.getDataCommandes());
    }

    public static ObservableList<Commande> getDataCommandes(){

        CommandeDAO commandeDAO = null;

        ObservableList<Commande> listfx = FXCollections.observableArrayList();

        try {
            commandeDAO = new CommandeDAO();
            for (Commande ettemp : commandeDAO.getAll())
                listfx.add(ettemp);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();

    }

    public void DeleteTable(ActionEvent actionEvent) {
        try {
            CommandeDAO commandeDAO = new CommandeDAO();
            Commande commande = mytable.getSelectionModel().getSelectedItem();
            id = Math.toIntExact(commande.getId_Commande());
            Commande cmd1 = new Commande((long) id, nomm.getText() , Date.getText());

            commandeDAO.delete(cmd1);

            UpdateTable();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ModifierTable(ActionEvent actionEvent) {
        try {
            CommandeDAO commandeDAO = new CommandeDAO();
            Commande commande = mytable.getSelectionModel().getSelectedItem();
            id = Math.toIntExact(commande.getId_Commande());
            Commande cmd1 = new Commande((long) id, nomm.getText() , Date.getText());
            commandeDAO.update(cmd1);

            UpdateTable();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void tblDataMouseClicked(MouseEvent mouseEvent) {
        Commande commande = mytable.getSelectionModel().getSelectedItem();
        id = Math.toIntExact(commande.getId_Commande());
        nomm.setText(commande.getLivreur_Cmd());
        Date.setText(commande.getDate());
        okk.setDisable(true);
    }
}