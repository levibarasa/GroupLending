package com.sim.gls.prop;

/**
 *
 * @author Levi
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlsProp {

    Properties prop;

    public GlsProp() {
    }

    public Properties getDBProperty() {
        prop = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            InputStream url = classLoader.getResourceAsStream("com/sim/gls/prop/Gls.properties");
            prop.load(url);
        } catch (IOException asd) {
            System.out.println(asd.getMessage());
        }
        return prop;
    }
}

