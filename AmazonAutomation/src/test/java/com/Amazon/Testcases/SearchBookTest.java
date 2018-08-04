package com.Amazon.Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Amazon.Pages.Amazonhomepage;
import com.Amazon.ReadProperties.ReadTestDataproperty;

import com.Amazon.WebBase.WebBase;

public class SearchBookTest extends WebBase {
	
	

//	Amazonhomepage amazonhomepage=PageFactory.initElements(driver, Amazonhomepage.class);
	Amazonhomepage amazonhomepage;
	
	ReadTestDataproperty readtestdata=PageFactory.initElements(driver, ReadTestDataproperty.class);
	
	
	
	@BeforeMethod
	public void browsersetup(){
		BrowsersetUp();
		//amazonhomepage= new Amazonhomepage(driver);
		amazonhomepage=PageFactory.initElements(driver, Amazonhomepage.class);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void searchgivenbookTest() throws Exception{
		
		amazonhomepage.launchurl(URL);
		amazonhomepage.selectvalueasBook();
		amazonhomepage.enterSearchKeyword();
		amazonhomepage.clickOnbutton();
		amazonhomepage.getBooktitle();
		amazonhomepage.getBooktitle();
		amazonhomepage.getBookHardcopy();
		amazonhomepage.getPaperbackprize();
		amazonhomepage.getHardcoverprize();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
		
	}

}
