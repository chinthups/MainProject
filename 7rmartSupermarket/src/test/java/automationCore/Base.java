package automationCore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import utilities.ScreenShotUtlity;

public class Base {
	
	public WebDriver driver;
	@BeforeMethod
	@Parameters("browser")
	public void initialiseBrowser(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		else
		{
			throw new Exception("invalid browser");
		}
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
