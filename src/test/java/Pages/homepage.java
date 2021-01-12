package Pages;

import org.testng.annotations.BeforeSuite;

import Tools.Extent_reports;
import Tools.homepage_func;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;

public class homepage extends homepage_func {

	@BeforeSuite
	public void beforeSuite() {
		extent = Extent_reports.GetExtent();
		test = Extent_reports.createTest("name", "desc");
		test1 = Extent_reports.createTest1("name", "desc");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
		actions = new Actions(driver);

	}

	@AfterSuite
	public void afterSuite() {
		extent.flush();
		driver.quit();
	}

}
