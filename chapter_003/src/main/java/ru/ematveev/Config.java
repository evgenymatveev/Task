package ru.ematveev;

import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The the connection configuration file.
 *
 * @author Matveev Evgeny.
 */
public class Config {
    /**
     * The object of the class Properties.
     */
    private static Properties logProprety = new Properties();
    /**
     * Keep the adress to file configuration.
     */
    private File logFile;

    Config(File logFile) {
        this.logFile = logFile;
    }

    /**
     * Initializerange connection configurations.
     */
    public void init() {
        try {
            logProprety.load(new FileInputStream(logFile));
            PropertyConfigurator.configure(logProprety);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


