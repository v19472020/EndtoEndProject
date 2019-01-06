package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Base {

	public static WebDriver driver;
	public static Properties pro = new Properties();

	public WebDriver InitializeDriver() throws IOException {


		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\End2EndProject\\src\\main\\java\\resources\\data.properties");
		pro.load(fis);

		String browserName = pro.getProperty("browser");

		if (browserName.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\.m2\\repository\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName == "Firefox") {

			driver = new FirefoxDriver();

		}

		else if (browserName == "Edge") {

			driver = new EdgeDriver();

		}



		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	//Synchronization

		return driver;


	}

	public void getScreenshot(String result) throws IOException {
		
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//" + result + "screenshot.png"));
		
		
	}



}
