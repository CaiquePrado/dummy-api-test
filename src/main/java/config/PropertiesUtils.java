package config;

import static config.FileReader.readFile;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertiesUtils {
  
  private static final Properties properties = new Properties();
  private static final Logger LOGGER = LogManager.getLogger(PropertiesUtils.class);

  public static String getBaseURI(String key){
    return PropertiesUtils.readProperties().getProperty(key);
  }

  private static Properties readProperties() {
        try {
            properties.load(readFile());
        } catch (IOException e) {
          LOGGER.error("Property not found", e);
        }
        return properties;
    }
}
