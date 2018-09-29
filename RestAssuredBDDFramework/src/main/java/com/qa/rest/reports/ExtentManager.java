package com.qa.rest.reports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	static ExtentReports extent;
    final static String filePath = "./test-output/extent/Extent.html";
    
    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(filePath, true);
        }
        
        return extent;
    }

}
