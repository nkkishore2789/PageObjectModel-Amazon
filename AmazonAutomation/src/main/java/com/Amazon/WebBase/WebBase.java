package com.Amazon.WebBase;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Amazon.ReadProperties.ReadTestDataproperty;



/********
 * Web Base class,this class get initiated for all test execution
 * @author kishore
 *
 */




public class WebBase {

	public  WebDriver driver;
	public WebElement element;
	public static String URL;
	public static String Browser;
	
	ReadTestDataproperty readtestdata=PageFactory.initElements(driver, ReadTestDataproperty.class);
 
	 public  void BrowsersetUp(){
		 ReadTestDataproperty.setupParam();
		  Browser=ReadTestDataproperty.Browser;
		 
		if(Browser !=null && !(Browser.equalsIgnoreCase(""))){
			 
			 if(Browser.equalsIgnoreCase("chrome")){
				 
				 setupChromeDriver();
			 }
			 
			 if(Browser.equalsIgnoreCase("Firefox")){
				 setupFirefoxDriver();
			 }
			 
			 if(Browser.equalsIgnoreCase("IE")){
				 setupIEDriver();
			 }
		 }
		 
		URL=readtestdata.Amazonurl;
	      System.out.println("Browser setup: "+URL);
}
	 
	 
	public  void setupChromeDriver(){
		
		
		System.setProperty(ReadTestDataproperty.BrowserDriver, ReadTestDataproperty.TEST_ROOT_DIR+ReadTestDataproperty.driverpath);
		driver=new ChromeDriver();
		
	}
	
	public  void setupFirefoxDriver(){
		
		System.setProperty(ReadTestDataproperty.BrowserDriver, ReadTestDataproperty.TEST_ROOT_DIR+ReadTestDataproperty.driverpath);
		
		ProfilesIni profile=new ProfilesIni();
		FirefoxProfile firefoxProfile = profile.getProfile(ReadTestDataproperty.firefoxprofile);
		
		firefoxProfile.setAcceptUntrustedCertificates(true);
		firefoxProfile.setAssumeUntrustedCertificateIssuer(true);
		firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
	    firefoxProfile.setPreference("browser.download.manager.closeWhenDone", true);
	    firefoxProfile.setAcceptUntrustedCertificates(true);
	    firefoxProfile.setAssumeUntrustedCertificateIssuer(true);
		
		
		
		driver=new FirefoxDriver();
	}
	
	public  void setupIEDriver(){
		
		
		System.setProperty(ReadTestDataproperty.BrowserDriver, System.getProperty(ReadTestDataproperty.TEST_ROOT_DIR)+ReadTestDataproperty.driverpath);
		driver=new ChromeDriver();
	}
	
	protected void goToUrl(String url) {
		
		this.driver.get(url);
	}
	
	
	
}
