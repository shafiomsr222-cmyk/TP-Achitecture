package patisserie;

import patisserie.garniture.Chantilly;
import patisserie.garniture.Chocolat;

public class Fabrique {
    private String nom ;

    public Fabrique(String nom ){
        this.nom = nom ;
    }

    public static Dessert dessertFabrique(String nom){
        String[] s = nom.split(" ");
        Dessert dessert = null;
        for(String e : s){

            switch (e){

                case ("Crepe"):
                    if(dessert != null){
                        return new DessertNull();
                    }
                    dessert = new Crepe();
                    break;

                case  ("Gaufre"):
                    if(dessert != null){
                        return new DessertNull();
                    }
                        dessert = new Gaufre();
                    break;
                case ("chocolat"):
                    if(dessert == null){
                        return new DessertNull();
                    }
                    dessert = new Chocolat(dessert);
                    break;
                case ("chantilly"):
                    if(dessert == null){
                        return new DessertNull();
                    }
                    dessert = new Chantilly(dessert);
                    break;

                default:
                    return  new DessertNull();
            }

        }
        return dessert;
    }


}