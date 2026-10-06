package patisserie.Assortiment;

import patisserie.Dessert;

import java.util.ArrayList;
import java.util.List;

public class Assortiment extends Dessert {
    private List<Dessert> desserts;

    public Assortiment(String nomA ){
        super(nomA, 0.0);
        this.desserts = new ArrayList<Dessert>();
    }

    public void add(Dessert dessert){
        this.desserts.add(dessert);
    }

    public void remove(Dessert dessert){
        this.desserts.remove(dessert);
    }

    public List<Dessert> getchild(){
        return this.desserts;
    }

    public String getNom(){
        String mot="( ";
        for(Dessert d : this.desserts){
            mot += d.getNom() + " ";
        }
        return  super.getNom()+" " + mot +" )";
    }

    public double getPrix(){
        double de = 0.0;
        for(Dessert d : this.desserts){
            de += d.getPrix() ;
        }
        return  de = de*0.90;
    }

}
