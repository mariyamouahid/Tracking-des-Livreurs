package ma.fstt.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProduitDAO extends BaseDAO<Produit>{

    public ProduitDAO() throws SQLException{
        super();
    }

    @Override
    public void save(Livreur object) throws SQLException {

    }

    @Override
    public boolean update(Livreur object) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Livreur object) throws SQLException {
        return false;
    }

    @Override
    public void save(Produit object) throws SQLException {
        String request = "insert into produit (Cmd, description , Prix) values (? , ? , ? )";

        this.preparedStatement = this.connection.prepareStatement(request);

        this.preparedStatement.setString(1 , object.getCommande());
        this.preparedStatement.setString(2, object.getDescription());
        this.preparedStatement.setDouble(3, object.getPrix());

        this.preparedStatement.execute();

    }

    @Override
    public boolean update(Produit object) throws SQLException {
        String query="UPDATE produit SET Cmd = ?, description = ?, Prix = ? WHERE id_Produit = ?";

        try {
            this.preparedStatement = this.connection.prepareStatement(query);

            this.preparedStatement.setString(1, object.getCommande());
            this.preparedStatement.setString(2, object.getDescription());
            this.preparedStatement.setDouble(3, object.getPrix());
            this.preparedStatement.setLong(4, object.getId_produit());
            this.preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public boolean delete(Produit object) throws SQLException {
        String query = "DELETE FROM produit WHERE id_Produit = ?";
        try {
            this.preparedStatement = this.connection.prepareStatement(query);
            this.preparedStatement.setLong(1, object.getId_produit());
            this.preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public void save(Commande object) throws SQLException {

    }

    @Override
    public boolean update(Commande object) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Commande object) throws SQLException {
        return false;
    }

    @Override
    public boolean Validation(Admin objet) throws SQLException {

        return false;
    }

    @Override
    public List<Produit> getAall() throws SQLException {
        List<Produit> mylist = new ArrayList<>();

        String request = "select * from produit";

        this.statement = this.connection.createStatement();

        this.resultSet = this.statement.executeQuery(request);

        while ( this.resultSet.next() ){

            mylist.add(new Produit(this.resultSet.getLong(1),
                    this.resultSet.getString(2) , this.resultSet.getString(3) , this.resultSet.getDouble(4)));
        }

        return mylist;

    }

    @Override
    public List<Commande> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<Livreur> getAlll() throws SQLException {
        return null;
    }

    @Override
    public List<Admin> getAAll() throws SQLException {
        return null;
    }

    @Override
    public Commande getOne(Long id) throws SQLException {
        return null;
    }

    @Override
    public void Validation() {

    }
}
