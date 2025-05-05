package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.Exelutility;



public class LoginTest extends Base {
	@Test
	public void verifyuserloginwithvalidcredentials() throws IOException
	{
	String 	username=Exelutility.readStringData(0, 0, "Loginpage");
	String password =Exelutility.readStringData(0, 1, "Loginpage");
	LoginPage login=new LoginPage(driver);
	login.enterUsernameOnUserNameField(username);
	login.enterPasswordOnPasswordField(password);
	login.clickONLoginButon();
	boolean isdashboarddisplayed=login.dashboardDisplayed();
	Assert.assertTrue(isdashboarddisplayed, "User was Unable to Login Successfully ");
		
	}
	@Test
	public void verifyuserloginwithinvalidusername() throws IOException
	{
		String 	username=Exelutility.readStringData(1, 0, "Loginpage");
		String password =Exelutility.readStringData(1, 1, "Loginpage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickONLoginButon();
		String actual=login.getpagetitle();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,"User was able to Login with Invalid Username");
			
			
	}
	@Test
	public void verifyuserloginwithinvalidpassword() throws IOException
	{
		String 	username=Exelutility.readStringData(2, 0, "Loginpage");
		String password =Exelutility.readStringData(2, 1, "Loginpage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickONLoginButon();
			
	}
	@Test
	public void verifyuserloginwithinvalidpasswordandusername() throws IOException
	{
		String 	username=Exelutility.readStringData(3, 0, "Loginpage");
		String password =Exelutility.readStringData(3, 1, "Loginpage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickONLoginButon();
	}
}
