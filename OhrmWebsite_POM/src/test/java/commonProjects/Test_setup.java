package commonProjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test_setup {
	
	static Properties prop=null;
	WebDriver driver=null;
	public Properties loadpropertyfile() throws IOException {
		FileInputStream file= new FileInputStream("config.properties");
	    prop= new Properties();
		prop.load(file);
		
		return prop;
	}
	
  @SuppressWarnings("deprecation")
@BeforeSuite
  public void launchbrowser() throws IOException {
	  loadpropertyfile();
	  String browser = prop.getProperty("browser");
	  String url=prop.getProperty("url");
	  String driverLocation=prop.getProperty("DriverLocation");
	  if (browser.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver",driverLocation);
		  driver=new ChromeDriver();
	  }
	  else if(browser.equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver", driverLocation);
		  driver=new FirefoxDriver();
	  }
	  driver.manage().window().maximize();
	  driver.get(url);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
  }
  
  @AfterSuite
  public void tearDown() {
	  
  }
}
