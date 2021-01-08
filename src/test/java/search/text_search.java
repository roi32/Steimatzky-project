package search;

import org.testng.annotations.Test;

import ID.search_id;
import Tools.search_func;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class text_search extends search_func {
	static search_id pof;
	static String sheet = "text_search";

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		// driver.manage().window().maximize();
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
			for (int i = 0; i < pof.product_grid.size(); i++) {
				if (pof.product_grid.get(i).getText().contains(value)) {
					System.out.println("the result contain " + value);
				} else {
					System.err.println("the result not contain " + value);
				}
			}
			Thread.sleep(1000);
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
				for (WebElement authorTitle : pof.authorTitle) {
					if (authorTitle.getText().contains(value)) {
						System.out.println("the result contain " + value);
					} else {
						System.err.println("the result not contain " + value);
					}
				}
			} else {
				driver.navigate().back();
				System.err.println("the result not contain " + value);
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
				for (WebElement EauthorTitle : pof.authorTitle) {
					if (EauthorTitle.getText().contains(value)) {
						System.out.println("the result contain " + value);
					} else {
						System.err.println("the result not contain " + value);
					}
				}
			} else {
				driver.navigate().back();
				System.err.println("the result not contain " + value);
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
			if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText()
					.contains("אין תוצאות לשאילתת חיפוש שלך")) {
				System.out.println("test pass");
			} else {
				System.err.println("tast fail");
			}
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
			if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText()
					.contains("אין תוצאות לשאילתת חיפוש שלך") && search.length() <= 128 && search.length() >= 3) {
				System.out.println("test pass");
			} else {
				System.err.println("tast fail");
			}
			Thread.sleep(1000);
			rows++;
		}
	}

	@Test(priority = 7)
	public void Num() throws InterruptedException {
		// search the product
		pof.search.clear();
		pof.search.sendKeys("4564654556");
		pof.submit.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// test if products is found
		if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText().contains("אין תוצאות לשאילתת חיפוש שלך")) {
			System.out.println("test pass");
		} else {
			System.err.println("tast fail");
		}
		Thread.sleep(1000);
	}

	@Test(priority = 1)
	public void space() throws InterruptedException {
		// search the product
		pof.search.clear();
		pof.search.sendKeys("   ");
		pof.submit.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// test if products is found
		if (driver.getTitle().equals("ספרים זה סטימצקי | ספרים באינטרנט קונים באתר סטימצקי")) {
			System.out.println("test pass");
		} else {
			System.err.println("tast fail");
		}
		Thread.sleep(1000);
	}

	@Test(priority = 8, enabled = true)
	public void books() throws IOException, InterruptedException, AWTException {
		int rows = 0;
		while (rows <= 30) {
			// read from excel file
			String value = Product_value(rows, 0, "Product_search");
			Thread.sleep(500);
			// search the product
			pof.search.sendKeys(value);
			pof.submit.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String search = pof.search.getAttribute("value");
			// test if product is found
			try {

				if (search.equals("מה תרצו לקנות היום?")) {
					System.out.println("test pass");
				} else {
					System.err.println("test fail");
				}
			} catch (Exception e) {
				if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText()
						.contains("אין תוצאות לשאילתת חיפוש שלך")) {
					pof.search.clear();
				}
			}

			Thread.sleep(1000);
			rows++;
		}
	}
}
