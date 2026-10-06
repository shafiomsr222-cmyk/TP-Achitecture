package fr.univlille.iut.r304.roulette;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Metéo {
    private List<Action> observer;
    private  Meteo meteo;


    public Metéo(){
        this.observer = new ArrayList<>();

    }

    public void add(Action a){
        this.observer.add(a);
    }

    public void changeMateo(Meteo m) {
        this.meteo = m;
        System.out.println("---Météo : "+m+"---");
        for (Action a : this.observer) {
            a.update(meteo);
        }
    }

    public Meteo getMeteo() {
        return meteo;
    }

}
