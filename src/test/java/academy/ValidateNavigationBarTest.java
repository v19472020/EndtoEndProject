package academy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateNavigationBarTest extends Base {
	
	public static Logger log = LogManager.getLogger(ValidateNavigationBarTest.class.getName());

	@BeforeTest
	public void initializeBrowser() throws IOException {
		

		driver = InitializeDriver();
		driver.get(pro.getProperty("url"));
	}
	
	
	@AfterTest
	public void CloseBrowser() {
		
		driver.close();
		driver = null;
	}
	
	
	@Test
	public void navigationBar() throws IOException {





		LandingPage l = new LandingPage(driver);
		try {
		l.closePopUp().click();
		}
		
		finally {
		

			Assert.assertTrue(l.getNavigaBar().isDisplayed());
			log.info("Validated Naviagation bar");

		}
	}
}
