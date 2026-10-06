package org.example;

import patisserie.Assortiment.Assortiment;
import patisserie.Crepe;
import patisserie.Dessert;
import patisserie.Gaufre;
import patisserie.garniture.Chocolat;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Dessert gauf = new Chocolat(new Gaufre());
        Dessert crepe = new Chocolat(new Crepe());
        Dessert gaufreA = new Gaufre();
        Dessert crepeB = new Crepe();

        Assortiment assor = new Assortiment("dodo");

        assor.add(gauf);
        assor.add(crepe);
        assor.add(gaufreA);
        assor.add(crepeB);
        System.out.println(assor.getNom()+" "+assor.getPrix());

        assor.remove(gauf);
        System.out.println(assor.getNom()+" "+assor.getPrix());
    }
}