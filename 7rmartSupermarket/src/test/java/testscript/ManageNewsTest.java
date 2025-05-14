package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.Exelutility;

public class ManageNewsTest extends Base  {
	HomePage home;
	ManageNewsPage news;
	@Test
	public void verifyUserCanAddNewNews() throws IOException {
		

		String username=Exelutility.readStringData(0, 0, "LoginPage");
		String password=Exelutility.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		home=login.clickONLoginButon();
		
		String 	n=Exelutility.readStringData(0, 0, "Managenews");
		news=home.clickOnManageNewsField();
		news.clickonNewButtonField();
		news.clickOnNewfield(n);
		news.clickOnSaveButton();
		
		
		boolean issuccessAlertDisplayed = news.successAlertDisplayed();
 		Assert.assertTrue(issuccessAlertDisplayed, Messages.SEARCHFAILERROR);
	}

}
