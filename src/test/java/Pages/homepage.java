package Pages;

import Tools.Extent_reports;
import Tools.setUp;
import elements.login_user;
import io.github.bonigarcia.wdm.WebDriverManager;
import search.search;
import search.search_product;
import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ID.homepage_id;
import Navigation_bar.Navigation_bar;

public class homepage extends setUp {
	static String Title = "homepage";
	static Extent_reports exm = new Extent_reports(driver);
	static String Description = "home page";

	@BeforeClass
	public void beforeSuite() {
		extent = Extent_reports.GetExtent(Title);
		test = Extent_reports.createTest("homepage", "Navigation bar");
		test1 = Extent_reports.createTest1("homepage", "search test");
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

	@Test(priority = 1)
	public void login_user() throws IOException, AWTException {
		login_user.Login(Description, exm);
	}

	@Test(priority = 4)
	public void Navigation_bar() {
		Navigation_bar.NavigationBar(driver, test, exm);

	}

	@Test(priority = 3)
	public void SearchProduct() {
		search_product.searchProduct(driver, test1, exm);
	}

	@Test(priority = 2)
	public void Search() throws IOException, InterruptedException, AWTException {
		search.Search(driver, test1, exm);

	}
}
