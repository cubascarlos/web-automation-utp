package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Util {

    public static String getFromConfigFile(String propertie) {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/config.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties.getProperty(propertie);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
