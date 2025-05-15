package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.Exelutility;
import utilities.RandomDataUtility;

public class AdminUserTest  extends Base {
	HomePage home;
	AdminUserPage admin;
	
		
		@Test
		public void verifyAdmincanAddaNewUser() throws IOException {
			
			String username=Exelutility.readStringData(0, 0, "LoginPage");
			String password=Exelutility.readStringData(0, 1, "LoginPage");
			LoginPage login=new LoginPage(driver);
			login.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickONLoginButon();
			home=login.clickONLoginButon();
			admin=home.clickOnAdminUsersField();
			admin.selectOnManageUsers();
			admin.clickOnNewUserButton();
			RandomDataUtility random=new RandomDataUtility();
			String newuserusername=random.createrandomusername();
			String newuserpassword=random.createrandompassword();
			admin.enterNewUserNameOnUsernameField(newuserusername).enterNewPasswordOnPasswordField(newuserpassword).clickUserTypeDropdown().clickOnSaveButton();
		    boolean issuccessAlertDisplayed = admin.successAlertDisplayed();
	 		Assert.assertTrue(issuccessAlertDisplayed, Messages.USERCREATIONERROR);
			
			
		}
		
		@Test
		public void verifyAdmincanSearchaUser() throws IOException {
			
			 
				
				String username=Exelutility.readStringData(0, 0, "LoginPage");
				String password=Exelutility.readStringData(0, 1, "LoginPage");
				LoginPage login=new LoginPage(driver);
				login.enterUsernameOnUserNameField(username).enterPasswordOnPasswordField(password).clickONLoginButon();
				home=login.clickONLoginButon();
				admin=home.clickOnAdminUsersField();
				admin.selectOnManageUsers();
				admin.clickOnNewUserButton();
				admin.clickOnSearchButton();
				String usernamesearch1=Exelutility.readStringData(0, 0, "Homepage");
				admin.enterUserNameOnSearchAdminUser(usernamesearch1).selectUsertypeOnSearchAdminUser().clickOnSearchSubmittButton();
				boolean isTextdisplayedinresult=admin.textinresulthWindow();
				Assert.assertTrue(isTextdisplayedinresult, Messages.USERSEARCHFAILERROR);
		}

}
