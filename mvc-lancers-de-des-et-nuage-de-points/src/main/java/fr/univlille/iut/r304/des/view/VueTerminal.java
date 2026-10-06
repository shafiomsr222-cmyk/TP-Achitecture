package fr.univlille.iut.r304.des.view;

import fr.univlille.iut.r304.des.model.LancersDes;

public class VueTerminal implements ObservateurLancersDes {
    private LancersDes modele;
    public VueTerminal(LancersDes modele) {
        this.modele = modele ;
    }



    public void update(LancersDes d , int valeur){
        this.modele = d;
        System.out.println(valeur);
    }

}
