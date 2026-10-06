package fr.univlille.iut.r304.roulette;

public class Main {

    public static void main(String[] args) {

        Chat c = new Chat();
        enfant e = new enfant();

        Metéo metéo = new Metéo();

        metéo.add(c);
        metéo.add(e);

        metéo.changeMateo(Meteo.PLIUE);

        Joueur j = new Joueur("Hal", 42);
        Joueur s = new Joueur("dja",7);
        Joueur d = new Joueur("Alice",new StratAlice());
        Joueur f = new Joueur("Moussa",new StratMoussa());
        Joueur mart = new Joueur("mart",new Martingale());
        Annonceur a = new Annonceur();
        Roulette roulette = new Roulette();

        roulette.add(a);
        roulette.add(j);
        roulette.add(s);
        roulette.add(d);
        roulette.add(f);
        roulette.add(mart);

        for (int i = 0; i < 10; i++) {
            roulette.lancer();
        }

    }
}
