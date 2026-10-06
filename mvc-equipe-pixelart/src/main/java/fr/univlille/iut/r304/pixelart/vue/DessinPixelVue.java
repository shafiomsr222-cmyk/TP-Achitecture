package fr.univlille.iut.r304.pixelart.vue;

import fr.univlille.iut.r304.pixelart.controleur.DessinPixelControleur;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import fr.univlille.iut.r304.pixelart.modele.CouleurPixel;
import fr.univlille.iut.r304.pixelart.modele.DessinPixel;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DessinPixelVue extends Stage implements DessinPixelObservateur {

    protected static final int TAILLE_PIXEL = 20;
    protected BorderPane conteneurPrincipal;
    protected GridPane dessin;
    protected GridPane palette;
    protected Rectangle couleurPinceau;
    protected DessinPixelControleur controleur;

    public DessinPixelVue(DessinPixel modele) {
        //TODO tour 1
        this.controleur = new DessinPixelControleur(modele);
        this.palette = creerPalette();
        this.couleurPinceau = new Rectangle(TAILLE_PIXEL, TAILLE_PIXEL);
        this.dessin = creerDessin(modele);
        conteneurPrincipal = new BorderPane();
        this.setScene(new Scene(conteneurPrincipal));
        this.setTitle("Pixel Art");
        VBox outils = creerBoiteOutils();
        conteneurPrincipal.setLeft(dessin);
        conteneurPrincipal.setRight(outils);
        this.show();
    }

    private VBox creerBoiteOutils() {
        Button boutonTout = new Button("Tout !");
        boutonTout.setOnAction(e -> {});
        Button redimensionner = new Button("Redimensionner !");
        TextField saisieHauteur = new TextField("Hauteur");
        TextField saisieLargeur = new TextField("Largeur");
        return new VBox(palette, boutonTout, couleurPinceau, saisieHauteur, saisieLargeur, redimensionner);
    }

    public void setControleur(DessinPixelControleur controleur){
        this.controleur = controleur;
    }

    protected GridPane creerPalette() {
        GridPane gridPane = new GridPane();
        for (int ligne = 0; ligne < 3; ligne++) {
            for (int col = 0; col < 3; col++) {
                Rectangle carre = new Rectangle(TAILLE_PIXEL, TAILLE_PIXEL);
                gridPane.add(carre, col, ligne);
                CouleurPixel c = CouleurPixel.values()[ligne*3+col];
                carre.setFill(Color.rgb(c.rouge, c.vert, c.bleu));
            }
        }
        return gridPane;
    }

    protected GridPane creerDessin(DessinPixel modele) {
        GridPane gridPane = new GridPane();
        // tour 1
        for(int i = 0; i< modele.getNbLignes();i++){
            for (int j = 0; j<modele.getNbCols(); j++){
                Rectangle carre = new Rectangle(100, 100);
                gridPane.add(carre,i,j);
            }
        }
        //Les 2 lignes suivantes sont à remplacer par votre code
        return gridPane;
    }

    @Override
    public void update(CouleurPixel c) {
        // tour 1
            this.couleurPinceau.setFill(Color.rgb(c.rouge,c.vert,c.bleu));
    }

    @Override
    public void update(DessinPixel modele) {
        this.dessin.getChildren().clear();
        for (int i = 0; i < modele.getNbLignes(); i++) {
            for (int j = 0; j < modele.getNbCols(); j++) {
                Rectangle carre = new Rectangle(TAILLE_PIXEL, TAILLE_PIXEL);
                CouleurPixel c = modele.getCouleur(i, j);
                if (c != null) {
                    carre.setFill(Color.rgb(c.rouge, c.vert, c.bleu));
                } else {
                    carre.setFill(Color.rgb(255,255,255));
                }
                this.dessin.add(carre, i, j);
            }
        }
    }

    @Override
    public void update(int ligne, int col, CouleurPixel c) {
        this.dessin.getChildren().clear();
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < col; j++) {
                Rectangle carre = new Rectangle(TAILLE_PIXEL, TAILLE_PIXEL);
                if (c != null) {
                    carre.setFill(Color.rgb(c.rouge, c.vert, c.bleu));
                } else {
                    carre.setFill(Color.rgb(255,255,255));
                }
                this.dessin.add(carre, i, j);
            }
        }
    }

}