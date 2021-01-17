package search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import ID.elelments_id;
import Tools.Extent_reports;
import Tools.func;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class search_product extends func {

	static String sheet = "Product_search";
	static elelments_id pof = new elelments_id();

	public static void searchProduct(WebDriver driver, ExtentTest test, Extent_reports exm) throws AWTException, IOException {

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("--------- Books search ----------- ");
			int rows = 0;
			while (rows <= 58) {
				// read from excel file
				String value = value(rows, 0, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if product is found
				String Description = "The search of " + value + "";
				resuleTest(driver.getTitle(), value, Description, exm, test);
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			test.fail("The  search of books products fail ",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("--------- English Books search ----------- ");
			int rows = 0;
			while (rows <= 11) {
				// read from excel file
				String value = value(rows, 1, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if product is found
				String Description = "The search of " + value + "";
				resuleTest(driver.getTitle(), value, Description, exm, test);
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			test.fail("The  search of English books products fail ",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("--------- Games toys and puzzles search ----------- ");
			int rows = 0;
			while (rows <= 5) {
				// read from excel file
				String value = value(rows, 2, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if product is found
				String Description = "The search of " + value + "";
				resuleTest(driver.getTitle(), value, Description, exm, test);
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			test.fail("The  search of Games toys and puzzles products fail ",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("--------- Gifts and leisure search ----------- ");
			int rows = 0;
			while (rows <= 13) {
				// read from excel file
				String value = value(rows, 3, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if product is found
				String Description = "The search of " + value + "";
				resuleTest(driver.getTitle(), value, Description, exm, test);
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			test.fail("The  search of Gifts and leisure products fail ",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}
		
		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("--------- music search ----------- ");
			int rows = 0;
			while (rows <= 6) {
				// read from excel file
				String value = value(rows, 4, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if product is found
				String Description = "The search of " + value + "";
				resuleTest(driver.getTitle(), value, Description, exm, test);
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			test.fail("The  search of music products fail ",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}
		
		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("--------- Appliances and smartphones search ----------- ");
			int rows = 0;
			while (rows <= 10) {
				// read from excel file
				String value = value(rows, 5, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if product is found
				String Description = "The search of " + value + "";
				resuleTest(driver.getTitle(), value, Description, exm, test);
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			test.fail("The  search of Appliances and smartphones products fail ",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("--------- Cosmetics and perfumes search----------- ");
			int rows = 0;
			while (rows <= 5) {
				// read from excel file
				String value = value(rows, 6, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if product is found
				String Description = "The search of " + value + "";
				resuleTest(driver.getTitle(), value, Description, exm, test);
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			test.fail("The  search of Cosmetics and perfumes products fail ",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}
		
		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("--------- Home and camping ----------- ");
			int rows = 0;
			while (rows <= 11) {
				// read from excel file
				String value = value(rows, 7, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if product is found
				String Description = "The search of " + value + "";
				resuleTest(driver.getTitle(), value, Description, exm, test);
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			test.fail("The  search of Home and camping products fail ",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}
	}
}
