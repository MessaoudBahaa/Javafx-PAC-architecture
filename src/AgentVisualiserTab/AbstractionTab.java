package AgentVisualiserTab;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by eng_r on 10/07/2019.
 */
public class AbstractionTab {

    public static class Data {
        private final SimpleStringProperty modification;
        private final SimpleStringProperty temperature;

        private Data(String m, String t) {
            this.modification = new SimpleStringProperty(m);
            this.temperature = new SimpleStringProperty(t);
        }

        public String getModifiation() {
            return modification.get();
        }

        public String getTemperature() {
            return temperature.get();
        }
    }

    private ObservableList<Data> data = FXCollections.observableArrayList(new Data("0", "0"));

    public void addTemp(int modif, int value) {
        data.add(new Data(String.valueOf(modif), String.valueOf(value)));
        //System.out.println(data.size());
    }

    public ObservableList<Data> getData() {
        return this.data;
    }

}
