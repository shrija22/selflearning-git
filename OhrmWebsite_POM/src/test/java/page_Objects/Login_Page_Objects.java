package page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page_Objects {

	@FindBy(name="username")
	public static WebElement uname;
	
	@FindBy(name="password")
	public static WebElement pwd;
	
	@FindBy(xpath="//button[text()=' Login ']")
	public static WebElement login;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
