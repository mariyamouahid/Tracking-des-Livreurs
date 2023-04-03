package ma.fstt.trackingl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ma.fstt.model.Livreur;
import ma.fstt.model.LivreurDAO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button ok;

    @FXML
    private Button sup;

    @FXML
    private TextField nom ;


    @FXML
    private TextField tele ;


    @FXML
    private TableView<Livreur> mytable ;
    int id = 0;

    @FXML
    private TableColumn<Livreur ,Long> col_id ;

    @FXML
    private TableColumn <Livreur ,String> col_nom ;

    @FXML
    private TableColumn <Livreur ,String> col_tele ;


    @FXML
    protected void onSaveButtonClick() {

        // accees a la bdd

        try {
            LivreurDAO livreurDAO = new LivreurDAO();

            Livreur liv = new Livreur(0l , nom.getText() , tele.getText());

            livreurDAO.save(liv);


            UpdateTable();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<Livreur,Long>("id_livreur"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Livreur,String>("nom"));
        col_tele.setCellValueFactory(new PropertyValueFactory<Livreur,String>("telephone"));

        mytable.setItems(this.getDataLivreurs());
    }

    public static ObservableList<Livreur> getDataLivreurs(){

        LivreurDAO livreurDAO = null;

        ObservableList<Livreur> listfx = FXCollections.observableArrayList();

        try {
            livreurDAO = new LivreurDAO();
            for (Livreur ettemp : livreurDAO.getAlll())
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
            LivreurDAO livreurDAO = new LivreurDAO();
            Livreur livreur = mytable.getSelectionModel().getSelectedItem();
            id = Math.toIntExact(livreur.getId_livreur());
            Livreur liv1 = new Livreur((long) id, nom.getText() , tele.getText());

            livreurDAO.delete(liv1);

            UpdateTable();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ModifierTable(ActionEvent actionEvent) {
        try {
            LivreurDAO livreurDAO = new LivreurDAO();
            Livreur livreur = mytable.getSelectionModel().getSelectedItem();
            id = Math.toIntExact(livreur.getId_livreur());
            Livreur liv1 = new Livreur((long) id, nom.getText() , tele.getText());
            livreurDAO.update(liv1);

            UpdateTable();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void tblDataMouseClicked(MouseEvent mouseEvent) {
        Livreur livreur = mytable.getSelectionModel().getSelectedItem();
        id = Math.toIntExact(livreur.getId_livreur());
        nom.setText(livreur.getNom());
        tele.setText(livreur.getTelephone());
        ok.setDisable(true);
    }
}