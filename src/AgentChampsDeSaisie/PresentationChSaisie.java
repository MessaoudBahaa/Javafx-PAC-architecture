package AgentChampsDeSaisie;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by eng_r on 09/07/2019.
 */
public class PresentationChSaisie {

    private Label label;
    private TextField textField;
    private Button appendBtn;
    private Pane vBox;
    private ControleChSaisie controle;

    public PresentationChSaisie(ControleChSaisie controle) {
        label = new Label("Température (Celsius) =");
        textField = new TextField();
        this.controle = controle;
        appendBtn = new Button("Valider");
        vBox = new VBox(10);
        vBox.getChildren().add(label);
        vBox.getChildren().add(textField);
        vBox.getChildren().add(appendBtn);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        handleEvents();
    }

    public Pane getvBox() {
        return vBox;
    }

    public void setValue(int value) {
        textField.setText(Integer.toString(value));
    }

    private void handleEvents() {
        appendBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controle.updateTemp();
            }
        });
    }

    public int getTemp() {
        return Integer.valueOf(this.textField.getText());
    }
}
