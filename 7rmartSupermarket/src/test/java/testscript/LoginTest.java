package testscript;

import java.io.IOException;

import org.openqa.selenium.devtools.Message;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.Exelutility;



public class LoginTest extends Base {
	@Test(priority = 1,description = "Verify Whether the user is able to login with valid credentials",retryAnalyzer = retry.Retry.class)
	public void verifyuserloginwithvalidcredentials() throws IOException
	{
	String 	username=Exelutility.readStringData(0, 0, "Loginpage");
	String password =Exelutility.readStringData(0, 1, "Loginpage");
	LoginPage login=new LoginPage(driver);
	login.enterUsernameOnUserNameField(username);
	login.enterPasswordOnPasswordField(password);
	login.clickONLoginButon();
	boolean isdashboarddisplayed=login.dashboardDisplayed();
	Assert.assertTrue(isdashboarddisplayed,Messages.VALIDCRENDENTIALS);
		
	}
	@Test(priority = 2,description = "Verify Whether the user is unable  to login with invalid username")
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
	@Test(priority = 3,description = "Verify Whether the user is unable  to login with invalid password")
	public void verifyuserloginwithinvalidpassword() throws IOException
	{
		String 	username=Exelutility.readStringData(2, 0, "Loginpage");
		String password =Exelutility.readStringData(2, 1, "Loginpage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickONLoginButon();
			
	}
	@Test(priority = 4,description = "Verify Whether the user is unable  to login with invalid credentials",dataProvider ="loginProvider" )
	public void verifyuserloginwithinvalidpasswordandusername(String username,String password ) throws IOException
	{
		//String 	username=Exelutility.readStringData(3, 0, "Loginpage");
		//String password =Exelutility.readStringData(3, 1, "Loginpage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickONLoginButon();
	}
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] { new Object[] {"admin","admin"},new Object[] {"123","1234"} 
				
					
		};
}
}
