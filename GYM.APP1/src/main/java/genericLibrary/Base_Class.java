package genericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
//import pomRepository.HomePage;

public class Base_Class implements FrameworkConstants {

	public static WebDriver driver;
	public WebDriverWait explicitWait;
	public PropertyFileReader readFromPropertyFile;
	public ExcelUtil excelUtil=new ExcelUtil();
	public UtilityMethods utilitymethods=new UtilityMethods();
	//public HomePage homePage;

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void openTheBrowser(@Optional("chrome") String browserName) throws InterruptedException {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log("Successfully Launched Chrome Browser", true);
		} 
			Reporter.log("Enter valid Browser name");
		
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized successfully", true);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, EXPLICIT_TIMEOUT);
		Thread.sleep(3000);
	}


	@BeforeMethod(alwaysRun = true)
	public void navigateToApplication() {
		readFromPropertyFile = new PropertyFileReader();
		String url = readFromPropertyFile.getValueProperty("url");

		driver.get(url);
		//homePage = new HomePage(driver);
	}

	@AfterClass(alwaysRun = true)
	public void closeTheBrowser() {
		//driver.quit();
	}
}
