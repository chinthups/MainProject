package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageProductPage {
	
public WebDriver driver;
	
	public ManageProductPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	  @FindBy(xpath ="//p[contains(text(),'Manage Product']" )private WebElement manage;
	  @FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newbutton;
	  @FindBy(xpath =" //label[normalize-space()='Title']" )private WebElement title;
	  @FindBy(xpath = "//label[normalize-space()='Product Type']")private WebElement product;
	  @FindBy(xpath ="//input[@value='Veg']" )private WebElement radio;
	  @FindBy(xpath =" //label[normalize-space()='Category']" )private WebElement cat;
	  @FindBy(xpath =" //label[normalize-space()='Sub Category']" )private WebElement subcat;
	  @FindBy(xpath =" //label[normalize-space()='Price Type']" )private WebElement price;
	  @FindBy(xpath =" //label[normalize-space()='Weight Value']" )private WebElement value;
	  @FindBy(xpath =" //label[normalize-space()='Weight Unit']" )private WebElement unit;
	  @FindBy(xpath =" //label[normalize-space()='Maximum Quantity Can Order (Kg)']" )private WebElement quantity;
	  @FindBy(xpath =" //div[@id='myDIV']//label[@for='mini_wgt'][normalize-space()='Price']" )private WebElement price1;
	  @FindBy(xpath =" //label[normalize-space()='Stock Availability(Kg)']" )private WebElement stock;
	  @FindBy(xpath =" //label[normalize-space()='Featured']" )private WebElement feat ;
	  @FindBy(xpath =" //label[normalize-space()='Combo Pack']" )private WebElement combo;
	  @FindBy(xpath =" //button[normalize-space()='Save']" )private WebElement savebutton;
	  
	  

	   public void clickOnManageField()
	   {
		   manage.click();
	   }
	   

	   public void clickOnNewButtonField()
	   {
		   newbutton.click();
	   }
	   

	   public void clickOnTitleField(String ti )
	   {
		   title.sendKeys(ti);
	   }
	   
	   
	   public void clickOnWeightvaluefield(String wei)
	   {
		   value.sendKeys(wei);
	   }
	   public void clickonWeightUnitDropdown() {
			  
			  Select select= new Select(unit);
			  select.selectByVisibleText("kg");
			 // usertype.click();
		  }

	   public void clickOnMaximunquantitucanAddfield(String quant)
	   {
		   value.sendKeys(quant);
	   }
	   
	   public void clickOnPricefield(String pr)
	   {
		   value.sendKeys(pr);
	   }
	   public void clickOnStockAvailabilityfield(String sto)
	   {
		   value.sendKeys(sto);
	   }
	   public void clickoNRadioButton()
	   {
		   radio.click();
	   }
	   
	   public void clickOnSaveButton() {
			  savebutton.click();
		  }
	   
}
