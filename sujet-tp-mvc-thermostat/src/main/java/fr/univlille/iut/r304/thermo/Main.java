package fr.univlille.iut.r304.thermo;

import fr.univlille.iut.r304.thermo.model.Thermostat;
import fr.univlille.iut.r304.thermo.view.Controleur;
import fr.univlille.iut.r304.thermo.view.TextView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Thermostat thermo = new Thermostat();
		Controleur c = new Controleur(thermo,0.1);
		Controleur d = new Controleur(thermo, 1.0);
		TextView view = new TextView(c,thermo);
		TextView view1 = new TextView(d,thermo);
		thermo.add(view);
		thermo.add(view1);
	}

}
