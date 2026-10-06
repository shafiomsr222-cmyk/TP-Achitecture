package fr.univlille.iut.r304.des.model;


import fr.univlille.iut.r304.des.view.ObservateurLancersDes;

import java.util.*;

public class LancersDes {
    private List<ObservateurLancersDes> observable ;
    private Map<Integer,Integer> valeur;
    private int val ;
    private Random r = new Random();
    public LancersDes(){
        this.valeur = new HashMap<>();
        for(int i = 1; i<11; i++) {
            valeur.put(i, 0);
        }
        this.observable = new ArrayList<>();
        this.val = 0;
    }

    public void lancerDe(){
        this.val = r.nextInt(10)+1;
        this.valeur.put(this.val, this.valeur.get(val)+1);
        notifyUpdate();
    }



    public List<ObservateurLancersDes> getObservable() {
        return observable;
    }

    public Map<Integer, Integer> getValeur() {
        return valeur;
    }

    public int getVal() {
        return val;
    }

    public void add(ObservateurLancersDes o){
        this.observable.add(o);
    }

    public void remove(ObservateurLancersDes o){
        this.observable.remove(o);
    }

    public String toString(){
        return "total :"+this.valeur.toString();
    }
    public void notifyUpdate(){
        for(ObservateurLancersDes o:this.observable){
            o.update(this,this.val);
        }

    }

}
