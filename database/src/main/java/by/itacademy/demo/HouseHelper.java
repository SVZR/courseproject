package by.itacademy.demo;

/**
 * @author kirylhrybouski
 */
public class HouseHelper {

    private final Instruments instruments;

    public HouseHelper(Instruments instruments) {
    this.instruments = instruments;
    }

    public void help() {
        instruments.repair();
    }
}
