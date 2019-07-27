package AgentPalette;

import AbstractClass.ControleurFils;
import AbstractClass.ControleurPere;
import javafx.scene.layout.Pane;

/**
 * Created by eng_r on 09/07/2019.
 */
public class ControlePalette extends ControleurFils {

    private AbstractionPalette abstractionPalette;
    private PresentationPalette presentationPalette;


    public ControlePalette(ControleurPere controleurPere) {
        super(controleurPere);
        abstractionPalette = new AbstractionPalette(controleurPere.getTemperature());
        presentationPalette = new PresentationPalette(this);
    }

    @Override
    public void notifierPere(int value) {
        this.controleurPere.update(value);
    }

    public void augmenter() {
        this.abstractionPalette.augmenter(10);
        notifierPere(this.abstractionPalette.getTemperature());
    }

    public void diminuer() {
        this.abstractionPalette.diminuer(10);
        notifierPere(this.abstractionPalette.getTemperature());
    }

    public void reset() {
        this.abstractionPalette.reset();
        notifierPere(this.abstractionPalette.getTemperature());
    }

    @Override
    public void setTemp(int value) {
        this.abstractionPalette.setTemperature(value);
        // Mettre à jour l'affichage aussi si possible
    }

    @Override
    public Pane getPresentation() {
        return this.presentationPalette.gethBox();
    }
}
