package com.POMFlipkartProj2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FSearchPrdPage extends FloginPage{
	
  @Test (priority=2)
  public void fsearch() throws InterruptedException, IOException, AWTException {
	  //defining parameters to access configuration file
	  Properties prop=new Properties();
		 FileInputStream f=new  FileInputStream("C:\\Users\\WELCOME\\eclipse-workspace\\FlipkartPlaceOrderProj\\src\\test\\java\\com\\POMFlipkartProj2\\loginconfig.properties");
	    prop.load(f);
	  
	  x.findElement(By.xpath(prop.getProperty("searchProduct"))).sendKeys(prop.getProperty("Productname"));
	  Thread.sleep(2000);
	  x.findElement(By.xpath(prop.getProperty("searchbutton"))).click();
	  Thread.sleep(5000);
	 // x.findElement(By.xpath(prop.getProperty("sortby"))).click();
	  //Thread.sleep(5000); 
	  
	
	  List<WebElement> search= x.findElements(By.xpath(prop.getProperty("search64GBDetails")));
	  Thread.sleep(2000);
	  String s="APPLE iPhone 12 (Blue, 64 GB)";
	  //Loop to print phone Details having 64GB RAM and Selecting the desired model
	  for(int i=0;i<search.size();i++) {
	  System.out.println(search.get(i).getText());
	  System.out.println("########################");
	  if(s.contains(search.get(i).getText())){
		 
		  search.get(i).click();
		
		  }
	  }
	
  }
}
