package commonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass
{	
	public static WebDriver sdrievr ;
	
	WebDriver driver = new ChromeDriver();
	WebDriverUtil wutil = new WebDriverUtil();
	PropertyFileUtil putil = new PropertyFileUtil();
	
	@BeforeSuite
	public void BS()
	{
		
		System.out.println("Connect to Data Base");
	}
	
	@BeforeClass
	public void BC() throws IOException
	
	//@BeforeClass is used to launch the application.
	
	{
		//To maximize the window.(call method from WebDriverUtil class)
		wutil.Maximize(driver);
		
		//To apply wait for findElement method.(call method from WebDriverUtil class)
		wutil.ImpliciteWait(driver);
		
		String URL=putil.getDataFromPropertyFile("Url");
		
		//To launch the application.
		driver.get(URL);
	}
	
	@BeforeMethod
	public void BM() throws IOException
	
	//@BeforeMethod is used to login to the application.
	{
		//To read data from property file.
		String USER=putil.getDataFromPropertyFile("Username");
				
		//To read data from property file.
		String PASS=putil.getDataFromPropertyFile("Password");
		
		driver.findElement(By.name("user_name")).sendKeys(USER);
		driver.findElement(By.name("user_password")).sendKeys(PASS);
		
		//To click on login button.
		driver.findElement(By.id("submitButton")).click();
	}
	
	@AfterMethod
	public void AM() throws InterruptedException
	
	//	@AfterMethod is used To Signout from the application.
	{
		//Mouse over on image
		Thread.sleep(4000);
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
				
		//Call the method from WebDriverUtil class mouseOver().
		wutil.mouseOver(driver, img);
			
		//To click on Sign out text.
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	
	@AfterClass
	public void AC() 
	
	//@AfterClass is used to close the browser.
	{
		driver.quit();
	}
	
	@AfterSuite
	public void AS() 
	{
		System.out.println("Disconnect from Data Base");
	}
	
}
