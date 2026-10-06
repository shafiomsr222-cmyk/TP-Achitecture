package fr.univlille.iut.r304.pixelart.modele;

import fr.univlille.iut.r304.pixelart.vue.DessinPixelObservateur;

import java.util.ArrayList;
import java.util.List;

public class DessinPixel {

    private int nbLignes;
    private int nbColonnes;
    private CouleurPixel couleurPinceau;
    private CouleurPixel[][] grille;
    private List<DessinPixelObservateur> observateurs;

    public DessinPixel(int nbLignes, int nbColonnes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.couleurPinceau = CouleurPixel.NOIR;
        this.grille = new CouleurPixel[nbLignes][nbColonnes];
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                this.grille[i][j] = CouleurPixel.BLANC;
            }
        }
        this.observateurs = new ArrayList<>();
    }

    public CouleurPixel getCouleurPinceau() {
        return this.couleurPinceau;
    }

    /**
     * Ajoute un abonné au modèle
     * @param o: l'observateur qui s'abonne au modèle"
     */
    public void add(DessinPixelObservateur obs) {
        if (obs != null && !this.observateurs.contains(obs)) {
            this.observateurs.add(obs);
        }
    }

    /**
     * Retire un abonné du modèle
     * @param o: l'observateur qui se désabonne du modèle
     */
    public void remove(DessinPixelObservateur o) {
        this.observateurs.remove(o);
    }

    public int getNbLignes(){
        return this.nbLignes;
    }

    public int getNbCols() {
        return this.nbColonnes;

    }

    /**
     * Change la couleur utilisée pour colorier
     * @param couleur la couleur à utiliser pour colorier
     */
    public void choixCouleur(CouleurPixel couleur) {
        this.couleurPinceau = couleur;
    }

    /**
     * Retourne la couleur d'un pixel
     * @param ligne: ligne du pixel
     * @param col: colonne du pixel
     * @return la couleur du pixel
     */
    public CouleurPixel getCouleur(int ligne, int col) {
        return this.grille[ligne][col];

    }

    /**
     * Colore toute la grille d'une couleur avec celle actuelle
     */
    public void colorierTout() {
        for (int colone = 0; colone< this.grille.length; colone++){
            for (int ligne = 0; ligne< this.grille[0].length; ligne++){
                this.grille[colone][ligne] = this.getCouleurPinceau();
            }
        }
        this.notifyAllObservers();
    }

    private void notifyAllObservers(){
        for (DessinPixelObservateur o : this.observateurs){
            o.update(this);
        }
    }

    /**
     * Change la couleur d'un pixel par celle actuelle
     * @param ligne: ligne du pixel
     * @param col: colonne du pixel
     */
    public void colorier(int ligne, int col) {
        //TODO tour 3
        this.grille[col][ligne] = this.getCouleurPinceau();
        this.notifyAllObservers();
    }


    /**
     * On redimensionne la grille à la taille passée en paramètre
     * Si la taille augmente, les pixels ajoutés sont blancs
     * Les couleurs des pixels de l'ancienne grille sont conservées
     * @param nbLigne: nouvelle hauteur de la grille
     * @param nbColonne: nouvelle largeur de la grille
     */
    public void redimensionner(int nbLigne, int nbColonne) {
        //TODO tour 4
    }

}