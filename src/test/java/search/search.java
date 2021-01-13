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

	public static void Search(WebDriver driver, ExtentTest test1, Extent_reports exm) {

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test1.info("---- space ------");
			// search the product
			String titleString=driver.getTitle();
			pof.search.clear();
			pof.search.sendKeys("   ");
			pof.submit.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// test if products is found
			if (driver.getTitle().equals(titleString)) {
				test1.pass("test pass");
			} else {
				test1.fail("tast fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test1.info("---- keyword------");
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
				if (driver.findElement(By.xpath("//h1")).getText().contains("������ �����")) {
					resuleTest3(pof.product_grid, value, exm);
				} else if (driver.findElement(By.xpath("//div[@id='product-info']/h1[@class='productTitle']"))
						.isDisplayed()) {
					resuleTest(driver.getTitle(), value, exm);
				} else {
					test1.fail("the search of " + value + "not found products",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test1.info("---- authorTitle------");
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
				if (driver.findElement(By.xpath("//h1")).getText().contains("������ �����")) {
					resuleTest3(pof.authorTitle, value, exm);
				} else if (driver.findElement(By.xpath("//div[@id='product-info']/h1[@class='productTitle']"))
						.isDisplayed()) {
					resuleTest(driver.getTitle(), value, exm);
				} else {
					test1.fail("the search of " + value + "not found products",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test1.info("---- EauthorTitle------");
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
				if (driver.findElement(By.xpath("//h1")).getText().contains("������ �����")) {
					resuleTest3(pof.authorTitle, value, exm);
				} else if (driver.findElement(By.xpath("//div[@id='product-info']/h1[@class='productTitle']"))
						.isDisplayed()) {
					resuleTest(driver.getTitle(), value, exm);
				} else {
					test1.fail("the search of " + value + "not found products",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}

				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test1.info("---- Nagative------");
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
						.contains("��� ������ ������� ����� ���")) {
					test1.pass("test pass");
				} else {
					test1.fail("tast fail",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test1.info("---- Boundary ------");
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
						.contains("��� ������ ������� ����� ���") && search.length() <= 128 && search.length() >= 3) {
					test1.pass("test pass");
				} else {
					test1.fail("tast fail",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test1.info("---- num ------");
			// search the product
			pof.search.clear();
			pof.search.sendKeys("4564654556");
			pof.submit.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// test if products is found
			if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText()
					.contains("��� ������ ������� ����� ���")) {
				test1.pass("test pass");
			} else {
				test1.fail("tast fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test1.info("---- clean_search_field ------");
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
				if (search.equals("�� ���� ����� ����?")) {
					test1.pass("test pass");
				} else if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText()
						.contains("��� ������ ������� ����� ���")) {
					test1.info("not foun product");
					pof.search.clear();
				} else {
					test1.fail("test fail",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
				Thread.sleep(1000);
				rows++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
