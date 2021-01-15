package search;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import ID.elelments_id;
import Tools.Extent_reports;
import Tools.func;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class search extends func {

	static String sheet = "text_search";
	static elelments_id pof = new elelments_id();

	public static void Search(WebDriver driver, ExtentTest test, Extent_reports exm) {

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
			e.printStackTrace();
		}

		try {
			test.info("---- Keyword ------");
			int rows = 0;

			while (rows <= 9) {
				// read from excel file
				String value = value(rows, 0, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if products is found
				if (driver.findElement(By.xpath("//h1")).getText().contains("������ �����")) {
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
			e.printStackTrace();
		}

		try {
			test.info("---- AuthorTitle ------");
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
				// test if products is found
				if (driver.findElement(By.xpath("//h1")).getText().contains("������ �����")) {
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
			e.printStackTrace();
		}

		try {
			test.info("---- EauthorTitle------");
			int rows = 0;
			while (rows <= 6) {
				// read from excel file
				String value = value(rows, 2, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// test if products is found
				if (driver.findElement(By.xpath("//h1")).getText().contains("������ �����")) {
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
			e.printStackTrace();
		}

		try {
			test.info("---- Nagative ------");
			int rows = 0;
			while (rows <= 6) {
				// read from excel file
				String value = value(rows, 3, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String Description = "The search of " + value + "";
				// test if products is found
				if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText().contains("��� ������ ������� ����� ���")) {
					test.pass(Description + " not found products");
				} else {
					test.fail(Description + " not found products",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test.info("---- Boundary ------");
			int rows = 0;
			while (rows <= 3) {
				// read from excel file
				String value = value(rows, 4, sheet);
				Thread.sleep(500);
				// search the product
				pof.search.clear();
				pof.search.sendKeys(value);
				String search = pof.search.getAttribute("value");
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String Description = "The Boundary test with " + value + "";
				// test if products is found
				if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText().contains("��� ������ ������� ����� ���") && search.length() <= 128 && search.length() >= 3) {
					test.pass(Description + " pass");
				} else {
					test.fail(Description + " fail",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test.info("---- Num ------");
			// search the product
			pof.search.clear();
			pof.search.sendKeys("4564654556");
			pof.submit.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// test if products is found
			if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText().contains("��� ������ ������� ����� ���")) {
				test.pass("Test pass of num search");
			} else {
				test.fail("Test fail of num search",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test.info("---- clean_search_field ------");
			pof.search.clear();
			int rows = 0;
			while (rows <= 30) {
				// read from excel file
				String value = value(rows, 0, "Product_search");
				Thread.sleep(500);
				// search the value
				pof.search.sendKeys(value);
				pof.submit.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String search = pof.search.getAttribute("value");
				// test if search field is clear
				if (search.equals("�� ���� ����� ����?")) {
					test.pass("The search field is cleared");
				} else if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText().contains("��� ������ ������� ����� ���")) {
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
			e.printStackTrace();
		}

	}
}
