package fr.univlille.iut.r304.thermo.model;

import fr.univlille.iut.r304.thermo.view.Mode;
import fr.univlille.iut.r304.thermo.view.ObservableDeThermostat;

import java.util.ArrayList;
import java.util.List;

public class Thermostat {
private double temprator;
private Mode mode;
protected List<ObservableDeThermostat> observer;

public Thermostat(Mode m){
    this.observer = new ArrayList<>();
    this.temprator = 0;
    this.mode = m;
}

public void modeJour(Mode m){
    switch (m){
        case JOUR -> setTemprator(18);
        case NUIT -> setTemprator(15);
    }
}

public void changementTemp(double d){
    setTemprator(d);
}
public void augementeTemp(double d){
    setTemprator(getTemprator()+d);
    notifyObserver();
}

public void reduireTemp(double d){
    setTemprator(getTemprator()-d);
    notifyObserver();
}
    public double getTemprator() {
        return temprator;
    }

    public void setTemprator(double temprator) {
        this.temprator = temprator;
    }

    public void add(ObservableDeThermostat o){
    this.observer.add(o);
}

public void remove(ObservableDeThermostat o){
    this.observer.remove(o);
}

protected void notifyObserver(){
    for(ObservableDeThermostat e: this.observer){
        e.update(this);
    }
}




}
