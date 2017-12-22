package com.incture.proj.testNg;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.incture.utility.Constants;
import com.incture.utility.browser.MultipleBrowser;
import com.incture.utility.reports.Report;

public class Config {
	public static WebDriver driver;
	public Report report;
	public int i=0;
	@BeforeTest
	public void setUp() throws Exception{

		driver = new MultipleBrowser().getBrowserDriver("android");
		//driver.get(Constants.URL);
	}

	@AfterTest
	public void tearDown() throws InterruptedException{
		/*Thread.sleep(5000);
	    if (driver != null) {
	        driver.close();
	    }*/
	}
}
