package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
  
	private static Properties prop;
	 static {
		 try {
			 FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
		       prop = new Properties();
		       prop.load(fis);
		 
		 } catch (IOException e) {
			 System.out.println("Could not load config.properties");
		 }
	 } 
	 
	 public static String getProperty(String key) {
		 return prop.getProperty(key);
	 }
}