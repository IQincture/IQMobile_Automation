package com.incture.proj.testNg;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.android.AndroidKeyCode;

public class LoginTest extends Config {
  @Test
  public void TestLogin() throws InterruptedException {
	  MobileElement username = (MobileElement) driver.findElement(By.id("com.cherrywork:id/username")); 
	  if (username.isDisplayed() & username.isEnabled()) {
			System.out.println("entered user name");
	  }
	  username.click();
	  username.sendKeys(("config.cherrywork.incture"));
	  MobileElement config = (MobileElement) driver.findElement(By.id("com.cherrywork:id/config_done"));
	  if (config.isDisplayed() & config.isEnabled()) {
		  System.out.println("Clicked on configuration button");
	  }
	  config.click();
	  Thread.sleep(3000);
	  MobileElement Email = (MobileElement) driver.findElement(By.id("com.cherrywork:id/username"));
	  if(Email.isDisplayed() & Email.isEnabled()) {
		  System.out.println("Email entered");
	  }
	  Email.sendKeys("deeksha.shetty@incture.com");
	  MobileElement Password = (MobileElement) driver.findElement(By.id("com.cherrywork:id/password"));
	  if (Password.isDisplayed() & Password.isEnabled()) {
		System.out.println("Password entered");
	  }
	  Password.sendKeys("cherry");
	  ((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
	  Thread.sleep(4000);
	  MobileElement loginbutton = (MobileElement) driver.findElement(By.id("com.cherrywork:id/login"));
	  if (loginbutton.isDisplayed() & loginbutton.isEnabled()) {
		System.out.println("login button clicked");
	  }
	  loginbutton.click();
	  MobileElement allowPermission = (MobileElement) driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
	  if(allowPermission.isDisplayed() && allowPermission.isEnabled()){
		  allowPermission.click();
	  }
  }
}
