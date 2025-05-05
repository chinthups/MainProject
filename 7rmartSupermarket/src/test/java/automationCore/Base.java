package automationCore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenShotUtlity;

public class Base {
	
	public WebDriver driver;
	@BeforeMethod
	public void initialiseBrowser()
	{
		driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@AfterMethod(alwaysRun=true)

	public void driverQuit(ITestResult iTestResult) throws IOException

	{

	if(iTestResult.getStatus()==ITestResult.FAILURE)

	{

		ScreenShotUtlity screenShot=new ScreenShotUtlity();

		screenShot.getScreenshot(driver, iTestResult.getName());

	}

		driver.quit();

		

	}
}
