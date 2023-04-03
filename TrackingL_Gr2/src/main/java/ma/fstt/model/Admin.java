package ma.fstt.model;

public class Admin {
    private Long id_Admin ;

    private String Nom ;

    private String MotPasse ;

    public Admin() {
    }

    public Admin(Long id_Admin, String Nom, String MotPasse) {
        this.id_Admin = id_Admin;
        this.Nom = Nom;
        this.MotPasse = MotPasse;
    }

    public Long getId_Admin() {
        return id_Admin;
    }

    public void setId_Admin(Long id_Admin) {
        this.id_Admin = id_Admin;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        this.Nom = nom;
    }

    public String getMotPass() {
        return MotPasse;
    }

    public void setTelephone(String MotPasse) {
        this.MotPasse = MotPasse;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id_Admin=" + id_Admin +
                ", Nom='" + Nom + '\'' +
                ", MotPasse='" + MotPasse + '\'' +
                '}';
    }
}

