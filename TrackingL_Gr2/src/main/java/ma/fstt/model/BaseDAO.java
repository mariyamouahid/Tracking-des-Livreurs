package ma.fstt.model;

import java.sql.*;
import java.util.List;

public abstract  class BaseDAO <T>{

        protected Connection connection ;
        protected Statement statement ;

        protected PreparedStatement preparedStatement ;

        protected ResultSet resultSet ;

        // connexion avec bdd

            private String url = "jdbc:mysql://127.0.0.1:3306/glovo";
            private String login = "root";
            private String password = "";



    BaseDAO() throws SQLException {
        this.connection = DriverManager.getConnection(url , login ,password );
    }


    public abstract void save(Livreur object) throws SQLException;

    public abstract boolean update(Livreur object) throws SQLException;

    public abstract boolean delete(Livreur object) throws SQLException;

    public abstract void save(T object ) throws SQLException;

    public abstract boolean update(T object ) throws SQLException ;

    public abstract boolean delete(T object ) throws SQLException ;


    public abstract void save(Commande object) throws SQLException;

    public abstract boolean update(Commande object) throws SQLException;

    public abstract boolean delete(Commande object) throws SQLException;

    public abstract boolean Validation(Admin objet) throws SQLException;

    public abstract List<Produit> getAall() throws SQLException;

    public abstract List<Commande> getAll(  ) throws SQLException ;

    public abstract List<Livreur> getAlll(  ) throws SQLException ;


    public abstract List<Admin> getAAll(  ) throws SQLException ;


    public abstract Commande getOne(Long id  ) throws SQLException  ;


    public abstract void Validation();
}
