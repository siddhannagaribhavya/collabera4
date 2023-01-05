package MR.Beast;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericLibrary.Base_Class;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_case  extends Base_Class{
	@Test
	public void sample() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("http://localhost:3000/login");
		Runtime.getRuntime().exec("./autoIt/notPopUp.exe");
	   
}
}