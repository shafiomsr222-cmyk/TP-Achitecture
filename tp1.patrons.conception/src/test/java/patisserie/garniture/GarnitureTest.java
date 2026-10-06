package patisserie.garniture;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import patisserie.garniture.Chantilly;
import patisserie.garniture.Chocolat;
import patisserie.Crepe;
import patisserie.Gaufre;
import patisserie.Dessert;

public class GarnitureTest {
    public final static double DELTA = 0.0001;

    @Test
    public void dessert_garni_doit_etre_au_bon_prix_et_bien_nomme() {
        Dessert d = new Chocolat( new Gaufre());
        assertEquals("Gaufre chocolat", d.getNom());
        assertEquals(5, d.getPrix(), DELTA);
        assertEquals("Gaufre chocolat – 5.0€", d.toString());
    }

    @Test
    public void dessert_multi_garni_doit_etre_au_bon_prix_et_bien_nomme() {
        Dessert d = new Chantilly( new Chocolat( new Chocolat( new Gaufre())));
        assertEquals("Gaufre chocolat chocolat chantilly", d.getNom());
        assertEquals(7.5, d.getPrix(), DELTA);
        assertEquals("Gaufre chocolat chocolat chantilly – 7.5€", d.toString());
    }

}
