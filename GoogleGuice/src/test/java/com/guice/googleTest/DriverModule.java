/**
 * 
 */
package com.guice.googleTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.name.Names;


/**
 * @author Vaishali.Chaudhari
 *
 */
public class DriverModule extends com.google.inject.AbstractModule {

	@Override
    protected void configure() {

        //DriverManager config
        bind(DriverManager.class)
            .to(ChromeDriverManager.class)
            .in(Scopes.SINGLETON);

        //My test input properties
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("D:\\SeleniumWorkspace\\GoogleGuice\\src\\test\\java\\com\\guice\\googleTest\\config.properties"));
            Names.bindProperties(binder(), props);
        } catch (IOException e) {
            //skip
        }

    }

    @Provides
    public WebDriver getDriver(DriverManager driverManager) {
        return driverManager.getDriver();
    }

    @Provides
    public Actions getActions(WebDriver driver) {
        return new Actions(driver);
    }

    @Provides
    public JavascriptExecutor getExecutor(WebDriver driver) {
        return (JavascriptExecutor)(driver);
    }
}
