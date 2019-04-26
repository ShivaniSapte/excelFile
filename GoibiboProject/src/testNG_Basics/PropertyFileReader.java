package testNG_Basics;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {
	Properties prop;
	public PropertyFileReader(String filePath) throws Exception{
		FileInputStream fis=new FileInputStream(filePath);
		prop=new Properties();
		prop.load(fis);
		
	}
	public String getData(String elementName){
		String data=prop.getProperty(elementName);
		return data;
	}

}
