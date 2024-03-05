package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil
{
	public String getDataFromPropertyFile(String key) throws IOException
	{
		//Step 1 : Create the object of FileInputStream class & in FileInputStream constructor enter the location of external file.
		FileInputStream fis = new FileInputStream("src\\test\\resources\\localhost.properties");
		
		//Step 2 : Create Object of Properties class.
		Properties p = new Properties();
		
		//Step 3 : Call load (inputstream) to fetch the location of external file
		p.load(fis);
		
		//Step 4 : Call getproperty (String key) to fetch the keys.
		String value = p.getProperty(key);
		return value;
		
	}
}
