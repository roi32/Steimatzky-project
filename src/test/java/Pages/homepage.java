package Pages;

import Tools.Extent_reports;
import Tools.setUp;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ID.homepage_id;
import Navigation_bar.Navigation_bar;

public class homepage extends setUp {

	static Extent_reports exm = new Extent_reports(driver);

	@BeforeClass
	public void beforeSuite() {
		extent = Extent_reports.GetExtent();
		test = Extent_reports.createTest("name", "desc");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
		

	}

	@BeforeMethod
	public void BeforeMethod() {
		pof = new homepage_id();
		pof = PageFactory.initElements(driver, homepage_id.class);

	}

	@AfterClass
	public void afterSuite() {
		extent.flush();
		driver.quit();
	}

	@Test
	public void Navigation_bar() {
		Navigation_bar.NavigationBar(driver, test, exm);

	}
}
