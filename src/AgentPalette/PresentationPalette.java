package AgentPalette;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Created by eng_r on 09/07/2019.
 */
public class PresentationPalette {

    private ControlePalette controle;
    private Button augBtn;
    private Button dimBtn;
    private Button resetBtn;
    private HBox hBox;

    public PresentationPalette(ControlePalette controle) {
        augBtn = new Button("Augmenter");
        dimBtn = new Button("Diminuer");
        resetBtn = new Button("Remise à Zero");
        hBox = new HBox(10);
        hBox.getChildren().add(augBtn);
        hBox.getChildren().add(dimBtn);
        hBox.getChildren().add(resetBtn);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setAlignment(Pos.CENTER);
        this.controle = controle;
        // Handle Events
        handleEvents();
    }

    public HBox gethBox() {
        return hBox;
    }

    private void handleEvents() {
        augBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controle.augmenter();
            }
        });
        dimBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controle.diminuer();
            }
        });
        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controle.reset();
            }
        });
    }
}
