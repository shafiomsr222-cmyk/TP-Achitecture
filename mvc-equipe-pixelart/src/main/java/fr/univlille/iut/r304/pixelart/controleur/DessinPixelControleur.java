package fr.univlille.iut.r304.pixelart.controleur;

import fr.univlille.iut.r304.pixelart.modele.CouleurPixel;
import fr.univlille.iut.r304.pixelart.modele.DessinPixel;

public class DessinPixelControleur {

    private DessinPixel d;


    public DessinPixelControleur(DessinPixel s){
        this.d=s;
    }
    public void clicCouleur(CouleurPixel couleur) {
        //TODO tour 1
        d.choixCouleur(couleur);
    }

    public void clicDessin(int ligne, int colonne) {
        //TODO tour 2
        d.colorier(ligne,colonne);
    }

    public void clicBoutonToutPeindre() {
        //TODO tour 3
        d.colorierTout();
    }

    public void clicBoutonRedimensionner(String nbLignes, String nbCols) {
        //TODO tour 4
    }

}