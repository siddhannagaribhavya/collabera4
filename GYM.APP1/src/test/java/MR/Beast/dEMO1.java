package MR.Beast;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import genericLibrary.Base_Class;
import pomRepository.MySchedule;

public class dEMO1 extends Base_Class {
	@Test
	public void sample() throws InterruptedException, IOException {
		//homePage.getUsersModuleLink().click();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/");
		Thread.sleep(5000);
		Runtime.getRuntime().exec("./autoIt/notPopUp.exe");
		
	}
}
