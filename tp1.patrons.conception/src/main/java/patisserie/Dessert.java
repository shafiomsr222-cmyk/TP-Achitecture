package patisserie;

public abstract class Dessert {
    private String nom;
    private double prix;

    public Dessert(String nom, double prix){
        this.nom = nom ;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public String toString(){
        return this.getNom() +" – "+this.getPrix()+"€";
    }

}
