package ComputerWorld.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseClass {

	public static Properties prop;
	public static WebDriver driver;
	WebDriverWait wait;
	

	public baseClass() {
		prop = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir") + "/Config.Properties");
			prop.load(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void initialization() {
		//wait = new WebDriverWait(driver, 15);
		String browser = prop.getProperty("Browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + prop.getProperty("ChromeDriverPath"));
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		} else {
			System.out.println(" The Automation tool is compatible with chrome,firefox and internte explorer");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
		
		driver.get(prop.getProperty("Url"));

	}

}
