package search;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import ID.elelments_id;
import Tools.Extent_reports;
import Tools.func;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class search extends func {
	static String fileString="search - test.xlsx";
	static String sheet = "text_search";
	static elelments_id pof = new elelments_id();

	public static void Search(WebDriver driver, ExtentTest test, Extent_reports exm) throws AWTException, IOException {

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("---- Spaces ------");
			// search the product
			String titleString = driver.getTitle();
			pof.search.clear();
			pof.search.sendKeys("   ");
			pof.submit.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// test if products is found
			if (driver.getTitle().equals(titleString)) {
				test.pass("Test pass of spaces search");
			} else {
				test.fail("Test fail of spaces search",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			test.fail("The of search spaces fail ",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("---- Keywords ------");
			int rows = 0;

			while (rows <= 9) {
				// read from excel file
				String value = value(rows, 0, sheet,fileString);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if products is found
				if (driver.findElement(By.xpath("//h1")).getText().contains("תוצאות חיפוש")) {
					resuleTest2(pof.product_grid, value, exm, test2);
				} else if (driver.findElement(By.xpath("//div[@id='product-info']/h1[@class='productTitle']")).isDisplayed()) {
					String Description = "All products contains the " + value + "";
					resuleTest(driver.getTitle(), value, Description, exm, test);
				} else {
					test.fail("The search of " + value + "not found products",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			test.fail("The of search Keywords fail ",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}
		
		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("---- AuthorTitle ------");
			int rows = 0;
			while (rows <= 11) {
				// read from excel file
				String value = value(rows, 1, sheet,fileString);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if products is found
				if (driver.findElement(By.xpath("//h1")).getText().contains("תוצאות חיפוש")) {
					resuleTest2(pof.authorTitle, value, exm, test);
				} else if (driver.findElement(By.xpath("//div[@id='product-info']/h1[@class='productTitle']")).isDisplayed()) {
					String Description = "All products contains the " + value + "";
					resuleTest(driver.getTitle(), value, Description, exm, test);
				} else {
					test.fail("The search of " + value + " not found products",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			test.fail("The of search AuthorTitle fail ",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("---- EauthorTitle------");
			int rows = 0;
			while (rows <= 6) {
				// read from excel file
				String value = value(rows, 2, sheet,fileString);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if products is found
				if (driver.findElement(By.xpath("//h1")).getText().contains("תוצאות חיפוש")) {
					resuleTest2(pof.authorTitle, value, exm, test2);
				} else if (driver.findElement(By.xpath("//div[@id='product-info']/h1[@class='productTitle']")).isDisplayed()) {
					String Description = "All products contains the " + value + "";
					resuleTest(driver.getTitle(), value, Description, exm, test);
				} else {
					test.fail("the search of " + value + "not found products",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			test.fail("The of search EauthorTitle fail ",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("---- Nagative ------");
			int rows = 0;
			while (rows <= 7) {
				// read from excel file
				String value = value(rows, 3, sheet,fileString);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String Description = "The search of " + value + "";
				// test if products is found
				if (pof.note.getText().contains("Maximum words count is 10. In your search query was cut next part:")) {
					test.pass("You can not search more than 10 words");
				}else if (pof.note.getText().contains("אין תוצאות לשאילתת חיפוש שלך")) {
					test.pass(Description + " not found products");
				} else {
					test.fail(Description + " found products",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			test.fail("The Nagative search  fail ",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}
		
		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("---- Boundary ------");
			int rows = 0;
			while (rows <= 4) {
				// read from excel file
				String value = value(rows, 4, sheet,fileString);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				String search = pof.search.getAttribute("value");
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String Description = "The Boundary test with " + value + "";
				// test if products is found
				if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText().contains("אין תוצאות לשאילתת חיפוש שלך") && search.length() <= 128 && search.length() >= 3) {
					test.pass(Description + " pass");
				} else if (pof.note.getText().contains("אורך שאילתת חיפוש מינימלי הוא 3")) {
					test.pass("Minimum search query length is 3");
				}else {
					test.fail(Description + " fail",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			test.fail("The Boundary test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}
		
		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("---- Num ------");
			// search the product
			pof.search.clear();
			pof.search.sendKeys("4564654556");
			pof.submit.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// test if products is found
			if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText().contains("אין תוצאות לשאילתת חיפוש שלך")) {
				test.pass("Test pass of num search");
			} else {
				test.fail("Test fail of num search",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			test.fail("The Num test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("---- clean search field ------");
			pof.search.clear();
			int rows = 0;
			while (rows <= 30) {
				// read from excel file
				String value = value(rows, 0, "Product_search",fileString);
				Thread.sleep(500);
				// search the value
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String search = pof.search.getAttribute("value");
				// test if search field is clear
				if (search.equals("מה תרצו לקנות היום?")) {
					test.pass("The search field is cleared");
				} else if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText().contains("אין תוצאות לשאילתת חיפוש שלך")) {
					test.info("No product found");
					pof.search.clear();
				} else {
					test.fail("The search field is not cleared",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
					pof.search.clear();
				}
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			test.fail("The clean search field test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

	}
}
