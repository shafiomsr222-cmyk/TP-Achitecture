package patisserie.garniture;

import patisserie.Dessert;

public abstract class Garniture extends Dessert {
    private Dessert dessert;

    public Garniture(String nom, double prix , Dessert dessert){
        super(nom,prix);
        this.dessert = dessert;
    }

    @Override
    public double getPrix() {
        return super.getPrix()+ this.dessert.getPrix();
    }

    @Override
    public String getNom() {
        return dessert.getNom()+" "+super.getNom()  ;
    }




}
