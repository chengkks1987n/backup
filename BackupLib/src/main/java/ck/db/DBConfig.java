package ck.db;

import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

public class DBConfig {
	
    private static final String configFile = "database_config.properties";
    private static Properties config = new Properties();	
		
    static {
	String path;
	try {
	    InputStream ins = Object.class.getResourceAsStream("/" + configFile);
	    config.load(ins);		    
	} catch (Exception e) {
	    System.out.println("cannot load database configuration file!");
	    e.printStackTrace();
	}			
    }
	
    public static String getDriver(){
	return config.getProperty("driver");			
    }
	
    public static String getURL(){
	return config.getProperty("url");			
    }
	
    public static String getUsername(){
	return config.getProperty("username");			
    }
	
    public static String getPassword(){
	return config.getProperty("password");			
    }	
	
}
