package Pages;

import Tools.Extent_reports;
import Tools.setUp;
import elements.Footer_Buttom;
import elements.Navigation_bar;
import elements.login_user;
import io.github.bonigarcia.wdm.WebDriverManager;
import search.search;
import search.search_product;
import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ID.homepage_id;

public class homepage extends setUp {

	static String Title = "Home page";
	static Extent_reports exm = new Extent_reports(driver);
	static Actions actions;
	static homepage_id pof;

	@BeforeClass
	public void BeforeClass() {
		extent = Extent_reports.GetExtent(Title);
		test = Extent_reports.createTest("Home page", "Homepage - test");
		test1 = Extent_reports.createTest1("Home page", "Navigation bar - test");
		test2 = Extent_reports.createTest2("Home page", "Search test");
		test3 = Extent_reports.createTest3("Home page", "Footer test");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
	}

	@BeforeMethod
	public void BeforeMethod() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pof = new homepage_id();
		pof = PageFactory.initElements(driver, homepage_id.class);
	}

	@AfterClass
	public void AfterClass() {
		extent.flush();
		driver.quit();
	}

	@Test(priority = 1,groups = "elements", enabled = true)
	public void login_user() throws IOException, AWTException {
		login_user.Login(Title, exm, test);
	}

	@Test(priority = 2,groups = "elements", dependsOnMethods = { "login_user" }, enabled = true)
	public void Navigation_bar() throws AWTException, IOException {
		Navigation_bar.NavigationBar(driver, test1, exm);
	}

	@Test(priority = 3,groups = "elements", enabled = true)
	public void SearchProduct() throws AWTException, IOException {
		search_product.searchProduct(driver, test2, exm);
	}

	@Test(priority = 4,groups = "elements", enabled = true)
	public void Search() throws IOException, InterruptedException, AWTException {
		search.Search(driver, test2, exm);
	}

	@Test(priority = 5,groups = "elements", dependsOnMethods = { "login_user" }, enabled = true)
	public void footer() throws AWTException, IOException {
		Footer_Buttom.Footer(driver, test3, exm);
	}
}
