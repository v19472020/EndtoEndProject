package academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePageTest extends Base {

	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());

	@BeforeTest
	public void initializeBrowser() throws IOException {

	}

	@AfterTest
	public void CloseBrowser() {

		driver.close();
		driver = null;
	}

	@Test(dataProvider = "getData")
	public void basePageNavigLogin(String userName, String password) throws IOException {



		driver = InitializeDriver();
		log.info("Drvier is Intialised");
		
		driver.get(pro.getProperty("url"));
		log.info("Navigated to QAClick Academy HomePage");
		
		LandingPage l = new LandingPage(driver);

		try {

			l.closePopUp().click();

		}

		finally{


			l.getlogin().click();



			LoginPage lp = new LoginPage(driver);

			lp.getEmailAdd().sendKeys(userName);
			lp.getPassword().sendKeys(password);

			lp.getLogin().click();

		}
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object [3][2];

		data[0][0] = "vijsenreddykunduru@gmail.com";
		data[0][1] = "sen";

		data[1][0] = "payalpanday16@gmail.com";
		data[1][1] = "Panday";


		data[2][0] = "Indhra@gmail.com";
		data[2][1] = "Sena";

		return data;		


	}


}
