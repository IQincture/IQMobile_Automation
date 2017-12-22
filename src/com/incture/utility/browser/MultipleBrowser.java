package com.incture.utility.browser;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.incture.proj.suite.parameters.XmlParameters;
import com.incture.utility.Constants;
import com.incture.utility.excel.Excel;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MultipleBrowser {

	DesiredCapabilities capability = null;
	WebDriver driver = null;

	public WebDriver getBrowserDriver(String browser) throws Exception {

		if(Constants.isRemote.equalsIgnoreCase("No"))
		{

			switch (browser.toLowerCase()) {

			case "firefox":				
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				break;
			
			case "ie10":
				System.setProperty("webdriver.ie.driver",Constants.IEDriverServerExe);
				capability = DesiredCapabilities.internetExplorer();
				capability.setCapability("nativeEvents", false);
				driver = new InternetExplorerDriver(capability);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				break;
			
			case "ie11":
				System.setProperty("webdriver.ie.driver",Constants.IEDriverServerExe);
				capability = DesiredCapabilities.internetExplorer();
				capability.setCapability("nativeEvents", false);
				driver = new InternetExplorerDriver(capability);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
				break;
			
			case "chrome":
				System.setProperty("webdriver.chrome.driver",Constants.chromeDriverExe);
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				break;
			
			case "android":
				Excel ex = new Excel();
				/*Runtime.getRuntime().exec("adb shell input keyevent KEYCODE_POWER");
				Thread.sleep(1000);
				Runtime.getRuntime().exec("adb shell input swipe 800 400 400 400");
				Thread.sleep(2000);*/
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("deviceName", ex.xlReadCell(Constants.ExcelPath, "ParametersForAndroid", "Device Name", 1));
				capabilities.setCapability("platformName", ex.xlReadCell(Constants.ExcelPath, "ParametersForAndroid", "Platform Name", 1));
				capabilities.setCapability("platformVersion", ex.xlReadCell(Constants.ExcelPath, "ParametersForAndroid", "Platform Version", 1));
				capabilities.setCapability("unlockType", ex.xlReadCell(Constants.ExcelPath, "ParametersForAndroid", "Unlock Type", 1));
				capabilities.setCapability("unlockKey", ex.xlReadCell(Constants.ExcelPath, "ParametersForAndroid", "Unlock Key", 1));
				capabilities.setCapability("appactivity", ex.xlReadCell(Constants.ExcelPath, "ParametersForAndroid", "App Activity", 1));
				capabilities.setCapability("apppackage", ex.xlReadCell(Constants.ExcelPath, "ParametersForAndroid", "App Package", 1));
				capabilities.setCapability(MobileCapabilityType.FULL_RESET, true); 
				File file = new File(ex.xlReadCell(Constants.ExcelPath, "ParametersForAndroid", "Apk File Location", 1));
				capabilities.setCapability("app", file.getAbsolutePath());
				driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
				Thread.sleep(4000);
				break;
			
			case "ios":
				break;
			
			case "ios-ipad":
				break;
			
			default:
				driver = null;


			}

		}else if(Constants.isRemote.equalsIgnoreCase("Yes")) {
			String url="http://"+XmlParameters.nodeIp+":"+XmlParameters.port+"/wd/hub";

			switch (browser.toLowerCase()) {

			case "firefox":	
				capability=DesiredCapabilities.firefox();
				capability.setBrowserName("firefox");
				capability.setPlatform(Platform.WIN10);	
				try {
					driver = new RemoteWebDriver(new URL(url), capability);
				} catch (MalformedURLException e) {System.out.println(e.getMessage());}
				break;

			case "chrome":
				capability=DesiredCapabilities.chrome();
				capability.setBrowserName("chrome");
				capability.setPlatform(Platform.WIN10);
				//capability.setCapability("screen-resolution", "1280x800");
				try {
					driver = new RemoteWebDriver(new URL(url), capability);
				} catch (MalformedURLException e) {System.out.println(e.getMessage());}
				break;
			case "ie10":
				break;
			case "android":
				break;
			case "ios":
				break;
			case "ios-ipad":
				break;
			default:
				driver=null;

			}
			
		}


		return driver;

	}
}
