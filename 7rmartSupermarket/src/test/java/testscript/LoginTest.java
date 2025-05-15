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
import utilities.RandomDataUtility;



public class LoginTest extends Base {
	@Test(priority = 1,description = "Verify Whether the user is able to login with valid credentials",retryAnalyzer = retry.Retry.class)
	public void verifyuserloginwithvalidcredentials() throws IOException
	{
	String 	username=Exelutility.readStringData(0, 0, "Loginpage");
	String password =Exelutility.readStringData(0, 1, "Loginpage");
	LoginPage login=new LoginPage(driver);
	login.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickONLoginButon();
	boolean isdashboarddisplayed=login.dashboardDisplayed();
	Assert.assertTrue(isdashboarddisplayed,Messages.VALIDCRENDENTIALS);
		
	}
	@Test(priority = 2,description = "Verify Whether the user is unable  to login with invalid username",groups= {"smoke"})
	public void verifyuserloginwithinvalidusername() throws IOException
	{
		String 	username=Exelutility.readStringData(1, 0, "Loginpage");
		String password =Exelutility.readStringData(1, 1, "Loginpage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickONLoginButon();
		String actual=login.getpagetitle();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,Messages.INVALIDUSERNAMEERROR);
			
			
	}
	@Test(priority = 3,description = "Verify Whether the user is unable  to login with invalid password",groups= {"smoke"})
	public void verifyuserloginwithinvalidpassword() throws IOException
	{
		String 	username=Exelutility.readStringData(2, 0, "Loginpage");
		String password =Exelutility.readStringData(2, 1, "Loginpage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickONLoginButon();
		String actual = login.getpagetitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Messages.INVALIDPASSWORDERROR);
			
	}
	@Test(priority = 4,description = "Verify Whether the user is unable  to login with invalid credentials",dataProvider ="loginProvider" )
	public void verifyuserloginwithinvalidpasswordandusername( ) throws IOException
	{
		RandomDataUtility random = new RandomDataUtility();
		String username = random. createrandomusername();
		String password = random.createrandompassword();
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickONLoginButon();
		boolean isalertdisplayed = login.invalidUserAlert();
		Assert.assertTrue(isalertdisplayed, Messages.INVALIDCREDENTIALERROR );
	}
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] { new Object[] {"admin","admin"},new Object[] {"123","1234"} 
				
					
		};
}
}
