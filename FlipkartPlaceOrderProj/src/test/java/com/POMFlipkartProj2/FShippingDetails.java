package com.POMFlipkartProj2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FShippingDetails extends FAddtoCartPage{
  @Test(priority=5)
  public void fplaceOrder() throws IOException, InterruptedException {
	  
	  Properties prop=new Properties();
		 FileInputStream f=new  FileInputStream("C:\\Users\\WELCOME\\eclipse-workspace\\FlipkartPlaceOrderProj\\src\\test\\java\\com\\POMFlipkartProj2\\loginconfig.properties");
	     prop.load(f);
	  
	  x.findElement(By.xpath(prop.getProperty("placeOrder"))).click();
	  Thread.sleep(6000);
  }
	 @Test(dataProvider="FShip_Data") 
	 public void fshipDetails(String name,String pcode,String phno,String locality, String address,String City,String state) throws IOException, InterruptedException
	 
	 {
		 Properties prop=new Properties();
		 FileInputStream f=new  FileInputStream("C:\\Users\\WELCOME\\eclipse-workspace\\FlipkartPlaceOrderProj\\src\\test\\java\\com\\POMFlipkartProj2\\loginconfig.properties");
	     prop.load(f);
	     x.switchTo().alert().wait(25000);
	  
		 x.findElement(By.name(prop.getProperty("Name"))).sendKeys(name);
		 
		 System.out.println(name);
		 Thread.sleep(3000);
		 x.findElement(By.xpath(prop.getProperty("phno"))).sendKeys(phno);
		 System.out.println(phno);
		 Thread.sleep(3000);
		 x.findElement(By.xpath(prop.getProperty("pincode"))).sendKeys(pcode);
		 Thread.sleep(3000);
		 System.out.println(pcode);
		 x.findElement(By.xpath(prop.getProperty("locality"))).sendKeys(locality);
		 Thread.sleep(3000);
		 System.out.println(locality);
		 x.findElement(By.xpath(prop.getProperty("address"))).sendKeys(address);
		 Thread.sleep(3000);
		 System.out.println(address);
		 x.findElement(By.xpath(prop.getProperty("city"))).sendKeys(City);
		 Thread.sleep(3000);
		 System.out.println(City);
		 x.findElement(By.xpath(prop.getProperty("State"))).sendKeys(state);
		 Thread.sleep(3000);
		 System.out.println(state);
	 }
	 
  @DataProvider (name="FShip_Data")
  public String[][] FExcelData() throws BiffException, IOException{
	  File f=new File("C:\\Users\\WELCOME\\eclipse-workspace\\FlipkartPlaceOrderProj\\src\\test\\resources\\FlipkartShippingAddress.xls");
	  Workbook w= Workbook.getWorkbook(f);
	  Sheet s= w.getSheet(0);
	  
	  int rows= s.getRows();
	  int cols=s.getColumns();
	  
	  System.out.println("rows= "+rows+" column= "+cols);
	  String inpd[][]=new String[rows-1][cols];
	  int count=0;
	  for(int i=1;i<rows;i++)
	  {
		  for(int j=0;j<cols;j++)
		  {
			  Cell c=s.getCell(j, i);
			  System.out.println(s.getCell(j, i));
			  inpd[count][j]= c.getContents();
		  }
		  count++;
	  }
	return inpd;
  }
}
