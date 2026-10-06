package fr.univlille.iut.r304.roulette;

public class Chat implements Action{
    @Override
    public void update(Meteo m) {
        switch (m){
            case SOLEIL -> System.out.println("un Chat se prélasse");
            case PLIUE -> System.out.println("un Chat regarde à l'intérieur");
            case NUAGE -> System.out.println("un Chat se balade dans le jardin");

        }
    }
}
