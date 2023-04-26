package Base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	
	@BeforeMethod
	public void start() {

		//initializeBrowser(prop.getProperty("Browser"));
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("http://www.tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[.='My Account']")).click();
		driver.findElement(By.xpath("(//a[.='Login'])[1]")).click();

	}

	@AfterMethod
	public void end() {
		driver.quit();

	}

	public void loadPropertiesFile() {

		prop = new Properties();
		File file = new File(System.getProperty("user.dir") + "//src//main//java//config//data.properties");

		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public WebDriver initializeBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get(prop.getProperty("URL"));
		return driver;
	}

}
