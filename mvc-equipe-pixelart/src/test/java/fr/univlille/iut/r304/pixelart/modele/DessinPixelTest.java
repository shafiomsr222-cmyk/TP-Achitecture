package fr.univlille.iut.r304.pixelart.modele;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DessinPixelTest {
    private DessinPixel dessinPixel;

    @BeforeEach
    public void beforeTest() {
        this.dessinPixel = new DessinPixel(12, 12);
    }

    @Test
    @DisplayName("Test de la couleur par défaut de pinceau")
    public void testDefaultDefinitionsCouleursPinceau() {
        assertEquals(CouleurPixel.BLANC, dessinPixel.getCouleurPinceau());
    }

    @Test
    @DisplayName("Test de toutes les couleurs de la palette sur le pinceau")
    public void testToutesCouleursPinceau() {
        for (CouleurPixel couleur : CouleurPixel.values()) {
            dessinPixel.choixCouleur(couleur);
            assertEquals(couleur, dessinPixel.getCouleurPinceau());
        }
    }

    @Test
    @DisplayName("Test choisir deux fois la même couleur sur pinceau")
    public void testDeuxFoisLaMemeCouleurPinceau() {
        dessinPixel.choixCouleur(CouleurPixel.CYAN);
        dessinPixel.choixCouleur(CouleurPixel.CYAN);
        assertEquals(CouleurPixel.CYAN, dessinPixel.getCouleurPinceau());
    }

    @Test
    @DisplayName("Test colorier tout")
    public void testToutcolorier() {
        dessinPixel.colorierTout();
        for (int colone = 0; colone < dessinPixel.getNbCols(); colone++) {
            for (int ligne = 0; ligne < dessinPixel.getNbLignes(); ligne++) {
                assertEquals(dessinPixel.getCouleur(colone, ligne), dessinPixel.getCouleurPinceau());

            }
        }

    }

    @Test
    @DisplayName("Test colorier")
    public void testColorier(){
        dessinPixel.colorier(0,0);
        assertEquals(dessinPixel.getCouleur(0,0),dessinPixel.getCouleurPinceau());
    }
}