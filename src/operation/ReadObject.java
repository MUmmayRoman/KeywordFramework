package operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadObject {       //This class for read Object.properties file.
	
Properties p = new Properties();
	
	public Properties getObjectRepository() throws IOException {
		
		// Read Object Repository File
		InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\objects\\object.properties"));
		
		// Load all Objects
		p.load(stream);
		return p;
		
	}

}
