package elements;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import ID.elelments_id;
import Tools.Extent_reports;
import Tools.func;

public class Navigation_bar extends func {

	static elelments_id pof = new elelments_id();

	public static void NavigationBar(WebDriver driver, ExtentTest test, Extent_reports exm, Actions actions)
			throws AWTException, IOException {
		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("-------- sales link test --------");
			// Get link text and click on the link
			pof.sales.click();
			// Check if page title is equal to link text
			pageTitleTest(pof.sales.getText(), driver.findElement(By.className("pageTitle")).getText(), exm, test);
		} catch (Exception e) {
			test.fail("The test of sales link test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("-------- mCategorys links test --------");
			for (int i = 0; i < pof.mCategory.size(); i++) {
				String topItemString = pof.mCategory.get(i).getText();
				actions.moveToElement(pof.mCategory.get(i)).click().perform();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Check if page title is equal to link text
				if (topItemString.equals("מועדון לקוחות")) {
					pageTitleTest("חברות במועדון הקוראים של סטימצקי - הסיפור שלי",
							driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText(), exm, test);
				} else {
					pageTitleTest(topItemString, driver.findElement(By.className("pageTitle")).getText(), exm, test);
				}
			}
		} catch (Exception e) {
			test.fail("The test of mCategorys links test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("-------- books subCategory links test --------");
			for (int i = 0; i < pof.books_subCategory.size(); i++) {
				// move to books category
				actions.moveToElement(pof.books).perform();
				// click on sub-category
				// Get link text and click on the link
				String subcatagoryString = pof.books_subCategory.get(i).getText();
				actions.moveToElement(pof.books_subCategory.get(i)).click().perform();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// if open new tab
				if (tabs2.size() == 2) {
					driver.switchTo().window(tabs2.get(1));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					// Check if the browser in right page
					pageTitleTest(driver.getTitle(), "ספרים דיגיטליים בעברית להורדה", exm, test);
					driver.close();
					driver.switchTo().window(tabs2.get(0));
				} else if (tabs2.size() == 1) {
					// Check if the browser in right page
					pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//div[@id='content']/h1")).getText(),
							exm, test);
				}
			}
		} catch (Exception e) {
			test.fail("The test of books subCategory links test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("-------- English Books subCategory links test --------");
			for (int i = 0; i < pof.ebooks_subCategory.size(); i++) {
				actions.moveToElement(pof.Ebooks).perform();
				// Get link text and click on the link
				String subcatagoryString = pof.ebooks_subCategory.get(i).getText();
				actions.moveToElement(pof.ebooks_subCategory.get(i)).click().perform();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Check if page title is equal to link text
				pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText(), exm, test);
			}
		} catch (Exception e) {
			test.fail("The test of english books subCategory links test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("--------Games subCategory links test --------");
			actions.moveToElement(pof.games).perform();
			// Get link text and click on the link
			String subcatagoryString = pof.Subgames.getText();
			actions.moveToElement(pof.Subgames).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText(), exm, test);
		} catch (Exception e) {
			test.fail("The test of games subCategory links test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();

		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("-------- Gifts and leisure subCategory links test --------");
			for (int i = 0; i < pof.Gifts_and_leisure_subCategory.size(); i++) {
				actions.moveToElement(pof.Gifts_and_leisure).perform();
				// Get link text and click on the link
				String subcatagoryString = pof.Gifts_and_leisure_subCategory.get(i).getText();
				actions.moveToElement(pof.Gifts_and_leisure_subCategory.get(i)).click().perform();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Check if page title is equal to link text
				pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText(), exm, test);
			}
		} catch (Exception e) {
			test.fail("The test of Gifts and leisure subCategory links test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("-------- Music subCategory links test --------");
			for (int i = 0; i < pof.music_subCategory.size(); i++) {
				actions.moveToElement(pof.music).perform();
				// Get link text and click on the link
				String subcatagoryString = pof.music_subCategory.get(i).getText();
				actions.moveToElement(pof.music_subCategory.get(i)).click().perform();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Check if page title is equal to link text
				pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1[@class='pageTitle']")).getText(),exm, test);
			}
		} catch (Exception e) {
			test.fail("The test of music subCategory links test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("-------- Appliances subCategory links test --------");
			for (int i = 0; i < pof.Appliances_subCategory.size(); i++) {
				actions.moveToElement(pof.Appliances).perform();
				// Get link text and click on the link
				String subcatagoryString = pof.Appliances_subCategory.get(i).getText();
				actions.moveToElement(pof.Appliances_subCategory.get(i)).click().perform();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Check if page title is equal to link text
				pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText(), exm, test);
			}
		} catch (Exception e) {
			test.fail("The test of appliances subCategory links test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("-------- Smartphones subCategory links test --------");
			for (int i = 0; i < pof.Smartphones_subCategory.size(); i++) {
				actions.moveToElement(pof.Smartphones).perform();
				// Get link text and click on the link
				String subcatagoryString = pof.Smartphones_subCategory.get(i).getText();
				actions.moveToElement(pof.Smartphones_subCategory.get(i)).click().perform();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Check if page title is equal to link text
				pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText(), exm, test);
			}
		} catch (Exception e) {
			test.fail("The test of smartphones subCategory links test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("-------- Cosmetics and perfumes subCategory links test --------");
			for (int i = 0; i < pof.Cosmetics_and_perfumes_subCategory.size(); i++) {
				actions.moveToElement(pof.Cosmetics_and_perfumes).perform();
				// Get link text and click on the link
				String subcatagoryString = pof.Cosmetics_and_perfumes_subCategory.get(i).getText();
				actions.moveToElement(pof.Cosmetics_and_perfumes_subCategory.get(i)).click().perform();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Check if page title is equal to link text
				pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText(), exm, test);
			}
		} catch (Exception e) {
			test.fail("The test of cosmetics and perfumes subCategory links test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("-------- HOME subCategory links test --------");
			for (int i = 0; i < pof.home_subCategory.size(); i++) {
				actions.moveToElement(pof.HOME).perform();
				// Get link text and click on the link
				String subcatagoryString = pof.home_subCategory.get(i).getText();
				actions.moveToElement(pof.home_subCategory.get(i)).click().perform();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Check if page title is equal to link text
				pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText(), exm, test);
			}
		} catch (Exception e) {
			test.fail("The test of HOME subCategory links test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("-------- Camping subCategory links test --------");
			for (int i = 0; i < pof.camping_subCategory.size(); i++) {
				actions.moveToElement(pof.camping).perform();
				// Get link text and click on the link
				String subcatagoryString = pof.camping_subCategory.get(i).getText();
				actions.moveToElement(pof.camping_subCategory.get(i)).click().perform();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Check if page title is equal to link text
				pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText(), exm, test);
			}
		} catch (Exception e) {
			test.fail("The test of camping subCategory links test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}
		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("-------- Costumers club_subCategory links test --------");
			for (int i = 0; i < pof.club_subCategory.size(); i++) {
				actions.moveToElement(pof.club).perform();
				// Get link text and click on the link
				String subcatagoryString = pof.club_subCategory.get(i).getText();
				pof.club_subCategory.get(i).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Check if page title is equal to link text
				if (subcatagoryString.equals("חברות במועדון")) {
					pageTitleTest(driver.findElement(By.xpath("//div/h1")).getText(),
							"חברות במועדון הקוראים של סטימצקי - הסיפור שלי", exm, test1);
				} else if (subcatagoryString.equals("תקנון המועדון")) {
					pageTitleTest(driver.findElement(By.xpath("//div/h1")).getText(), "תקנון מועדון הקוראים של סטימצקי",
							exm, test);
				} else if (subcatagoryString.equals("הפרטים שלי")) {
					pageTitleTest(driver.findElement(By.xpath("//div/h1")).getText(), "מועדון לקוחות סטימצקי", exm,
							test);
				} else {
					pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//div/h1")).getText(), exm, test);
				}
			}
		} catch (Exception e) {
			test.fail("The test of costumers club subCategory links test fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

	}
}