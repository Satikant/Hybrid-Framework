package propertyManagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by ayush.singh on 10-10-2019.
 */
public class TestCases {
    public static final String PROPERTIES_FILE = "Config/TestCases.properties";
    private static Properties properties = new Properties();
    private static Logger logger = LoggerFactory.getLogger(TestCases.class);


    static {

        System.out.println("Loading Test Cases Property Block Started");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

        if (propertiesFile == null) {
            System.err.println("Properties file '" + PROPERTIES_FILE + "' is missing in classpath.");
            logger.error("Properties file '" + PROPERTIES_FILE + "' is missing in classpath.");

        }

        try {
            properties.load(propertiesFile);
        } catch (IOException e) {
            System.err.println("Cannot load properties file '" + PROPERTIES_FILE + "'.");
            logger.error("Cannot load properties file :'" + PROPERTIES_FILE + "'");
        }
    }
    public static String getProperty(String name) {
        return properties.getProperty(name);
    }

    public static void setProperty(String name, String value) {
        properties.setProperty(name, value);
    }

    public static String getTestCase(String KEY) {
        properties.getProperty(KEY);
         String keyValue="";
         keyValue = KEY + ": " + properties.getProperty(KEY);
        return keyValue;
    }
}
