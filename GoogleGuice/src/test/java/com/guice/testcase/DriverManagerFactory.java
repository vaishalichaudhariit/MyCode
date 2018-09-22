/**
 * 
 */
package com.guice.testcase;

import com.guice.googleTest.ChromeDriverManager;
import com.guice.googleTest.DriverManager;

/**
 * @author Vaishali.Chaudhari
 *
 */
public class DriverManagerFactory {
	
	public enum DriverType {
	    CHROME,
	    FIREFOX,
	    IE,
	    SAFARI;
	}
	public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
        /*    case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;*/
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;

    }
}
