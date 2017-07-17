package CustomizedLibs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author Administrator
 * this class is used for mapping data in the property file.
 */

public class PropertyUtility {
	
	private static Properties getProperty() throws IOException{
		Properties prop= new Properties();
		String fileName = System.getProperty("user.dir")+"/src/main/resources/config.properties";
		InputStream inputStr=new FileInputStream(fileName);
		prop.load(inputStr);
		return prop;
	}
	
	/**
	 * this function is used for getting the value GeckoDriverPath in the property file.
	 * @return
	 * @throws IOException
	 */
	public static String getGeckoDriverPath() throws IOException{
		Properties prop=PropertyUtility.getProperty();
		return System.getProperty("user.dir")+prop.getProperty("GeckoDriverPath");
	}
	
	
	/**
	 * this function is used for getting the value URLCreateAccount in the property file.
	 */
	public static String getUrlCreateAccount() throws IOException{
		Properties prop=PropertyUtility.getProperty();
		return prop.getProperty("URLCreateAccount");
	}
	
	/**
	 * this function is used for getting the value URLApplication in the property file.
	 * @return 
	 * @throws IOException
	 */
	public static String getUrlApplication() throws IOException{
		Properties prop=PropertyUtility.getProperty();
		return prop.getProperty("URLApplication");
	}
	
	
	/**
	 * this function is used for gettign the value user.dir in the property file
	 * @return
	 * @throws IOException
	 */
	public static String getDataFileNameWithPath() throws IOException{
		Properties prop=PropertyUtility.getProperty();
		return System.getProperty("user.dir")+prop.getProperty("DataFileName");
	}

}
