package ma.fstt.model;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO extends BaseDAO<Admin> {
    public AdminDAO() throws SQLException {
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
    public void save(Admin object) throws SQLException {
        String request = "insert into admin (Nom , MotPasse) values (? , ?)";

        // mapping objet table

        this.preparedStatement = this.connection.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.getNom());

        this.preparedStatement.setString(2 , object.getMotPass());

        this.preparedStatement.execute();
    }

    @Override
    public boolean update(Admin object) throws SQLException {

        return false;
    }

    @Override
    public boolean delete(Admin object) throws SQLException {

        return false;
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
    public boolean Validation(Admin objet) throws SQLException{
        try {
            String verifyLogin = "select * from admin  where Nom=? AND MotPasse=?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(verifyLogin);


            preparedStatement1.setString(1,objet.getNom());
            preparedStatement1.setString(2, objet.getMotPass());
            ResultSet queryResult = preparedStatement1.executeQuery();
            //ResultSet queryResult = statement1.executeQuery(verifyLogin);

            if(queryResult.next()){

                return  true;
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
        return null;
    }

    @Override
    public List<Admin> getAAll() throws SQLException {
        List<Admin> mylist = new ArrayList<>();

        String request = "select * from admin ";

        this.statement = this.connection.createStatement();

        this.resultSet =   this.statement.executeQuery(request);

// parcours de la table
        while ( this.resultSet.next()){

// mapping table objet
            mylist.add(new Admin(this.resultSet.getLong(1) ,
                    this.resultSet.getString(2) , this.resultSet.getString(3)));

        }

        return mylist;

    }

    @Override
    public Commande getOne(Long id) throws SQLException {
        return null;
    }

    @Override
    public void Validation() {

    }
}
