package ConfigReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropReader {

	private Properties prop;
	private FileInputStream fip;

	//public Properties initLangProp(String language) throws IOException {
	public Properties initLangProp() throws IOException {

		//mvn clean install -Dlang="french"
		String language = System.getProperty("lang");
		
		
		System.out.println("Language:-" + language);
		prop = new Properties();
		switch (language.toLowerCase()) {
		case "english":
			fip = new FileInputStream("./src/main/resources/lang.eng.properties");
			break;
		case "french":
			fip = new FileInputStream("./src/main/resources/lang.french.properties");
			break;	
		default:
			System.out.println("Language not found..." + language);
			break;
		}
		prop.load(fip);
		return prop;
	}

}
