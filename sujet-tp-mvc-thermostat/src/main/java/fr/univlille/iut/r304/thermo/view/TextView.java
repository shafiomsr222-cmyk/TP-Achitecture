package fr.univlille.iut.r304.thermo.view;

import fr.univlille.iut.r304.thermo.model.Thermostat;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TextView extends Stage implements ObservableDeThermostat {
	protected Label affichage;
	protected Button boutonMoins;
	protected Button boutonPlus;

	protected Controleur c;
	protected Thermostat thermostat ;
	public TextView(Controleur c,Thermostat thermostat) {
		super();
		this.c = c;
		this.thermostat = thermostat ;
		this.setTitle("Thermostat");
		this.setScene(this.createSceneContent());
		this.show();
	}

	private Scene createSceneContent() {

		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(10);
		hbox.setPadding(new Insets(5, 10, 5, 10));

		affichage = new Label();
		affichage.setMaxWidth(Region.USE_PREF_SIZE);
		affichage.setPrefWidth(30.0);
		affichage.setAlignment(Pos.CENTER_RIGHT);
		affichage.setText(thermostat.getTemprator()+"");
		boutonMoins = new Button("-");
		boutonPlus = new Button("+");
		ComboBox<Mode> combo = new ComboBox<>();
		combo.getItems().addAll(Mode.JOUR, Mode.NUIT, Mode.MANUEL);
		hbox.getChildren().addAll(
			boutonMoins, affichage,boutonPlus , combo
		);



		boutonPlus.setOnAction(e ->{
			c.changementTempPlus();
		});
		boutonMoins.setOnAction(e -> {
			c.changementTempMoin();
		});



		this.setOnCloseRequest(e -> {thermostat.remove(this);} );

		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.setPadding(new Insets(5, 10, 5, 10));
		vb.setSpacing(10);

		vb.getChildren().addAll( new Label( "Température en Celsius"), hbox);
		vb.setMaxWidth(Region.USE_PREF_SIZE);
		vb.setPrefWidth(250.0);
		return new Scene(vb);
	}

	public void update(Thermostat t){
		affichage.setText(String.valueOf(t.getTemprator()));
	}


}
