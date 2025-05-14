package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageSubCategoryPage {
	
public WebDriver driver;
	
	public ManageSubCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//p[contains(text(),'Sub Category')])[1]")private WebElement categorymenu;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']//i[@class='fas fa-arrow-circle-right']")private WebElement more;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")private WebElement newbutton;
	@FindBy(id="cat_id")private WebElement cat;
	@FindBy(xpath = "//label[normalize-space()='Sub Category']")private WebElement sub;
	@FindBy(xpath = "//button[normalize-space()='Save']")private WebElement savebutton;
	
	
	
	
	public void clickonSubCategoryMenu()
	{
		categorymenu.click();
	}
	public void clickOnMoreInfoField()
	{
		more.click();
	}
	
	public void clickOnNewButton()
	{
		newbutton.click();
	}
	
	public void clickOnCategoryDropdown()
	{
		 Select select= new Select(cat);
		  select.selectByVisibleText("Vegetables");
	}
	
	public void clickOnSubCategoryField()
	{
		sub.click();
	}
	public void clickonsaveButton()
	{
		savebutton.click();
	}
	
}
