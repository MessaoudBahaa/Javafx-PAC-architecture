package AgentVisualiserTab;

import AbstractClass.ControleurFils;
import AbstractClass.ControleurPere;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;

/**
 * Created by eng_r on 10/07/2019.
 */
public class ControleTab extends ControleurFils{

    private PresentationTab presentationTab;
    private AbstractionTab abstractionTab;

    public ControleTab(ControleurPere controleurPere) {
        super(controleurPere);
        abstractionTab = new AbstractionTab();
        presentationTab = new PresentationTab(this);
    }

    @Override
    public void notifierPere(int value) {
        this.controleurPere.displayTable();
    }

    @Override
    public void setTemp(int value) {

    }

    public void setTemp(int modif, int value) {
        this.abstractionTab.addTemp(modif, value);
    }

    @Override
    public Pane getPresentation() {
        return this.presentationTab.getPane();
    }

    public ObservableList<AbstractionTab.Data> getData() {
        return this.abstractionTab.getData();
    }
}
