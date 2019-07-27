package AgentPere;

/**
 * Created by eng_r on 09/07/2019.
 */

public class AbstractionPere {

    private int temperature;

    public AbstractionPere() {
        this.temperature = 0;
    }

    public AbstractionPere(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
