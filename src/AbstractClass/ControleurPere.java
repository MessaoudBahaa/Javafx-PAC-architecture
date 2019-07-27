package AbstractClass;

import AgentChampsDeSaisie.ControleChSaisie;
import AgentPalette.ControlePalette;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * Created by eng_r on 09/07/2019.
 */

public abstract class ControleurPere {

    protected ControleurFils filsPalette;
    protected ControleurFils filsChSaisie;
    protected ControleurFils filsTab;

    public Pane getPresentationChSaisie() {
        return filsChSaisie.getPresentation();
    }

    public Pane getPresentationPalette() {
        return filsPalette.getPresentation();
    }

    public Pane getPresentationTab() {
        return filsTab.getPresentation();
    }

    public abstract void update(int value);

    public abstract void setTemperature(int value);

    public abstract int getTemperature();

    public abstract void displayTable();

}
