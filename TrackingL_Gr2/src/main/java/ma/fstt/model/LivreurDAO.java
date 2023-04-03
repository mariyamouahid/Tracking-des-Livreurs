package ma.fstt.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivreurDAO extends BaseDAO<Livreur>{
    public LivreurDAO() throws SQLException {
        super();
    }

    @Override
    public void save(Livreur object) throws SQLException {

        String request = "insert into livreur (nom , telephone) values (? , ?)";

        // mapping objet table

        this.preparedStatement = this.connection.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.getNom());

        this.preparedStatement.setString(2 , object.getTelephone());

        this.preparedStatement.execute();
    }

    @Override
    public boolean update(Livreur object) throws SQLException {

        String query = "UPDATE livreur SET nom = ?, telephone = ? WHERE id_livreur = ?";
        //String query="UPDATE livreur SET nom = ' "+object.getNom()+"', Tel = " + object.getTelephone() +"";
        try {
            this.preparedStatement = this.connection.prepareStatement(query);
            //this.preparedStatement.setLong(1,object.getId_livreur());
            this.preparedStatement.setString(1, object.getNom());
            this.preparedStatement.setString(2, object.getTelephone());
            this.preparedStatement.setLong(3,object.getId_livreur());
            this.preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    @Override
    public boolean delete(Livreur object) throws SQLException {
        String query = "DELETE FROM livreur WHERE id_livreur = ?";
        try{
            this.preparedStatement = this.connection.prepareStatement(query);
            this.preparedStatement.setLong(1,object.getId_livreur());
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
        return null;
    }

    @Override
    public List<Commande> getAll()  throws SQLException {
        return null;
    }

    @Override
    public List<Livreur> getAlll() throws SQLException {
        List<Livreur> mylist = new ArrayList<Livreur>();

        String request = "select * from livreur ";

        this.statement = this.connection.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

// parcours de la table
        while ( this.resultSet.next()){

// mapping table objet
            mylist.add(new Livreur(this.resultSet.getLong(1) ,
                    this.resultSet.getString(2) , this.resultSet.getString(3)));

        }

        return mylist;
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
