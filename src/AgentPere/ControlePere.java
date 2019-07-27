package AgentPere;

import AbstractClass.ControleurPere;
import AgentChampsDeSaisie.ControleChSaisie;
import AgentPalette.ControlePalette;
import AgentVisualiserTab.AbstractionTab;
import AgentVisualiserTab.ControleTab;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

/**
 * Created by eng_r on 09/07/2019.
 */
public class ControlePere extends ControleurPere {

    public static class Data {

        private final SimpleStringProperty temperature;

        private Data(String t) {
            this.temperature = new SimpleStringProperty(t);
        }

        public String getTemperature() {
            return temperature.get();
        }

    }

    private AbstractionPere abstractionPere;
    private PresentationPere presentationPere;
    private int modif = 0;

    private ObservableList<Data> data = FXCollections.observableArrayList(new Data("0"));

    private XYChart.Series series;

    public ControlePere() {
        abstractionPere = new AbstractionPere();
        this.filsChSaisie = new ControleChSaisie(this);
        this.filsPalette = new ControlePalette(this);
        this.filsTab = new ControleTab(this);
        // ajouter ici l instantiation d'un nouveau controle

        presentationPere = new PresentationPere(this);
        series = new XYChart.Series();
        series.setName("Degré Température");
        initialize();
    }

    public BorderPane getScene() {
        return this.presentationPere.getPane();
    }

    private void initialize() {
        int value = this.getTemperature();
        setTemperature(value);
        this.filsPalette.setTemp(value);
        this.filsChSaisie.setTemp(value);
        series.getData().add(new XYChart.Data<>(modif, value));
        this.presentationPere.changeChart(series);
    }

    @Override
    public void update(int value) {
        setTemperature(value);
        this.filsPalette.setTemp(value);
        this.filsChSaisie.setTemp(value);
        ((ControleTab)this.filsTab).setTemp(this.modif, value);


        // mise a jour de graphe (pere)
        modif++;
        series.getData().add(new XYChart.Data<>(modif, value));
        //System.out.println(series.getData());
        //this.presentationPere.changeChart(series);
        this.data.add(new Data(String.valueOf(value)));


        // Il faut rajouter ici des autres synchronisations s'il s'agit de nouveaux fils


    }

    @Override
    public void setTemperature(int value) {
        this.abstractionPere.setTemperature(value);
    }

    @Override
    public int getTemperature() {
        return this.abstractionPere.getTemperature();
    }

    @Override
    public void displayTable() {
        /*this.presentationPere.loadTable();
        this.presentationPere.addTable();*/
        this.presentationPere.table = new TableView();
        TableColumn temp = new TableColumn("Température");
        temp.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        this.presentationPere.table.setItems(data);
        this.presentationPere.table.getColumns().add(temp);
        this.presentationPere.table.setMaxWidth(180);
        this.presentationPere.getPane().setLeft(this.presentationPere.table);
    }

    public ObservableList<AbstractionTab.Data> getDataTable() {
        return ((ControleTab)this.filsTab).getData();
    }

}
