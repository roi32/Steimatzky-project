package Pages;

import Tools.Extent_reports;
import Tools.func;
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
	static homepage_id pof;

	@BeforeClass
	public void BeforeClass() {
		extent = Extent_reports.GetExtent(Title);
		test = Extent_reports.createTest("Home page", "Homepage - test");
		test1 = Extent_reports.createTest("Home page", "Navigation bar - test");
		test2 = Extent_reports.createTest("Home page", "Search test");
		test3 = Extent_reports.createTest("Home page", "Footer test");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
		actions = new Actions(driver);
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

	@Test(priority = 1, groups = "home page", enabled = true)
	public void login_user() throws IOException, AWTException {
		login_user.Login(Title, exm, test, actions);
	}

	@Test(priority = 2, groups = "home page", dependsOnMethods = { "login_user" }, enabled = true)
	public void callPoppup() throws IOException, AWTException, InterruptedException {
		actions.moveToElement(pof.callPoppup).click().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actions.moveToElement(pof.Cpopup).click().perform();
		Thread.sleep(2000);
		String pageTitle = driver.getTitle();
		func.pageTitleTest(pageTitle, "סניפים פתוחים", exm, test);
		Thread.sleep(1000);
		actions.moveToElement(pof.logo).click().perform();
		pageTitle = driver.getTitle();
		func.pageTitleTest(pageTitle, "ספרים זה סטימצקי | ספרים באינטרנט קונים באתר סטימצקי", exm, test);
		Thread.sleep(1000);
	}

	@Test(priority = 3, groups = "elements", dependsOnMethods = { "login_user" }, enabled = true)
	public void Navigation_bar() throws AWTException, IOException {
		Navigation_bar.NavigationBar(driver, test1, exm, actions);
	}

	@Test(priority = 4, groups = "elements", enabled = true)
	public void SearchProduct() throws AWTException, IOException {
		search_product.searchProduct(driver, test2, exm);
	}

	@Test(priority = 5, groups = "elements", enabled = true)
	public void Search() throws IOException, InterruptedException, AWTException {
		search.Search(driver, test2, exm);
	}

	@Test(priority = 6, groups = "elements", dependsOnMethods = { "login_user" }, enabled = true)
	public void footer() throws AWTException, IOException {
		Footer_Buttom.Footer(driver, test3, exm, actions);
	}
}
