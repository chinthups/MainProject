package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.Exelutility;

public class HomeTest  extends Base{
	HomePage home;
	@Test
	public void verifyusercansuccessfullylogoutafterlogin() throws IOException{
		
		String 	username=Exelutility.readStringData(0, 0, "Loginpage");
		String password =Exelutility.readStringData(0, 1, "Loginpage");
		
		LoginPage login=new LoginPage(driver);
		
		login.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickONLoginButon();
		home=login.clickONLoginButon();
		
		home.clickOnAdminfield().clickOnLogoutbutton();
		
		
	}
	
	

}
