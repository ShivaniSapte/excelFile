/**
 * 
 */
package naukriProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author shivani
 *
 */
public class Function_PropertyFile 
{
	Properties prop;
	public Function_PropertyFile(String path) throws IOException
	{
		prop=new Properties();
		FileInputStream f=new FileInputStream(path);
		prop.load(f);
		
	}

	public String getData(String element)
	{
		String data=prop.getProperty(element);
		return data;
	}
}
