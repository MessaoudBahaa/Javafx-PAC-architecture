package AgentPalette;

/**
 * Created by eng_r on 09/07/2019.
 */

public class AbstractionPalette {

    private int temperature;

    public AbstractionPalette(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void reset() {
        this.temperature = 0;
    }

    public void augmenter(int value) {
        temperature += value;
    }

    public void diminuer(int value) {
        temperature -= value;
    }
}
