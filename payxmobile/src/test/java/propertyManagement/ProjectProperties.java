package propertyManagement;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ProjectProperties {

    private static final String PROPERTIES_FILE = "Config/project.properties";
    private static Properties properties = new Properties();

     static {

        System.out.println("Loading Project Property Block Started");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

        if (propertiesFile == null) {
            System.err.println("Properties file '" + PROPERTIES_FILE + "' is missing in classpath.");
        }

        try {
            properties.load(propertiesFile);
        } catch (IOException e) {
            System.err.println("Cannot load properties file '" + PROPERTIES_FILE + "'.");
        }
    }

    public static Properties getInstance(){
        return properties;
    }


    public static String getProperty(String name) {
        return properties.getProperty(name);
    }

    public static String getProperty(String name,String defaultValue) {
        return properties.getProperty(name,defaultValue);
    }


    public static void setProperty(String name, String value) throws IOException {
        properties.setProperty(name, value);
        properties.store(new FileWriter("mes1.properties"),"Writing file to properties");
    }
}
