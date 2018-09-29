/**
 * 
 */
package JSON;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author Vaishali.Chaudhari purpose: define static variables
 */
public class TestUtil {

		
	public static String getJSONinString(){
		
		JSONParser parser = new JSONParser();
		String responseString = null;
		try{
			Object obj = parser.parse(new FileReader("D:\\SeleniumWorkspace\\POMAutoFramework\\src\\main\\java\\com\\pom\\qa\\testdata\\NewReq.json"));
			JSONObject jsonObject = (JSONObject)obj;
			System.out.println(jsonObject.toJSONString());
			responseString = jsonObject.toJSONString();

		}
		catch(Exception e){e.printStackTrace();}
		return responseString;
	}


}
