package com.POMFlipkartProj2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class FAddtoCartPage extends FSearchPrdPage {
	
     
  @Test(priority=3)
  public void fAdd2Cart() throws InterruptedException, IOException {
	     Properties prop=new Properties();
		 FileInputStream f=new  FileInputStream("C:\\Users\\WELCOME\\eclipse-workspace\\FlipkartPlaceOrderProj\\src\\test\\java\\com\\POMFlipkartProj2\\loginconfig.properties");
	     prop.load(f);
	  ArrayList<String> w=new ArrayList<String>(x.getWindowHandles());
	  x.switchTo().window(w.get(1));
	  Thread.sleep(3000);
	  x.findElement(By.xpath(prop.getProperty("add2cart"))).click();
	  Thread.sleep(5000);
	/*  //perform mouseover operation on Myaccount 
	  WebElement myacc= x.findElement(By.xpath(prop.getProperty("Myaccount")));
	  Actions act=new Actions(x);
	  act.moveToElement(myacc).build().perform();
	 //to click on wishlist
	  Thread.sleep(2000);
	//  x.findElement(By.xpath(prop.getProperty("wishlist"))).click();
	  Thread.sleep(5000);*/
	  
	  //access cart
	 // WebElement Cartbutton= x.findElement(By.xpath(prop.getProperty("cart")));
	  //act.moveToElement(Cartbutton).build().perform();
	  
	  Boolean cartresult =x.findElement(By.xpath(prop.getProperty("cartinfo"))).isDisplayed();
	  Assert.assertTrue(cartresult);
	  Thread.sleep(2000);
	  System.out.println("Product added to cart");
  }
   @Test(priority=4)
   public void scrreenshot() throws IOException {
   TakesScreenshot scrShot =((TakesScreenshot)x);
	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	File DestFile=new File("C:\\Users\\WELCOME\\eclipse-workspace\\FlipkartPlaceOrderProj\\src\\test\\resources\\cartpage.jpg");
	FileUtils.copyFile(SrcFile, DestFile);
   }
   
}
