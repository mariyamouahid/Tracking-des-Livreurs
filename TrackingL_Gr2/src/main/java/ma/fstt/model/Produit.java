package ma.fstt.model;

public class Produit {
    private Long id_produit;
    private String commande;
    private String description;
    private Double prix;
    public Produit(){

    }
    public Produit(Long id_produit, String commande, String description, Double prix){
        this.id_produit = id_produit;
        this.commande = commande;
        this.description = description;
        this.prix = prix;
    }
    public Long getId_produit(){return id_produit;}
    public void setId_produit(Long id_produit){ this.id_produit = id_produit;}

    public String getCommande(){return commande;}

    public void setCommande(String commande){ this.commande = commande;}
    public String getDescription(){return description;}
    public void setDescription(String description){ this.description = description;}
    public Double getPrix(){return prix;}
    public void setPrix(Double prix){ this.prix = prix;}

    @Override
    public String toString(){
        return "Produit{" +
                "id_produit=" + id_produit +
                ", Commande= '" + commande + '\'' +
                ", Description= '" + description + '\'' +
                ", Prix= '" + prix + '\'' +
                '}';
    }
}
