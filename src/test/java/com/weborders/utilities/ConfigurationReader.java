package com.weborders.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties configFile;

    static { //the static block will be executed only once, whenever someone calls this class.
        // Static block has the highest priority in terms of execution order
        // 1.static block ==> 2. instance block ==>  3.constructor
        try {
            //location of properties file
            String path = System.getProperty("user.dir") + "\\configuration.properties"; //configuration.properties file path
            //get that file as a stream
            FileInputStream input = new FileInputStream(path);
            //create object of Properties class
            configFile = new Properties();
            //load configuration.properties file into Properties object
            configFile.load(input);
            //close the input stream at the end
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }

    /**
     * This method returns property value from configuration.properties file
     *
     * @param keyName property name
     * @return property value
     */
    public static String getProperty(String keyName) { // call this method and provide a key name to get the value.
        // Ex: ConfigurationReader.getProperty("browser")
        return configFile.getProperty(keyName);
    }


}
