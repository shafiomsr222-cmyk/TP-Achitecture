package fr.univlille.iut.r304.roulette;

public class Martingale implements Strategie{

    private static int numero = 0; ;



    public int choix(){
        return Martingale.numero;
    }

    public static void setNumero(int i){
        Martingale.numero = i;
    }
}
