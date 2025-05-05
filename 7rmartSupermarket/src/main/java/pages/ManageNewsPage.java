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
	
	@FindBy(xpath = "//p[normalize-space()='Manage News']")private WebElement news;
	@FindBy(xpath = " //a[@class='btn btn-rounded btn-danger']")private WebElement newbutton;
   @FindBy(xpath ="//textarea[@id='news']")private WebElement newnews;
   @FindBy(xpath = " //button[normalize-space()='Save']")private WebElement savebutton;
   
   
   
   public void clickOnManageNewsField()
   {
	   news.click();
   }
   
   public void clickonNewButtonField()
   {
	   newbutton.click();
   }
   
   public void clickOnNewfield(String news)
   {
	   newnews.sendKeys(news);
   }
   
   public void clickOnSaveButton() {
		  savebutton.click();
	  }
}
