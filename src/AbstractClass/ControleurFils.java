package AbstractClass;

import javafx.scene.layout.Pane;

/**
 * Created by eng_r on 09/07/2019.
 */

public abstract class ControleurFils {

    protected ControleurPere controleurPere;

    public ControleurFils(ControleurPere controleurPere) {
        this.controleurPere = controleurPere;
    }

    public abstract void notifierPere(int value);

    public abstract void setTemp(int value);

    public abstract Pane getPresentation();

}
