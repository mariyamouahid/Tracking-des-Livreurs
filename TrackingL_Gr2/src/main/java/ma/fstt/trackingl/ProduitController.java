package ma.fstt.trackingl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ma.fstt.model.Produit;
import ma.fstt.model.ProduitDAO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static java.lang.Double.parseDouble;

public class ProduitController implements Initializable {

    @FXML
    private TableColumn<Produit, String> col_dsc;

    @FXML
    private TableColumn<Produit, Long> col_idP;

    @FXML
    private TableColumn<Produit, String> col_nomCmd;

    @FXML
    private TableColumn<Produit, Double> col_prx;

    @FXML
    private TextField desc;

    @FXML
    private Button moddd;

    @FXML
    private TableView<Produit> mytable;

    int id = 0;

    @FXML
    private TextField nomC;

    @FXML
    private Button okkk;

    @FXML
    private TextField prx;

    @FXML
    private Button suppp;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UpdateTable();
    }

    public void onSaveButtonClick(ActionEvent event) {

        try {
            ProduitDAO produitDAO = new ProduitDAO();

            Double prix = Double.parseDouble(prx.getText());

            Produit prd = new Produit(0l , nomC.getText() , desc.getText() , prix);

            produitDAO.save(prd);

            UpdateTable();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void UpdateTable(){
        col_idP.setCellValueFactory(new PropertyValueFactory<Produit ,Long>("id_produit"));
        col_nomCmd.setCellValueFactory(new  PropertyValueFactory<Produit ,String>("commande"));
        col_dsc.setCellValueFactory(new PropertyValueFactory<Produit ,String>("description"));
        col_prx.setCellValueFactory(new PropertyValueFactory<Produit ,Double>("Prix"));

        mytable.setItems(this.getDataProduits());
    }

    public static ObservableList<Produit> getDataProduits(){

        ProduitDAO produitDAO = null;

        ObservableList<Produit> listfx = FXCollections.observableArrayList();

        try {
            produitDAO = new ProduitDAO();
            for (Produit ettemp : produitDAO.getAall())
                listfx.add(ettemp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx;
    }

    public void ModifierTable(ActionEvent event) {
        try {
            ProduitDAO produitDAO = new ProduitDAO();
            Produit produit = mytable.getSelectionModel().getSelectedItem();
            if (produit != null) { // check for null before accessing selected item
                id = Math.toIntExact(produit.getId_produit());
                Double prix = parseDouble(prx.getText());
                Produit prd1 = new Produit((long) id, nomC.getText(), desc.getText(), prix);
                produitDAO.update(prd1);
                UpdateTable();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void DeleteTable(ActionEvent event) {
        try {
            ProduitDAO produitDAO = new ProduitDAO();
            Produit produit = mytable.getSelectionModel().getSelectedItem();
            id = Math.toIntExact(produit.getId_produit());
            Double prix = parseDouble(prx.getText());
            Produit prd1 = new Produit((long) id, nomC.getText() , desc.getText() , prix);

            produitDAO.delete(prd1);

            UpdateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void tblDataMouseClicked(MouseEvent mouseEvent) {
        Produit produit = mytable.getSelectionModel().getSelectedItem();
        id = Math.toIntExact(produit.getId_produit());
        nomC.setText(produit.getCommande());
        desc.setText(produit.getDescription());
        Double prix = produit.getPrix();
        prx.setText(Double.toString(prix));
        okkk.setDisable(true);

    }
}
