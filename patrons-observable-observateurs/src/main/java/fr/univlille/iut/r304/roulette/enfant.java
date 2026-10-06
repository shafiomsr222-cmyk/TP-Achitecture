package fr.univlille.iut.r304.roulette;

public class enfant implements Action{

    @Override
    public void update(Meteo m) {
        switch (m){
            case NUAGE -> System.out.println("un enfant observe les nuages");
            case SOLEIL -> System.out.println("un enfant joue dehors");
            case PLIUE -> System.out.println("un enfant joue dans la boue");
        }
    }
}
