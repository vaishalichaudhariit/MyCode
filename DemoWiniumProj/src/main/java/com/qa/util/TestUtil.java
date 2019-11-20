package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {

	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		return dateFormat.format(date);
	}

	public String takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) winiumDriver).getScreenshotAs(OutputType.FILE);
		String strPath = FileUtils.readFileToString(scrFile, "UTF-8");
		String currentDir = "C:\\Users\\Admin\\git\\MyCode\\Winium\\DemoWiniumProj";
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		return strPath;
	}

}
