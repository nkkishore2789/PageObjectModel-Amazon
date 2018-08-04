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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Amazon.ReadProperties.ReadTestDataproperty;

public class WebBase {

	public  WebDriver driver;
	public WebElement element;
	public static String URL;
	
	public static String Browser;
	public static String BrowserType;
	
	
	private static String chromedriverpath="\\Driver\\ChromeDriver\\chromedriver.exe";
	private static String Firefoxdriverpath="\\Driver\\Firefox\\geckodriver.exe";
	private static String IEdriverpath="\\Driver\\InternetExplorer\\IEDriverServer.exe";
	
	 ReadTestDataproperty readtestdata=PageFactory.initElements(driver, ReadTestDataproperty.class);
	 
	 
	 
	 
	
	/**
	 * Set up the Brower and the Driver of the Broswer
	 */
	 
	 public  void BrowsersetUp(){
		 ReadTestDataproperty.setupParam();
		 
		 
		 Browser=ReadTestDataproperty.Browser;
		 BrowserType=ReadTestDataproperty.BrowserDriver;
		 
		 System.out.println("Browser from base class :"+Browser);
		 System.out.println("BrowserType; "+ BrowserType);
		 
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
		
		String ChromeDriver = BrowserType;
		System.setProperty(ChromeDriver, ReadTestDataproperty.TEST_ROOT_DIR+chromedriverpath);
		driver=new ChromeDriver();
		
	}
	
	public  void setupFirefoxDriver(){
		String FirefoxDriver = BrowserType;
		System.setProperty(FirefoxDriver, ReadTestDataproperty.TEST_ROOT_DIR+Firefoxdriverpath);
		driver=new ChromeDriver();
	}
	
	public  void setupIEDriver(){
		String IEDriver = BrowserType;
		System.setProperty(IEDriver, System.getProperty(ReadTestDataproperty.TEST_ROOT_DIR)+IEdriverpath);
		driver=new ChromeDriver();
	}
	
	protected void goToUrl(String url) {
		
		this.driver.get(url);
	}
	
	
	
}
