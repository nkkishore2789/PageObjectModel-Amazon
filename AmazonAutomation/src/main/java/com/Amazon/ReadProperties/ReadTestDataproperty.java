package com.Amazon.ReadProperties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

/******
 * @author kishore
 * This class is to read properties of Test data for Test execution
 *
 */

public class ReadTestDataproperty {
	
	private static final String PROP_FILE="Testdata.properties";
	public static  String Browser;
	public static  String BrowserDriver=null;
	public static String SearchKeyword=null;
	public static String dropdownselector=null;
	public static String Amazonurl=null;
	public static String driverpath=null;
	public static String firefoxprofile=null;
	public static  String TEST_ROOT_DIR;
	static FileInputStream fis=null;
	
	private static Properties prop=new Properties();

 public static void setupParam()  {
	
	    TEST_ROOT_DIR = System.getProperty("user.dir");
		try{
			System.out.println("from setupParam ");
			fis=new FileInputStream(TEST_ROOT_DIR+File.separator+PROP_FILE);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			
	}
	
		try{
			prop.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
		//Load Browser
		
		if(prop.getProperty("Chromebrowser")!=null && !(prop.getProperty("Chromebrowser").equalsIgnoreCase(""))){
			
			Browser=prop.getProperty("Chromebrowser");
			System.out.println("from setupParam"+Browser);
		}
          if(prop.getProperty("FirefoxBroser")!=null && !(prop.getProperty("FirefoxBroser").equalsIgnoreCase(""))){
			
			Browser=prop.getProperty("FirefoxBroser");
			
		}
          if(prop.getProperty("IEBrowser")!=null && !(prop.getProperty("IEBrowser").equalsIgnoreCase(""))){
  			
  			Browser=prop.getProperty("IEBrowser");
  			
  		}else
  			System.out.println("Invalid Browser: "+Browser);
          
          //Load BrowserDrivers
          if(prop.getProperty("chromedriver")!=null && !(prop.getProperty("chromedriver").equalsIgnoreCase(""))){
  			
        	  BrowserDriver=prop.getProperty("chromedriver");
  			
  		}
            if(prop.getProperty("firefoxDriver")!=null && !(prop.getProperty("firefoxDriver").equalsIgnoreCase(""))){
  			
            	BrowserDriver=prop.getProperty("firefoxDriver");
  			
  		}
            if(prop.getProperty("IEDriver")!=null && !(prop.getProperty("IEDriver").equalsIgnoreCase(""))){
    			
            	BrowserDriver=prop.getProperty("IEDriver");
    			
    		}
            else
            	System.out.println("Invalid driver: "+BrowserDriver);
            
            
            //Load BrowserDriverpath
            if(prop.getProperty("chromedriverpath")!=null && !(prop.getProperty("chromedriverpath").equalsIgnoreCase(""))){
      			
            	driverpath=prop.getProperty("chromedriverpath");
    			
    		}
              if(prop.getProperty("firefoxdriverpath")!=null && !(prop.getProperty("firefoxdriverpath").equalsIgnoreCase(""))){
    			
            	  driverpath=prop.getProperty("firefoxdriverpath");
    			
    		}
              if(prop.getProperty("IEDriverpath")!=null && !(prop.getProperty("IEDriverpath").equalsIgnoreCase(""))){
      			
            	  driverpath=prop.getProperty("IEDriverpath");
      			
      		}
              else
            	  System.out.println("Invalid Driver Path: "+driverpath);
        //Load SearchKeyword
          
          if(prop.getProperty("searchkeyword")!=null && !(prop.getProperty("searchkeyword").equalsIgnoreCase(""))){
    			
    			SearchKeyword=prop.getProperty("searchkeyword");
    			
    		}
	
	     //Dropdown Selector

          if(prop.getProperty("dropdownselector")!=null && !(prop.getProperty("dropdownselector").equalsIgnoreCase(""))){
    			
        	  dropdownselector=prop.getProperty("dropdownselector");
    	}
        //Get Url 
          if(prop.getProperty("Amazonurl")!=null && !(prop.getProperty("Amazonurl").equalsIgnoreCase(""))){
  			
        	  Amazonurl=prop.getProperty("Amazonurl");
        	  
        	  System.out.println("Amazonurl setup:"+Amazonurl);
    	}
          if(prop.getProperty("firefoxprofile")!=null && !(prop.getProperty("firefoxprofile").equalsIgnoreCase(""))){
    			
        	  firefoxprofile=prop.getProperty("firefoxprofile");
        	  
          }  
          
	
	}
 
 public  static String getTestdata(String element){
	 String locator=prop.getProperty(element);
	 System.out.println("locator from ReadTestDataproperty "+ locator);
	 
	
	 return locator;
	
}
 
 
 public static By getelementlocator(String propKey) throws Exception{
	 
	   System.out.println("propKey :"+propKey);
		String[] split = propKey.split(";");
		String type = split[0];

		// generate the By selector based on the type
		if (type.equalsIgnoreCase("id")) {
			return By.id(split[1]);
		} else if (type.equalsIgnoreCase("css")) {
			return By.cssSelector(split[1]);
		} else if (type.equalsIgnoreCase("tagname")) {
			return By.tagName(split[1]);
		} else if (type.equalsIgnoreCase("classname")
				|| type.equalsIgnoreCase("class")) {
			return By.className(split[1]);
		} else if (type.equalsIgnoreCase("name")) {
			return By.name(split[1]);
		} else if (type.equalsIgnoreCase("xpath")) {
			return By.xpath(split[1]);
		} else if (type.equalsIgnoreCase("link")) {
			return By.linkText(split[1]);
		} else {
			throw new Exception("Invalid element locator parameter -"
					+ propKey);
		}
	
	 
 }
}