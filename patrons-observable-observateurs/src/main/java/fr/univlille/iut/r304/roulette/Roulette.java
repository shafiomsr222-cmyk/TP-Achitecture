package fr.univlille.iut.r304.roulette;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;


public class Roulette {

    private List<ObservateurDeRoulette> observer;



    private static final Random GEN_ALEA = new Random();
    private int numero = 0;

    public Roulette(){
        this.observer = new ArrayList<>();
    }

    public void lancer(){
        this.numero = GEN_ALEA.nextInt(50);
        System.out.println("---La roulette s'arrête---");

        notifyObservers();
        Martingale.setNumero(this.numero);
    }

    public int getNumero(){
        return this.numero;
    }

    public void add(ObservateurDeRoulette r){
        this.observer.add(r);
    }

    public void remove(ObservateurDeRoulette r){
        this.observer.remove(r);
    }
    protected void notifyObservers(){
        for(ObservateurDeRoulette e: this.observer){
            e.update(this);
        }
    }


}
