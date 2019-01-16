package by.itacademy.demo;

/**
 * @author kirylhrybouski
 */
public class demo {

    public static void main(String[] args) {
        Instruments instruments = new BuilderInstruments();
        HouseHelper helper = new HouseHelper(instruments);
        helper.help();

        instruments = new Plumberinstrumnts();
        HouseHelper helper2 = new HouseHelper(instruments);
        helper2.help();
    }

}
