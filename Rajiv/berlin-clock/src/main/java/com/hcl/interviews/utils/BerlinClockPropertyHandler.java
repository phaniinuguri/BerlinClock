package com.hcl.interviews.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Properties;

public class BerlinClockPropertyHandler {
	private static volatile BerlinClockPropertyHandler instance = null;
    private Properties properties;

    protected BerlinClockPropertyHandler() throws IOException, URISyntaxException{

        properties = new Properties();
		String pathOfAbsolute = this.getClass().getProtectionDomain()
				.getCodeSource().getLocation().toString();
		String propertiesFilePath = pathOfAbsolute
				+ "berlinClock.properties";
		propertiesFilePath = propertiesFilePath.replace("file:/", "").replace(
				"/", "\\");
		Paths.get(new URI(pathOfAbsolute));
		InputStream input = ClassLoader.getSystemResourceAsStream(propertiesFilePath);
		input = new FileInputStream(propertiesFilePath);
		properties.load(input);

    }

    public static BerlinClockPropertyHandler getInstance() {
        if(instance == null) {
            try {
                try {
					instance = new BerlinClockPropertyHandler();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return instance;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
