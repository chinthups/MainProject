package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")private WebElement usernamefield;
	@FindBy(name="password")private WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign In']") private WebElement loginButton;
	@FindBy(xpath="//p[text()='Dashboard']")private WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']")private WebElement pagetitle;
	@FindBy(xpath="//div[@class=\"alert alert-danger alert-dismissible\"]") private WebElement alert;




	public LoginPage enterUsernameOnUserNameField(String username) {
		usernamefield.sendKeys(username);
		return this;
		
	}

	public LoginPage enterPasswordOnPasswordField(String password) {
		passwordfield.sendKeys(password);
		return this;
	}

	public HomePage clickONLoginButon() {
		loginButton.click();
		return new HomePage(driver);
	}
    public boolean dashboardDisplayed()
    {
    	return dashboard.isDisplayed();
    }
   public String getpagetitle()
   {
	 return  pagetitle.getText();
   }
   public boolean invalidUserAlert() {
		return alert.isDisplayed();
	}
}
