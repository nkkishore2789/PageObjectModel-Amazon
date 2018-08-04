package com.Amazon.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Amazon.ReadProperties.ReadTestDataproperty;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;



public class SeleniumUtils {
	
	
	public static WebDriver driver;
	ReadTestDataproperty readtestdata=PageFactory.initElements(driver, ReadTestDataproperty.class);
	public static By locator;
	public static JavascriptExecutor jse;
	public static WebDriverWait wait;
	
	public SeleniumUtils(WebDriver driver){
		this.driver=driver;
	}
	
	
	
	public static void gotourl(String url,WebDriver driver){
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public static void implicitwait(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
}
	
	
	public static void enterText(String element,String value,WebDriver driver) throws Exception{
		locator=ReadTestDataproperty.getelementlocator(element);
		driver.findElement(locator).sendKeys(value);
	}
	
	public static void Clickementbyid(String element) throws Exception{
		
		locator=ReadTestDataproperty.getelementlocator(element);
	    driver.findElement(locator).click();
		
	}
	
	public static void selectmethod(String element,String value,WebDriver driver) throws Exception{
		locator=ReadTestDataproperty.getelementlocator(element);
		System.out.println("locator for dropdown is: "+locator);
		Select select=new Select(driver.findElement(locator));
		select.selectByVisibleText(value);
	}
	
		public  static WebElement waitToElementDisplay(String element,WebDriver driver) throws Exception{
			
			locator=ReadTestDataproperty.getelementlocator(element);
			System.out.println("searchbutton :"+locator);
			wait=new WebDriverWait(driver,30);
			WebElement btn=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return btn;
		}
		
		public static void clickbtnbyJavascript(String element,WebDriver driver) throws Exception{
			
			System.out.println("Entering into JS:");
			locator=ReadTestDataproperty.getelementlocator(element);
			WebElement btn=driver.findElement(locator);
			jse=((JavascriptExecutor)driver);
			jse.executeScript("argument[0].click();", btn);
			
		}
	
		public static  String getText(String element,WebDriver driver) throws Exception{
			
			locator=ReadTestDataproperty.getelementlocator(element);
			String text=driver.findElement(locator).getText();
			return text;
			
			
			
		}
	
	
}
