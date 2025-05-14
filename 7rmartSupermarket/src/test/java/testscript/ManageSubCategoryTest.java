package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.ManageSubCategoryPage;
import utilities.Exelutility;

public class ManageSubCategoryTest  extends Base{
	@Test
	public void verifyUsercanAddNewSubcategory()throws IOException {
		
		

		String username=Exelutility.readStringData(0, 0, "LoginPage");
		String password=Exelutility.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickONLoginButon();
		
		String 	sub=Exelutility.readStringData(0, 0, "Subcategory");
		 ManageSubCategoryPage page=new  ManageSubCategoryPage(driver);
		 page.clickonSubCategoryMenu();
		 page.clickOnMoreInfoField();
		 page.clickOnNewButton();
		 page.clickOnCategoryDropdown();
		 page.clickOnSubCategoryField();
		 page.clickonsaveButton();
		 
		 
		    
			
	}

}
