package com.POMFlipkartProj2;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;

/*Problem Statement 2:
• Do login and validate if Login is successful.
• Search for ‘iPhone 12’ and select a 64GB phone on product details page after
selecting the phone from product listing page.
• Add the product to cart and validate if the product added and available in Cart.
• Add a new address for shipping and proceed to checkout page then validate it.
• Same test to be repeated on Chrome browser (assuming you’re using Firefox as
default browser else vice-versa).
• Any actions in any page are welcome (like sorting the products in product listing
page, page header assertions in each page to validate if on right page, etc). */

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FSetupPage {
	WebDriver x;
	 @BeforeTest
	  public void flipkart_setup(ITestContext testcontext) throws InterruptedException {
		 String browser=testcontext.getCurrentXmlTest().getParameter("browser");
		 if(browser.equals("chrome"))
		 {
		 
		 
		  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		  x= new ChromeDriver();
		  Thread.sleep(5000);
		  x.manage().window().maximize();
		  Thread.sleep(3000);
		  x.manage().deleteAllCookies();
		  //access flipkart page
	       x.get("https://www.flipkart.com/");
		  Thread.sleep(2000);
		  //get title for verification
		  String p=x.getTitle();
		  Thread.sleep(2000);
		  System.out.println(p);
		
		  Thread.sleep(4000);
		 }
		 else if(browser.equals("ff")) {
			 System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
			  x= new FirefoxDriver();
			  Thread.sleep(5000);
			  x.manage().window().maximize();
			  Thread.sleep(3000);
			  x.manage().deleteAllCookies();
			  //access flipkart page
		       x.get("https://www.flipkart.com/");
			  Thread.sleep(2000);
			  //get title for verification
			  String p=x.getTitle();
			  Thread.sleep(2000);
			  System.out.println(p); 
		 }
	  }
	
	
	     	  
	 @AfterTest
	 public void tearDown() throws InterruptedException {
		 Thread.sleep(2000);
		 x.quit();
		 
	 }
}
