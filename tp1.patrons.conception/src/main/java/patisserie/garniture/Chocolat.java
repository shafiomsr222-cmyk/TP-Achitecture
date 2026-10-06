package patisserie.garniture;

import patisserie.Dessert;

public class Chocolat extends Garniture{
    public Chocolat(Dessert dessert){
        super("chocolat", 1.50, dessert);
    }
}
