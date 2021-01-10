package search;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import ID.search_id;
import Tools.Extent_reports;
import Tools.search_func;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class search extends search_func {
	static search_id pof;
	static String sheet = "text_search";

	@BeforeClass
	public void beforeClass() {
		extent = Extent_reports.GetExtent();
		test1 = Extent_reports.createTest1("name", "desc");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
	//	driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
	}

	@BeforeMethod
	public void BeforeMethod() {
		pof = new search_id();
		pof = PageFactory.initElements(driver, search_id.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		extent.flush();
		driver.close();
	}

	@Test(priority = 2)
	public void key_word() throws IOException, InterruptedException, AWTException {
		int rows = 0;
		while (rows <= 9) {
			// read from excel file
			String value = Product_value(rows, 0, sheet);
			Thread.sleep(500);
			// search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// test if products is found
			resuleTest3(pof.product_grid, value);
			rows++;
		}
	}

	@Test(priority = 3)
	public void authorTitle() throws IOException, InterruptedException, AWTException {
		int rows = 0;
		while (rows <= 11) {
			// read from excel file
			String value = Product_value(rows, 1, sheet);
			Thread.sleep(500);
			// search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// test if products is found
			if (driver.findElement(By.xpath("//div/h1")).getText().contains("תוצאות חיפוש")) {
				resuleTest3(pof.authorTitle, value);
			} else {
				driver.navigate().back();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				test1.fail("the search of " + value+"not found products",MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
			Thread.sleep(1000);
			rows++;
		}
	}

	@Test(priority = 4)
	public void EauthorTitle() throws IOException, InterruptedException, AWTException {
		int rows = 0;
		while (rows <= 6) {
			// read from excel file
			String value = Product_value(rows, 2, sheet);
			Thread.sleep(500);
			// search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// test if products is found
			if (driver.findElement(By.xpath("//div/h1")).getText().contains("תוצאות חיפוש")) {
				resuleTest3(pof.authorTitle, value);
			} else {
				driver.navigate().back();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				test1.fail("the search of " + value+"not found products",MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
			Thread.sleep(1000);
			rows++;
		}
	}

	@Test(priority = 5)
	public void Negative() throws IOException, InterruptedException, AWTException {
		int rows = 0;
		while (rows <= 6) {
			// read from excel file
			String value = Product_value(rows, 3, sheet);
			Thread.sleep(500);
			// search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// test if products is found
			resuleTest2(driver.findElement(By.xpath("//p[@class='note-msg']")).getText(),"אין תוצאות לשאילתת חיפוש שלך");
			Thread.sleep(1000);
			rows++;
		}
	}

	@Test(priority = 6)
	public void Boundary() throws IOException, InterruptedException, AWTException {
		int rows = 0;
		while (rows <= 3) {
			// read from excel file
			String value = Product_value(rows, 4, sheet);
			Thread.sleep(500);
			// search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			String search = pof.search.getAttribute("value");
			pof.submit.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// test if products is found
			if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText().contains("אין תוצאות לשאילתת חיפוש שלך") && search.length() <= 128 && search.length() >= 3) {
				test1.pass("test pass");
			} else {
				test1.fail("tast fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
			Thread.sleep(1000);
			rows++;
		}
	}

	@Test(priority = 7)
	public void Num() throws InterruptedException, IOException, AWTException {
		// search the product
		pof.search.clear();
		pof.search.sendKeys("4564654556");
		pof.submit.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// test if products is found
		resuleTest2(driver.findElement(By.xpath("//p[@class='note-msg']")).getText(), "אין תוצאות לשאילתת חיפוש שלך");
		Thread.sleep(1000);
	}

	@Test(priority = 1)
	public void space() throws InterruptedException, IOException, AWTException {
		// search the product
		pof.search.sendKeys("   ");
		pof.submit.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// test if products is found
		if (driver.getTitle().equals("ספרים זה סטימצקי | ספרים באינטרנט קונים באתר סטימצקי")) {
			test1.pass("test pass");
		} else {
			test1.fail("tast fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
		Thread.sleep(1000);
	}

	@Test(priority = 8, enabled = true)
	public void clean_search_field() throws IOException, InterruptedException, AWTException {
		pof.search.clear();
		int rows = 0;
		while (rows <= 30) {
			// read from excel file
			String value = Product_value(rows, 0, "Product_search");
			Thread.sleep(500);
			// search the value
			pof.search.sendKeys(value);
			pof.submit.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String search = pof.search.getAttribute("value");
			// test if search field is clear
			if (search.equals("מה תרצו לקנות היום?")) {
				test1.pass("test pass");
				// if product not found
			} else if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText().contains("אין תוצאות לשאילתת חיפוש שלך")) {
				test1.info("product not found");
				pof.search.clear();
			} else {
				test1.fail("test fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
			Thread.sleep(1000);
			rows++;
		}
	}
}
