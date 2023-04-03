package ma.fstt.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO extends BaseDAO<Livreur>{
    public CommandeDAO() throws SQLException {
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
    public void save(Commande object) throws SQLException {
        String request = "insert into Commande (Livreur_Cmd , Date) values (? , ?)";

        // mapping objet table

        this.preparedStatement = this.connection.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.getLivreur_Cmd());

        this.preparedStatement.setString(2 , object.getDate());

        this.preparedStatement.execute();
    }

    @Override
    public boolean update(Commande object) throws SQLException {

        String query = "UPDATE Commande SET Livreur_Cmd = ?, Date = ? WHERE id_Commande = ?";
        //String query="UPDATE livreur SET nom = ' "+object.getNom()+"', Tel = " + object.getTelephone() +"";
        try {
            this.preparedStatement = this.connection.prepareStatement(query);
            //this.preparedStatement.setLong(1,object.getId_livreur());
            this.preparedStatement.setString(1, object.getLivreur_Cmd());
            this.preparedStatement.setString(2, object.getDate());
            this.preparedStatement.setLong(3,object.getId_Commande());
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
    public boolean delete(Commande object) throws SQLException {
        String query = "DELETE FROM Commande WHERE id_Commande = ?";
        try{
            this.preparedStatement = this.connection.prepareStatement(query);
            this.preparedStatement.setLong(1,object.getId_Commande());
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
    public boolean Validation(Admin objet) throws SQLException {

        return false;
    }

    @Override
    public List<Produit> getAall() throws SQLException {
        return null;
    }

    @Override
    public List<Commande> getAll()  throws SQLException {

        List<Commande> mylist = new ArrayList<Commande>();

        String request = "select * from commande ";

        this.statement = this.connection.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

// parcours de la table
        while ( this.resultSet.next()){

// mapping table objet
            mylist.add(new Commande(this.resultSet.getLong(1) ,
                    this.resultSet.getString(2) , this.resultSet.getString(3)));

        }

        return mylist;
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
