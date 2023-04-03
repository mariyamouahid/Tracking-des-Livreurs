package ma.fstt.model;


// java bean
public class Commande {
    private Long id_Commande ;

    private String Livreur_Cmd ;

    private String Date ;

    public Commande() {
    }

    public Commande(Long id_Commande, String Livreur_Cmd, String Date) {
        this.id_Commande = id_Commande;
        this.Livreur_Cmd = Livreur_Cmd;
        this.Date = Date;
    }

    public long getId_Commande() {
        return id_Commande;
    }

    public void setId_Commande(Long id_Commande) {
        this.id_Commande = id_Commande;
    }

    public String getLivreur_Cmd() {
        return Livreur_Cmd;
    }

    public void setLivreur_Cmd(String Livreur_Cmd) {
        this.Livreur_Cmd = Livreur_Cmd;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id_Commande=" + id_Commande +
                ", Livreur='" + Livreur_Cmd + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }
}
