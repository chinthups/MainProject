package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.yaml.snakeyaml.scanner.Constant;

import constants.Constants;
import utilities.PageUtility;

public class AdminUserPage {
	
public WebDriver driver;
	
	public AdminUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//p[normalize-space()='Admin Users']")private WebElement adminuser;
@FindBy(xpath = "//p[normalize-space()='Manage Users']")private WebElement manageuser;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")private WebElement addnewuser;
@FindBy(id="username")private WebElement newUsername;
@FindBy(id="password")private WebElement userpassword;
@FindBy(id="user_type")private WebElement usertype;
@FindBy(xpath="//button[@name='Create']")private WebElement savebutton;
@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")private WebElement SuccessMessage;
@FindBy(xpath="//a[@onclick='click_button(2)']")private WebElement searchbutton;
@FindBy(id="un")private WebElement usernamesearch;
@FindBy(id="ut")private WebElement usertypesearch;
@FindBy(xpath="//button[@name='Search']")private WebElement searchsubmittbotton;
@FindBy(xpath = "//h4[text()='Admin Users']")
private WebElement textinTheSearchResultDiv;






  public HomePage clickOnAdminUsersField() {
	adminuser.click();
	return new HomePage(driver);
  }
	
  public AdminUserPage selectOnManageUsers() {
	  manageuser.click();
	  return this;
  }
  public AdminUserPage clickOnNewUserButton() {
	  addnewuser.click();
	  return this;
  }
  public AdminUserPage enterNewUserNameOnUsernameField(String newuserusername) {
	  newUsername.sendKeys(newuserusername);
	  return this;
  }
  public AdminUserPage enterNewPasswordOnPasswordField(String newuserpassword) {
	  userpassword.sendKeys(newuserpassword);
	  return this;
  }	
  public AdminUserPage clickUserTypeDropdown() {
	  
	  PageUtility page = new PageUtility();
		page.selectDropdownWithIndex(usertype,  Constants.DROPDOWNONIDEX2);
		return this;
  }
  public AdminUserPage clickOnSaveButton() {
	  savebutton.click();
	  return this;
  }
  public boolean successAlertDisplayed() {
	   
		return SuccessMessage.isDisplayed();
	}
  public AdminUserPage clickOnSearchButton() {
	  searchbutton.click();
	  return this;
  }
  public AdminUserPage enterUserNameOnSearchAdminUser(String usernamesearch1) {
	  usernamesearch.sendKeys(usernamesearch1);
	  return this;
  }
  public AdminUserPage selectUsertypeOnSearchAdminUser() {
	  PageUtility page = new PageUtility();
		page.selectDropdownWithIndex(usertypesearch, Constants.DROPDOWNONIDEX2);
		searchsubmittbotton.click();
		return this;
  }
  public AdminUserPage clickOnSearchSubmittButton() {
	  searchsubmittbotton.click();
	  return this;
  }
  public boolean textinresulthWindow() {
		return textinTheSearchResultDiv.isDisplayed();
	}
  
}
