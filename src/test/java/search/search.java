package search;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import ID.homepage_id;
import Tools.Extent_reports;
import Tools.func;
import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class search extends func {
	static String sheet = "text_search";
	public static homepage_id pof = new homepage_id();

	public static void Search(WebDriver driver, ExtentTest test1, Extent_reports exm) throws IOException, InterruptedException, AWTException {

		pof = PageFactory.initElements(driver, homepage_id.class);

//		try {
//			test1.info("---- space ------");
//			// search the product
//			pof.search.clear();
//			pof.search.sendKeys("   ");
//			pof.submit.click();
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			// test if products is found
//			if (driver.getTitle().equals("ספרים זה סטימצקי | ספרים באינטרנט קונים באתר סטימצקי")) {
//				test1.pass("test pass");
//			} else {
//				test1.fail("tast fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
//			}
//			Thread.sleep(1000);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (AWTException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//			try {
//				test1.info("---- keyword------");
//				int rows = 0;
//			
//				while (rows <= 9) {
//					// read from excel file
//					String value = Product_value(rows, 0, sheet);
//					Thread.sleep(500);
//					// search the product
//					pof.search.clear();
//					pof.search.sendKeys(value);
//					pof.submit.click();
//					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//					// test if products is found
//					if (driver.findElement(By.xpath("//h1")).getText().contains("תוצאות חיפוש")) {
//						resuleTest3(pof.product_grid, value, exm);
//					} else if (driver.findElement(By.xpath("//div[@id='product-info']/h1[@class='productTitle']"))
//							.isDisplayed()) {
//						resuleTest(driver.getTitle(), value, exm);
//					} else {
//						test1.fail("the search of " + value + "not found products",
//								MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
//					}
//					Thread.sleep(1000);
//					rows++;
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (AWTException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
// 		try {
//			test1.info("---- authorTitle------");
//			int rows = 0;
//			while (rows <= 11) {
//				// read from excel file
//				String value = Product_value(rows, 1, sheet);
//				Thread.sleep(500);
//				// search the product
//				pof.search.clear();
//				pof.search.sendKeys(value);
//				pof.submit.click();
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				// test if products is found
//				if (driver.findElement(By.xpath("//h1")).getText().contains("תוצאות חיפוש")) {
//					resuleTest3(pof.authorTitle, value, exm);
//				} else if (driver.findElement(By.xpath("//div[@id='product-info']/h1[@class='productTitle']"))
//						.isDisplayed()) {
//					resuleTest(driver.getTitle(), value, exm);
//				} else {
//					test1.fail("the search of " + value + "not found products",
//							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
//				}
//				Thread.sleep(1000);
//				rows++;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			test1.info("---- EauthorTitle------");
//			int rows = 0;
//			while (rows <= 6) {
//				// read from excel file
//				String value = Product_value(rows, 2, sheet);
//				Thread.sleep(500);
//				// search the product
//				pof.search.clear();
//				pof.search.sendKeys(value);
//				pof.submit.click();
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				// test if products is found
//				if (driver.findElement(By.xpath("//h1")).getText().contains("תוצאות חיפוש")) {
//					resuleTest3(pof.authorTitle, value, exm);
//				} else if (driver.findElement(By.xpath("//div[@id='product-info']/h1[@class='productTitle']"))
//						.isDisplayed()) {
//					resuleTest(driver.getTitle(), value, exm);
//				} else {
//					test1.fail("the search of " + value + "not found products",
//							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
//				}
//
//				Thread.sleep(1000);
//				rows++;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			test1.info("---- Nagative------");
//			int rows = 0;
//			while (rows <= 6) {
//				// read from excel file
//				String value = Product_value(rows, 3, sheet);
//				Thread.sleep(500);
//				// search the product
//				pof.search.clear();
//				pof.search.sendKeys(value);
//				pof.submit.click();
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				// test if products is found
//				if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText()
//						.contains("אין תוצאות לשאילתת חיפוש שלך")) {
//					test1.pass("test pass");
//				} else {
//					test1.fail("tast fail",
//							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
//				}
//				Thread.sleep(1000);
//				rows++;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			test1.info("---- Boundary ------");
//			int rows = 0;
//			while (rows <= 3) {
//				// read from excel file
//				String value = Product_value(rows, 4, sheet);
//				Thread.sleep(500);
//				// search the product
//				pof.search.clear();
//				pof.search.sendKeys(value);
//				String search = pof.search.getAttribute("value");
//				pof.submit.click();
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				// test if products is found
//				if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText()
//						.contains("אין תוצאות לשאילתת חיפוש שלך") && search.length() <= 128 && search.length() >= 3) {
//					test1.pass("test pass");
//				} else {
//					test1.fail("tast fail",
//							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
//				}
//				Thread.sleep(1000);
//				rows++;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (AWTException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			test1.info("---- num ------");
//			// search the product
//			pof.search.clear();
//			pof.search.sendKeys("4564654556");
//			pof.submit.click();
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			// test if products is found
//			if (driver.findElement(By.xpath("//p[@class='note-msg']")).getText()
//					.contains("אין תוצאות לשאילתת חיפוש שלך")) {
//				test1.pass("test pass");
//			} else {
//				test1.fail("tast fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
//			}
//			Thread.sleep(1000);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (AWTException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

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

				if (search.equals("מה תרצו לקנות היום?")) {
					if (driver.findElement(By.xpath("//h1")).getText().contains("תוצאות חיפוש")) {
					} else if (driver.findElement(By.xpath("//div[@id='product-info']/h1[@class='productTitle']")).isDisplayed()) {
						resuleTest(driver.getTitle(), value, exm);
					} else {
						pof.search.clear();
						test1.fail("the search of " + value + "not found products",
								MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
					}
				}else {
					pof.search.clear();
					test1.fail("test fail",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
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
