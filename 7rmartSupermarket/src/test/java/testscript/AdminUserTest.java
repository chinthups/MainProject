package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.Exelutility;
import utilities.RandomDataUtility;

public class AdminUserTest  extends Base {
	
		
		@Test
		public void verifyAdmincanAddaNewUser() throws IOException {
			
			String username=Exelutility.readStringData(0, 0, "LoginPage");
			String password=Exelutility.readStringData(0, 1, "LoginPage");
			LoginPage login=new LoginPage(driver);
			login.enterUsernameOnUserNameField(username);
			login.enterPasswordOnPasswordField(password);
			login.clickONLoginButon();
			AdminUserPage adminuser=new AdminUserPage(driver);
			adminuser.clickOnAdminUsersField();
			adminuser.selectOnManageUsers();
			adminuser.clickOnNewUserButton();
			RandomDataUtility random=new RandomDataUtility();
			String newuserusername=random.createrandomusername();
			String newuserpassword=random.createrandompassword();
			adminuser.enterNewUserNameOnUsernameField(newuserusername);
			adminuser.enterNewPasswordOnPasswordField(newuserpassword);
			adminuser.clickUserTypeDropdown();
		    adminuser.clickOnSaveButton();
			
			
		}
		
		@Test
		public void verifyAdmincanSearchaUser() throws IOException {
			
			 
				
				String username=Exelutility.readStringData(0, 0, "LoginPage");
				String password=Exelutility.readStringData(0, 1, "LoginPage");
				LoginPage login=new LoginPage(driver);
				login.enterUsernameOnUserNameField(username);
				login.enterPasswordOnPasswordField(password);
				login.clickONLoginButon();
				AdminUserPage adminuser=new AdminUserPage(driver);
				adminuser.clickOnAdminUsersField();
				adminuser.selectOnManageUsers();
				adminuser.clickOnNewUserButton();
				adminuser.clickOnSearchButton();
				String usernamesearch1=Exelutility.readStringData(0, 0, "Homepage");
				adminuser.enterUserNameOnSearchAdminUser(usernamesearch1);
				adminuser.selectUsertypeOnSearchAdminUser();
				adminuser.clickOnSearchSubmittButton();
		}

}
