package testNG_Basics;

import java.io.FileInputStream;
import java.util.Properties;

public class config_Property_File {
	Properties prop;
	public config_Property_File(String path) throws Exception{
		prop = new Properties();
		FileInputStream fis =new FileInputStream(path);
		prop.load(fis);
	}
	
	public String getPropertyData(String eleName){
		String data=prop.getProperty(eleName);
		return data;
	}

}
