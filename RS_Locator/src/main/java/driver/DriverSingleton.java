package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ConfigReadaer;

public class DriverSingleton {
	private static String browser = ConfigReadaer.getStringValue("browser");
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver == null) {
			if("chrome".equals(browser)) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				driver.manage().window().maximize();
			}else if("firefox".equals(browser)) {
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
				driver.manage().window().maximize();
			}else if("edge".equals(browser)) {
				WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver();
				driver.manage().window().maximize();
			}
		}
		return driver;
	}
	
	public static void quidDriver() {
		driver.quit(); // all tab will close
		//driver.close(); only the tab will close
		driver=null;
	}
}
