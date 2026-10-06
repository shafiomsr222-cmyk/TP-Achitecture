package patisserie.Assortiment;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import patisserie.Dessert;
import patisserie.garniture.Chocolat;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import patisserie.Crepe;
import patisserie.Gaufre;

class AssortimentTest {
    static Assortiment assor = new Assortiment("dooo");

    @BeforeAll
    static void setup(){
        Dessert gauf = new Chocolat(new Gaufre());
        Dessert crepe = new Chocolat(new Crepe());
        Dessert gaufreA = new Gaufre();
        Dessert crepeB = new Crepe();


        assor.add(gauf);
        assor.add(crepe);
        assor.add(gaufreA);
        assor.add(crepeB);
    }

    @Test
    void getNom() {

        assertEquals("dooo ( Gaufre chocolat Crepe chocolat Gaufre Crepe  )",assor.getNom());

    }

    @Test
    void getPrix() {

        assertEquals(14.4,assor.getPrix());

    }
}