package AgentPere;

import AbstractClass.ControleurPere;
import AgentVisualiserTab.AbstractionTab;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;


/**
 * Created by eng_r on 09/07/2019.
 */
public class PresentationPere {

    private ControleurPere controle;
    private BorderPane pane;
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private LineChart lineChart;
    public TableView table = new TableView();

    public PresentationPere(ControleurPere controle) {
        this.controle = controle;
        pane = new BorderPane();
        // Les éléments fils
        pane.setBottom(controle.getPresentationPalette());
        pane.setRight(controle.getPresentationChSaisie());
        // Ajouter le bouton
        this.controle.getPresentationPalette().getChildren().add(this.controle.getPresentationTab());
        // Ajouter la table
        // Le Graphe
        xAxis = new NumberAxis(0, 30, 1);
        xAxis.setLabel("Modification");
        yAxis = new NumberAxis(0, 100, 10);
        yAxis.setLabel("Température");
        lineChart = new LineChart(xAxis, yAxis);
        lineChart.setTitle("Changement de la Température");
        pane.setCenter(lineChart);
        table.setEditable(true);
    }

    public void changeChart(XYChart.Series series) {
        lineChart = new LineChart(xAxis, yAxis);
        lineChart.setTitle("Changement de la Température");
       // lineChart.getData().add(series);
        lineChart.getData().addAll(series);
        this.pane.setCenter(lineChart);
    }

    public BorderPane getPane() {
        return pane;
    }

    public LineChart getLineChart() {
        return lineChart;
    }

    public void loadTable() {
        ObservableList<AbstractionTab.Data> data = ((ControlePere)this.controle).getDataTable();
        table = new TableView<>();
        TableColumn modif = new TableColumn("Modification");
        modif.setCellValueFactory(new PropertyValueFactory<>("Modification"));
        TableColumn temp = new TableColumn("Température");
        temp.setCellValueFactory(new PropertyValueFactory<>("Température"));
        table.setItems(data);
        table.getColumns().addAll(modif, temp);
        table.setMaxWidth(180);
    }

    public void addTable() {
        this.pane.setLeft(table);
    }
}
