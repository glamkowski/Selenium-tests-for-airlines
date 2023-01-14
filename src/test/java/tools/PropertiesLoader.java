package tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static String getProperty(String property) throws IOException {
        InputStream inputStream = new FileInputStream("src/test/resources/config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties.getProperty(property);
    }

}
