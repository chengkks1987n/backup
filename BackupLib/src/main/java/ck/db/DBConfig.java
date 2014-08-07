package ck.db;

import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

/**
   @brief get the database connect configurations in the properties file.
   @author ck &lt chengkechengke@gmail.com &gt
   @version 2014-08-07 
*/
public class DBConfig {
	
    private static final String configFile = "database_config.properties"; //!< configuration file name
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
	
    /**
       get the database driver name
    */
    public static String getDriver(){
	return config.getProperty("driver");			
    }
	
    /**
       get the database connection URL string.
    */
    public static String getURL(){
	return config.getProperty("url");			
    }
	
    /**
       get the user name of the database
    */
    public static String getUsername(){
	return config.getProperty("username");			
    }
	
    /**
       get the password of the database
    */
    public static String getPassword(){
	return config.getProperty("password");			
    }	
	
}
