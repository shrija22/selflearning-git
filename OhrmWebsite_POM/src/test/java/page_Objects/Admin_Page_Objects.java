package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Admin_Page_Objects {
	
	@FindBy(xpath="//span[text()='Admin']/..")
	public static WebElement admin;
	
	@FindBy(xpath="//span[contains(text(),'User Management ')]")
	public static WebElement usermgt;
	
	@FindBy (xpath="//a[text()='Users']")
	public static WebElement user;
	
	@FindBy(xpath="//i[contains(@class,'down-fill ')]//following::div[24]")
	public static WebElement userRole;
	
	@FindBy (xpath="//i[contains(@class,'down-fill ')]//following::div[40]")
	public static WebElement status;
	

}
