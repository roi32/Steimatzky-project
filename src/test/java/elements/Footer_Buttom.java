package elements;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import ID.elelments_id;
import Tools.Extent_reports;
import Tools.func;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Footer_Buttom extends func {

	static Actions actions;
	static JavascriptExecutor js;
	static elelments_id pof = new elelments_id();;

	public static void Footer(WebDriver driver, ExtentTest test, Extent_reports exm) {

		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("-------- About ------------");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			js.executeScript("window.scrollBy(0,250)", "");
			for (int i = 0; i < pof.about.size(); i++) {
				String aboutString = pof.about.get(i).getText();
				actions.moveToElement(pof.about.get(i)).click().perform();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				try {
					if (pof.Cpopup.isDisplayed()) {
						actions.moveToElement(pof.Cpopup).click().perform();
						Thread.sleep(2000);
					}
				} catch (Exception e) {
				}
				if (tabs2.size() == 2) {
					driver.switchTo().window(tabs2.get(1));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "הוצאה לאור:", exm, test);
					driver.close();
					driver.switchTo().window(tabs2.get(0));
				} else if (driver.getTitle().contains(aboutString)) {
					test.pass("you in " + aboutString + " page");
				} else if (aboutString.equals("סטימצקי לעסקים")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "סטימצקי - המחלקה העסקית", exm, test);
				} else if (aboutString.equals("סניפים")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "סניפים פתוחים", exm, test);
				} else {
					test.fail("you not in " + aboutString + " page",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test.info("---------- Useful_information -----------");
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			for (int i = 0; i < pof.Useful_information.size(); i++) {
				String aboutString = pof.Useful_information.get(i).getText();
				actions.moveToElement(pof.Useful_information.get(i)).click().perform();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if (tabs2.size() == 2) {
					driver.switchTo().window(tabs2.get(1));
					if (aboutString.equals("בדיקת יתרת כרטיס מתנה")) {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						pageTitleTest(driver.getTitle(), "ברוכים הבאים לפרקסל כרטיסי מתנה", exm, test);
						driver.close();
						driver.switchTo().window(tabs2.get(0));
					}
				} else if (driver.getTitle().contains(aboutString)) {
					test.pass("you in " + aboutString + " page");

				} else if (aboutString.equals("בלוג סטימצקי")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "Blog", exm, test);

				} else if (aboutString.equals("מועדון הסיפור שלי")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "חברות במועדון הקוראים של סטימצקי - הסיפור שלי", exm, test);
				} else if (aboutString.equals("צור קשר")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "יצירת קשר", exm, test);
				} else {
					test.fail("you not in " + aboutString + " page",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test.info("-------------- Information_for_buyers_on_the_site ----------------");
			js.executeScript("window.scrollBy(0,10000)", "");
			for (int i = 0; i < pof.Information_for_buyers.size(); i++) {
				String aboutString = pof.Information_for_buyers.get(i).getText();
				actions.moveToElement(pof.Information_for_buyers.get(i)).click().perform();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if (driver.getTitle().contains(aboutString)) {
					test.pass("you in " + aboutString + " page");
				} else if (aboutString.equals("מדיניות משלוחים")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "תקנון משלוחים", exm, test);
				} else if (aboutString.equals("תקנונים")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "תקנון מועדון לקוחות", exm, test);
				} else if (aboutString.equals("מדיניות החזרות מוצרים")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "מדיניות החזרת מוצרים וביטולי עיסקאות", exm, test);
				} else {
					test.fail("you not in " + aboutString + " page",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test.info("-------------facebook --------------");
			js.executeScript("window.scrollBy(0,10000)", "");
			actions.moveToElement(pof.facebook_link).click().perform();
			Thread.sleep(2000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().window(tabs2.get(1));
			if (driver.getTitle().contains("סטימצקי - דף הבית | פייסבוק")) {
				test.pass("you in סטימצקי - דף הבית | פייסבוק page");
			} else {
				test.fail("you not in סטימצקי - דף הבית | פייסבוק page",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
