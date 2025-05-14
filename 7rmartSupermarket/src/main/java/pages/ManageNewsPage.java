package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = " //a[@class='btn btn-rounded btn-danger']")private WebElement newbutton;
   @FindBy(xpath ="//textarea[@id='news']")private WebElement newnews;
   @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")private WebElement SuccessMessage;
   @FindBy(xpath = " //button[normalize-space()='Save']")private WebElement savebutton;
   
   
   
   public ManageNewsPage clickonNewButtonField()
   {
	   newbutton.click();
	   return this;
   }
   
   public ManageNewsPage clickOnNewfield(String news)
   {
	   newnews.sendKeys(news);
	   return this;
   }
   
   public ManageNewsPage clickOnSaveButton() {
		  savebutton.click();
		  return this;
		  
	  }
   
   public boolean successAlertDisplayed() {
	   
		return SuccessMessage.isDisplayed();
	}
}
