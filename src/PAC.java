import AbstractClass.ControleurPere;
import AgentPere.ControlePere;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by eng_r on 09/07/2019.
 */

public class PAC extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ControlePere controle = new ControlePere();
        BorderPane pane = controle.getScene();
        Scene scene = new Scene(pane, 1200, 600);
        primaryStage.setTitle("TP PAC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
