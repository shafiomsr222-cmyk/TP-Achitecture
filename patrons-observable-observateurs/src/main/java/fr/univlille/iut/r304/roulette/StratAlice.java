package fr.univlille.iut.r304.roulette;

public class StratAlice implements Strategie{

    private static int numAlice = 0;
    public int choix(){
        StratAlice.numAlice++;
        return  StratAlice.numAlice;
    }
}
