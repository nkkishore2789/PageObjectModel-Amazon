package com.Amazon.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Amazon.ReadProperties.ReadTestDataproperty;
import com.Amazon.ReadProperties.ReadlocatorProperties;
import com.Amazon.Utils.SeleniumUtils;

/****
 * 
 * This is page class which contains the page objects
 * extends the utils class to perform basic operation
 * 
 * 
 * @author kishore
 *
 */

public class Amazonhomepage extends SeleniumUtils {
	
	public Amazonhomepage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}

public static WebDriver driver;
public  WebDriverWait wait;
public static WebElement element;
	
	ReadlocatorProperties readlocator=PageFactory.initElements(driver, ReadlocatorProperties.class);
	ReadTestDataproperty readtestdata=PageFactory.initElements(driver, ReadTestDataproperty.class);
	SeleniumUtils sutils=PageFactory.initElements(driver, SeleniumUtils.class);
	
	private static String dropdown=ReadlocatorProperties.getValue("Dropdownselect");
	private static String searchbox=ReadlocatorProperties.getValue("searchbox");
	private static String searchbutton=ReadlocatorProperties.getValue("searchbutton");
	private static String BootTitle=ReadlocatorProperties.getValue("BootTitle");
	private static String BooktypePaperback=ReadlocatorProperties.getValue("BooktypePaperback");
	private static String PaperbackPrize=ReadlocatorProperties.getValue("PaperbackPrize");
	private static String BooktypeHardcover=ReadlocatorProperties.getValue("BooktypeHardcover");
	private static String HardcoverPrize=ReadlocatorProperties.getValue("HardcoverPrize");
	private static String amazonurl=ReadTestDataproperty.Amazonurl;
	private static String SearchKeyword=ReadTestDataproperty.SearchKeyword;
	private static String dropdownselector=ReadTestDataproperty.dropdownselector;
	
	
	
	public static void launchurl(String url){
		
		gotourl(url,driver);
}
	
	public  void selectvalueasBook() throws Exception{
		
		System.out.println("dropdown value is "+dropdown);
		System.out.println("dropdownselector: "+dropdownselector);
		
		
		selectmethod(dropdown,dropdownselector,driver);
		
}
	
	
	public static void enterSearchKeyword() throws Exception{
		
		enterText(searchbox,SearchKeyword,driver);
		
		
	}
	
	public static void clickOnbutton() throws Exception{
		
		WebElement search=waitToElementDisplay(searchbutton,driver);
		
		if(search.isDisplayed()){
			
			search.click();
		
		}
		
	}
	
	public static void getBooktitle() throws Exception{
		
		String Booktitle=getText(BootTitle, driver);
		System.out.println("Booktitle: "+Booktitle);
	}
	
	public static void getBooktype() throws Exception{
		String Paperback=getText(BooktypePaperback, driver);
		System.out.println("BookType: "+Paperback);
	}
	
	public static void getBookHardcopy() throws Exception{
		String Hardcover=getText(BooktypeHardcover, driver);
		System.out.println("BookType: "+Hardcover);
	}
	
	public static void getPaperbackprize() throws Exception{
		String Paperbackprize=getText(PaperbackPrize, driver);
		System.out.println("Paperbackprize: "+Paperbackprize);
	}
	public static void getHardcoverprize() throws Exception{
		String HardcoverP=getText(HardcoverPrize, driver);
		System.out.println("HardcoverPrize: "+HardcoverP);
	}
}
