package by.itacademy.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kirylhrybouski
 */

@Configuration
public class HelperFactory {

    @Bean
    public void plumber() {
        Instruments instruments = plumberInstruments();
        HouseHelper helper = new HouseHelper(instruments);
    }

    @Bean
    public static void builder() {
        Instruments instruments = buildInstruments();
        HouseHelper helper = new HouseHelper(instruments);
    }

    @Bean
    public static Instruments buildInstruments() {
        return new BuilderInstruments();
    }

    @Bean
    public Instruments plumberInstruments() {
        return new BuilderInstruments();
    }


}
