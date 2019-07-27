package AgentChampsDeSaisie;

import AbstractClass.ControleurFils;
import AbstractClass.ControleurPere;
import javafx.scene.layout.Pane;

/**
 * Created by eng_r on 09/07/2019.
 */
public class ControleChSaisie extends ControleurFils {

    private AbstractionChSaisie abstractionChSaisie;
    private PresentationChSaisie presentationChSaisie;

    public ControleChSaisie(ControleurPere controleurPere) {
        super(controleurPere);
        this.abstractionChSaisie = new AbstractionChSaisie(controleurPere.getTemperature());
        this.presentationChSaisie = new PresentationChSaisie(this);
    }


    @Override
    public void notifierPere(int value) {
        this.controleurPere.update(value);
    }

    @Override
    public Pane getPresentation() {
        return this.presentationChSaisie.getvBox();
    }

    @Override
    public void setTemp(int value) {
        this.abstractionChSaisie.setTemperature(value);
        this.presentationChSaisie.setValue(value);
    }

    public void updateTemp() {
        int value = this.presentationChSaisie.getTemp();
        this.abstractionChSaisie.setTemperature(value);
        notifierPere(value);
    }
}
