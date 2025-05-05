package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.Exelutility;

public class ManageNewsTest extends Base  {
	@Test
	public void verifyUserCanAddNewNews() throws IOException {
		

		String username=Exelutility.readStringData(0, 0, "LoginPage");
		String password=Exelutility.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickONLoginButon();
		
		String 	news=Exelutility.readStringData(0, 0, "Managenews");
		ManageNewsPage  manage=new ManageNewsPage(driver);
		manage.clickOnManageNewsField();
		manage.clickonNewButtonField();
		manage.clickOnNewfield(news);
		manage.clickOnSaveButton();
		
	}

}
