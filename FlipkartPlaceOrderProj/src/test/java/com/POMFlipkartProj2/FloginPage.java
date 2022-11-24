package com.POMFlipkartProj2;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FloginPage extends FSetupPage {
	
	  @Test (priority=1)
	  public void setup() throws InterruptedException, IOException {
	
	Thread.sleep(2000);
	 Properties prop=new Properties();
	 FileInputStream f=new  FileInputStream("C:\\Users\\WELCOME\\eclipse-workspace\\FlipkartPlaceOrderProj\\src\\test\\java\\com\\POMFlipkartProj2\\loginconfig.properties");
    prop.load(f);
    Thread.sleep(2000);
 
    Actions act= new Actions(x);
    Action action= act.sendKeys(prop.getProperty("mobileNo")).build();
    action.perform();
  
   Thread.sleep(4000);
    x.findElement(By.xpath(prop.getProperty("pasword"))).sendKeys(prop.getProperty("password"));
    Thread.sleep(2000);
    Action actio= act.sendKeys(Keys.ENTER).build();
      actio.perform();
   
    x.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    String w= x.getWindowHandle();
    x.switchTo().window(w);
    Thread.sleep(2000);
	     String s= x.findElement(By.xpath(prop.getProperty("Myaccount"))).getText();
	     Thread.sleep(4000);
	     System.out.println(s);
	    String expText="My Account";
	    System.out.println(expText);
	    Thread.sleep(4000);
	    if(s.contentEquals(expText))
	    {
	    	System.out.println("Login Successful");
	    }
	    else {
	    	System.out.println("Login Failed");
	    }
	     
	     Thread.sleep(2000);
	
	 
}
	  public WebDriver initialize() {
		return x;
		  
	  }
}

