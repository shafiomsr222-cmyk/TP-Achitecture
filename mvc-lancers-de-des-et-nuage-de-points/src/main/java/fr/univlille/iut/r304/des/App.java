package fr.univlille.iut.r304.des;

import fr.univlille.iut.r304.des.model.LancersDes;
import fr.univlille.iut.r304.des.view.NuageDePoints;
import fr.univlille.iut.r304.des.view.ObservateurLancersDes;
import fr.univlille.iut.r304.des.view.VueTerminal;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        LancersDes modele = new LancersDes();
        NuageDePoints n =new NuageDePoints(modele);
        ObservateurLancersDes s =new VueTerminal(modele);
        modele.add(s);
        modele.add(n);
    }



}
