package fr.univlille.iut.r304.roulette;

public class Joueur implements ObservateurDeRoulette{
    private String nom;

    private int fitech;
    private Strategie strat;

    public Joueur(String nom , int i){
        this.nom = nom ;
        this.fitech = i;
    }
    public Joueur(String nom ,Strategie strat){
        this.nom = nom ;
        this.strat = strat;
    }

    public void update(Roulette roulette){
        if(this.strat != null) this.fitech = strat.choix();
       if(roulette.getNumero() == this.fitech){
           System.out.println(this.nom + " : gagné! " +this.fitech);
       }else {
           System.out.println(this.nom + " : Zut, perdu "+this.fitech);
       }

    }
}
