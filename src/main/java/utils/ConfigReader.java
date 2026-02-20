package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties prop;

    static {
        try {
            FileInputStream fis =
                    new FileInputStream("src/resources/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
