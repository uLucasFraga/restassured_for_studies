package integrations.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HandleProperties {

  private static final String DATA_CONFIG = "./src/test/resources/config.properties";
  private static Properties properties;

  public static String getValue(String value) {
    try {
      if (properties == null) {
        HandleProperties.properties = new Properties();
        HandleProperties.properties.load(new FileInputStream(DATA_CONFIG));
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    return HandleProperties.properties.getProperty(value);
  }
}
