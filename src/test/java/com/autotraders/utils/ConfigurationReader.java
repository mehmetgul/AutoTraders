package com.autotraders.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    /**
     * To retrieve data from configuration.properties file.
     */
    private static Properties configFile;

    static {
        try {

            //File path of configuration.properties
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            //initialize properties object
            configFile = new Properties();
            //load configuration.properties file
            configFile.load(fileInputStream);
            //close input stream
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Failed to load properties file!");
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }

}
