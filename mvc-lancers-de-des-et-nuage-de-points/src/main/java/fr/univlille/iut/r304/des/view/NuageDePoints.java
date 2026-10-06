package fr.univlille.iut.r304.des.view;

import fr.univlille.iut.r304.des.model.LancersDes;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.format.TextStyle;
import java.util.Map;
import java.util.Scanner;

public class NuageDePoints extends Stage implements ObservateurLancersDes{

    protected ScatterChart<Number, Number> nuage;
    protected XYChart.Series<Number, Number> serie;
    protected XYChart.Series<Number, Number> serieCSV;

    protected LancersDes modele;
    Label text = new Label();

    public NuageDePoints(LancersDes modele) {
        this.modele = modele ;
        Button lancer = new Button("Lancer un dé");
        lancer.setOnAction(e ->{modele.lancerDe(); });
        Button charger = selecteurFichier(modele);
        VBox vb = new VBox(creerNuage(modele), lancer, charger,text);
        Scene sc = new Scene(vb);
        sc.getStylesheets().add("scatterchart-styles.css");
        this.setScene(sc);
        this.setTitle("Scores de lancers de dés");
        this.show();
    }

    protected ScatterChart<?,?> creerNuage(LancersDes modele) {
        NumberAxis xaxis = new NumberAxis("Face du dé",1, 10, 1);
        NumberAxis yaxis = new NumberAxis("Nombre de fois",0, 8, 1);
        xaxis.setAutoRanging(true);
        yaxis.setAutoRanging(true);
        nuage = new ScatterChart<>(xaxis, yaxis);
        this.serie = creerSerie("score");
        this.serieCSV = creerSerie("CSV");
        this.remplirSerie(modele);
        nuage.getData().add(serie);
        nuage.getData().add(serieCSV);
        return nuage;
    }

    private XYChart.Series<Number, Number> creerSerie(String nom) {
        XYChart.Series<Number, Number> serie = new XYChart.Series<>();
        serie.setName(nom);
        return serie;
    }

    private void remplirSerie(LancersDes modele) {
        //Point ajouté pour l'exemple
        serie.getData().clear();
        for(Map.Entry<Integer, Integer> entry : modele.getValeur().entrySet()){
            XYChart.Data<Number,Number> chartPoint = new XYChart.Data<>(entry.getKey(), entry.getValue());
            serie.getData().add(chartPoint);

        }

    }

    public Button selecteurFichier(LancersDes modele) {
        Button charger = new Button("Charger");
        charger.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("src/main/resources/"));
            fileChooser.setTitle("Charger fichier ...");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers CSV", "*.csv"));
            File selectedFile = fileChooser.showOpenDialog(this);
            //TODO chargement du fichier
            if(selectedFile == null){
                 return;
            }
            try {

                this.serieCSV.getData().clear();
                Scanner scan = new Scanner(selectedFile);
                int[] frequante = new int[10];
                for(int i = 0 ; i < 10; i++){
                    frequante[i] = 0;
                }
                while (scan.hasNextLine()) {

                    String ligne = scan.nextLine();
                    String[] donne = ligne.split(",");
                    frequante[Integer.parseInt(donne[1])-1]++;


                }
                for(int i = 1 ; i<=10 ;i++){
                    XYChart.Data<Number, Number> chartpoint = new XYChart.Data<>(i,frequante[i-1]);
                    this.serieCSV.getData().add(chartpoint);
                }

            }catch (Exception x){
                x.printStackTrace();
            }
        });
        return charger;
    }

    public void update(LancersDes d , int valeur){
        this.modele = d;
        this.remplirSerie(this.modele);
    }


}
