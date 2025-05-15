package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.Exelutility;

public class ManageProductTest extends Base{
	@Test
	public void verifyUserCanAddNewproduct() throws IOException {
		
		String username=Exelutility.readStringData(0, 0, "LoginPage");
		String password=Exelutility.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickONLoginButon();
		
		
		
	}

}
