package search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import ID.homepage_id;
import Tools.Extent_reports;
import Tools.func;
import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class search_product extends func {

	static String sheet = "Product_search";
	static homepage_id pof = new homepage_id();

	public static void searchProduct(WebDriver driver, ExtentTest test1, Extent_reports exm) {

		pof = PageFactory.initElements(driver, homepage_id.class);

		try {
			test1.info("---------books search----------- ");
			int rows = 0;
			while (rows <= 58) {
				// read from excel file
				String value = Product_value(rows, 0, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if product is found
				resuleTest(driver.getTitle(), value, exm);
				Thread.sleep(1000);
				rows++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			test1.info("---------English Books search----------- ");
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
				// test if product is found
				resuleTest(driver.getTitle(), value, exm);
				Thread.sleep(1000);
				rows++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			test1.info("---------Games toys and puzzles search----------- ");
			int rows = 0;
			while (rows <= 5) {
				// read from excel file
				String value = Product_value(rows, 2, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if product is found
				resuleTest(driver.getTitle(), value, exm);
				Thread.sleep(1000);
				rows++;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			test1.info("---------Gifts and leisure search----------- ");
			int rows = 0;
			while (rows <= 13) {
				// read from excel file
				String value = Product_value(rows, 3, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if product is found
				resuleTest(driver.getTitle(), value, exm);
				Thread.sleep(1000);
				rows++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			test1.info("---------music search----------- ");
			int rows = 0;
			while (rows <= 6) {
				// read from excel file
				String value = Product_value(rows, 4, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if product is found
				resuleTest(driver.getTitle(), value, exm);
				Thread.sleep(1000);
				rows++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			test1.info("---------Appliances and smartphones search----------- ");
			int rows = 0;
			while (rows <= 10) {
				// read from excel file
				String value = Product_value(rows, 5, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if product is found
				resuleTest(driver.getTitle(), value, exm);
				Thread.sleep(1000);
				rows++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			test1.info("---------Cosmetics and perfumes search----------- ");
			int rows = 0;
			while (rows <= 5) {
				// read from excel file
				String value = Product_value(rows, 6, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if product is found
				resuleTest(driver.getTitle(), value, exm);
				Thread.sleep(1000);
				rows++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			test1.info("---------Home and camping----------- ");
			int rows = 0;
			while (rows <= 11) {
				// read from excel file
				String value = Product_value(rows, 7, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if product is found
				resuleTest(driver.getTitle(), value, exm);
				Thread.sleep(1000);
				rows++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
