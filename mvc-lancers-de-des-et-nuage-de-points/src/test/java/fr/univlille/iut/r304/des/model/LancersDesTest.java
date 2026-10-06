package fr.univlille.iut.r304.des.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LancersDesTest {

    LancersDes d = new LancersDes();

    @Test
    public void testLance(){
        int face = 10;
        for(int i = 0 ; i < 10 ;i++){
            d.lancerDe();
        }
        int sum = 0;
        for(int j : d.getValeur().values()){
            sum+=j;
        }
        assertEquals(sum,face);
    }



}
