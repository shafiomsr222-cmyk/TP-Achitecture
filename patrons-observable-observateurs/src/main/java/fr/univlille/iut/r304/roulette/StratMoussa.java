package fr.univlille.iut.r304.roulette;

import java.util.Random;

public class StratMoussa implements Strategie{
    private static int r = 0 ;

    public int choix(){
        r++;
        if(r%2 == 0) {
            return  10;
        }
        return  20;
    }
}
