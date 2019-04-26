package Paytm_POM;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {
	 Properties prop;
	public PropertyFile(String path) throws Exception{
		prop = new Properties();
		FileInputStream fis =new FileInputStream(path);
		prop.load(fis);
	}
	
	public String getPropertyData(String eleName){
		String data=prop.getProperty(eleName);
		return data;
	}

}
