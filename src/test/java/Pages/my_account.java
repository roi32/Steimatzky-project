package Pages;

import org.testng.annotations.Test;

import ID.my_account_id;
import Tools.Extent_reports;
import Tools.setUp;
import elements.login_user;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class my_account extends setUp {

	static String Title = "steimatzky - my account test";
	static Extent_reports exm = new Extent_reports(driver);
	static my_account_id pof;

	@BeforeClass
	public void beforeClass() {
		extent = Extent_reports.GetExtent(Title);
		test = Extent_reports.createTest("login test", "Correct Login - test");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
		actions= new Actions(driver);
	}

	@BeforeMethod
	public void BeforeMethod() {
		pof = new my_account_id();
		pof = PageFactory.initElements(driver, my_account_id.class);
	}

	@AfterClass
	public void afterClass() {
		extent.flush();
		driver.quit();
	}

	@Test(priority = 1)
	public void login() throws IOException, AWTException {
		login_user.Login(Title, exm, test, actions);
	}

	@Test
	public void my_account_page() {
		actions.moveToElement(pof.club).perform();
		actions.moveToElement(pof.my_details).click().perform();
		pof.right_sidebar.get(0).click();

	}
}
