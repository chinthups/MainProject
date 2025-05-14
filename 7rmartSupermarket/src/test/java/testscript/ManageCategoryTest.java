package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.Exelutility;
import utilities.RandomDataUtility;

public class ManageCategoryTest  extends Base{
	
	HomePage home;
	ManageCategoryPage category;
		@Test(description="To verify whether user is able to create new category")
		public void verifyWhetherUserIsAbleToCreateNEwCategory() throws IOException {
			String username = Exelutility.readStringData(0, 0, "Login page");
			String password = Exelutility.readStringData(0, 1, "Login page");
			LoginPage login = new LoginPage(driver);
			login.enterUsernameOnUserNameField(username);
			login.enterPasswordOnPasswordField(password);
			home=login.clickONLoginButon();
			category=home.clickCategory();
			category.createNewButon();
			RandomDataUtility randomcategory=new RandomDataUtility();
			String categoryName=randomcategory.createRandomProductCategory();
			category.enterCategoryName(categoryName).selectGroup().selectimagefile().leftMenuRadio().topMenuradio().saveButton();
			boolean isalertdisplayed=category.getAlertText();
			Assert.assertTrue(isalertdisplayed, Messages.CATEGORYSAVEERROR);
			
		}

}
