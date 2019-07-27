package AgentVisualiserTab;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * Created by eng_r on 10/07/2019.
 */
public class PresentationTab {

    private ControleTab controle;
    private Button button;
    private StackPane pane;

    public PresentationTab(ControleTab controle) {
        this.controle = controle;
        button = new Button("Show table");
        pane = new StackPane();
        pane.getChildren().add(button);
        pane.setPadding(new Insets(10, 10, 10, 10));
        // Handle Events
        handleEvents();
    }

    private void handleEvents() {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controle.notifierPere(0); //0 pour dire il faut afficher le tableau
            }
        });
    }

    public Pane getPane() {
        return this.pane;
    }

}
