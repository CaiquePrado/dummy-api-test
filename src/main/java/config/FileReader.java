package config;

import static java.nio.file.Files.newInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileReader {
  
  private static final String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();
  private static final Logger LOGGER = LogManager.getLogger(FileReader.class);

  public static InputStream readFile(){
    InputStream input = null;
     String path = "src"
                + FILE_SEPARATOR
                + "main"
                + FILE_SEPARATOR
                + "resources"
                + FILE_SEPARATOR
                + "dados-ambientes"
                + FILE_SEPARATOR
                + Environment.getEnvironment()
                + FILE_SEPARATOR
                + "application-"
                + Environment.getEnvironment()
                + ".properties";
        try {
            input = newInputStream(Path.of(path));
        } catch (IOException e) {
            LOGGER.error("File not found", e);
        }
        return input;
  }
}
