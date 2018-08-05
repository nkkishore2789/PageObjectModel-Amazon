package com.Amazon.ReadProperties;

import java.io.File;

/***
 * This class is to read property of web elements
 * 
 * 
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadlocatorProperties {
	private static final String WebPROP_FILE="WebElements.properties";
	public static  String TEST_ROOT_DIR;
	private static Properties prop=new Properties();
	
	public static FileInputStream webprop=null;
	
	 static{
		try{
			TEST_ROOT_DIR = System.getProperty("user.dir");
		webprop=new FileInputStream(TEST_ROOT_DIR+File.separator+WebPROP_FILE);
		prop.load(webprop);
		webprop.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//ReadlocatorProperties.getValue();
	
}
	

 public  static String getValue(String element){
	 String locator=prop.getProperty(element);
	// System.out.println("locator"+ locator);
	 
	
	 return locator;
	
}
}