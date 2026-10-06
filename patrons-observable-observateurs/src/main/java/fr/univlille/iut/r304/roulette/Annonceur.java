package fr.univlille.iut.r304.roulette;

public class Annonceur implements ObservateurDeRoulette {
    private String nom ;
    public Annonceur(){
        this.nom = "Annonceur";
    }



    public void update(Roulette r){
        System.out.println(this.nom+" : "+r.getNumero());
    }

}
