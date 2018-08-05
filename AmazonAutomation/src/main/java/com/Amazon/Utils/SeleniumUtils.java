package com.Amazon.Utils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Amazon.ReadProperties.ReadTestDataproperty;






public class SeleniumUtils {
	
	
	public  WebDriver driver;
	ReadTestDataproperty readtestdata=PageFactory.initElements(driver, ReadTestDataproperty.class);
	public static By locator;
	public static JavascriptExecutor jse;
	public static WebDriverWait wait;
	public static WebElement element,fluentelement;
	
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
	
	public  void Clickementbyid(String element) throws Exception{
		
		locator=ReadTestDataproperty.getelementlocator(element);
	    driver.findElement(locator).click();
		
	}
	
	public static void selectmethod(String element,String value,WebDriver driver) throws Exception{
		locator=ReadTestDataproperty.getelementlocator(element);
		Select select=new Select(driver.findElement(locator));
		select.selectByVisibleText(value);
	}
	
		@SuppressWarnings("deprecation")
		public  static WebElement waitToElementDisplay(String identifier,WebDriver driver) throws Exception{
			
			locator=ReadTestDataproperty.getelementlocator(identifier);
			
			
			Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
					.ignoring(RuntimeException.class)
					.withTimeout(20, TimeUnit.SECONDS)
					.pollingEvery(1, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);
			element=wait.until(new Function<WebDriver, WebElement>()
			{
				public WebElement apply(WebDriver driver){
					return fluentelement= driver.findElement(locator);
					
				}
			});
			
			return fluentelement;
			
			
		}
		
		public static void clickbtnbyJavascript(String element,WebDriver driver) throws Exception{
			
			
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
