package academy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

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

public class ValidateTitleTest extends Base {
	
	public Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initializeBrowser() throws IOException {
		

		driver = InitializeDriver();
			log.info("Browser Intialised");
		driver.get(pro.getProperty("url"));
			log.info("Navigated to HomePage of QAClick academy");
	}
	
	@AfterTest
	public void CloseBrowser() {
		
		driver.close();
		driver = null;
			log.info("Browser is closed");
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		
		
		LandingPage l = new LandingPage(driver);
		
		try {
		l.closePopUp().click();
			log.info("Close the popup");
		}
		
		finally {
		
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
			log.info("Successfully validated the titleText FeaturedCourses");
	
		}

	}
	
	
}
