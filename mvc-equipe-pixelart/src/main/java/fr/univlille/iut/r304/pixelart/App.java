package fr.univlille.iut.r304.pixelart;

import fr.univlille.iut.r304.pixelart.modele.CouleurPixel;
import fr.univlille.iut.r304.pixelart.modele.DessinPixel;
import fr.univlille.iut.r304.pixelart.vue.DessinPixelVue;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        DessinPixel modele = new DessinPixel(8,8);
        DessinPixelVue vue = new DessinPixelVue(modele);
        modele.add(vue);
        modele.choixCouleur(CouleurPixel.BLEU);
        modele.colorier(1,3);
        modele.colorier(1,4);
        modele.colorier(1,5);
        modele.colorier(2,3);
        modele.colorier(3,3);
        modele.colorier(3,4);
        modele.colorier(3,5);
        modele.colorier(4,5);
        modele.colorier(5,5);
        modele.colorier(5,4);
        modele.colorier(5,3);

    }
}
