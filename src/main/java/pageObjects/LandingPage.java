package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;


	By popUp 	=  By.xpath("//div//div[@class='sumome-react-wysiwyg-popup-container sumome-react-wysiwyg-popup sumome-react-wysiwyg-is-resizing sumome-animated-default']//div//div[2]");

	By noThanks = By.xpath("//button[text()='NO THANKS']");

	By signIn 	= By.cssSelector("a[href*='sign_in']");

	By title	= By.xpath("//h2[text() = 'Featured Courses']");

	By navigationBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");



	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}




	public WebElement closePopUp() {

		return driver.findElement(noThanks);
	}


	public WebElement getlogin() {

		return driver.findElement(signIn);
	}


	public WebElement getTitle() {

		return driver.findElement(title);
	}


	public WebElement getNavigaBar() {

		return driver.findElement(navigationBar);
	}
}
