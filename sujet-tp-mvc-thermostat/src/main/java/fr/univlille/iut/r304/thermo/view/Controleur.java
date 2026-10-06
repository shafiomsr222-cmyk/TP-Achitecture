package fr.univlille.iut.r304.thermo.view;

import fr.univlille.iut.r304.thermo.model.Thermostat;

public class Controleur {
  private Thermostat thermostat;
  private double increment;
    public Controleur(Thermostat t, double d){
        this.thermostat = t;
        this.increment = d;
    }
    public void changementTempPlus(){
        this.thermostat.augementeTemp(this.increment);
    }

    public void changementTempMoin(){
        this.thermostat.reduireTemp(this.increment);
    }

    public double getIncrement() {
        return increment;
    }
}
