package elements;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import ID.elelments_id;
import Tools.Extent_reports;
import Tools.setUp;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Footer_link_test extends setUp {
	static Actions actions;
	static JavascriptExecutor js;
	static elelments_id pof = new elelments_id();;
	static Extent_reports exm = new Extent_reports(driver);

	public static void Footer(WebDriver driver, ExtentTest test2, Extent_reports exm) {

		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test2.info("-------- About ------------");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			js.executeScript("window.scrollBy(0,250)", "");
			for (int i = 0; i < pof.about.size(); i++) {
				String aboutString = pof.about.get(i).getText();
				actions.moveToElement(pof.about.get(i)).click().perform();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if (tabs2.size() == 2) {
					driver.switchTo().window(tabs2.get(1));
					if (driver.getTitle().contains(aboutString)) {
						test2.pass("you in " + aboutString + " page");
					} else {
						test2.fail("you not in " + aboutString + " page");
					}
					driver.close();
					driver.switchTo().window(tabs2.get(0));
				} else if (driver.getTitle().contains(aboutString)) {
					test2.pass("you in " + aboutString + " page");
				} else if (aboutString.equals("סטימצקי לעסקים")) {
					if (driver.getTitle().contains("סטימצקי - המחלקה העסקית")) {
						test2.pass("you in " + aboutString + " page");
					} else {
						test2.fail("you not in " + aboutString + " page",
								MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
					}
				} else if (aboutString.equals("סניפים")) {
					Thread.sleep(2000);
					if (pof.Cpopup.isDisplayed()) {
						actions.moveToElement(pof.Cpopup).pause(10000).click().perform();
						if (driver.getTitle().contains("סניפים פתוחים")) {
							test2.pass("you in " + aboutString + " page");
						} else {
							test2.fail("you not in " + aboutString + " page",
									MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
						}
					}
				} else {
					test2.fail("you not in " + aboutString + " page",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test2.info("---------- Useful_information -----------");
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			for (int i = 0; i < pof.Useful_information.size(); i++) {
				String aboutString = pof.Useful_information.get(i).getText();
				actions.moveToElement(pof.Useful_information.get(i)).click().perform();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if (tabs2.size() == 2) {
					driver.switchTo().window(tabs2.get(1));
					if (aboutString.equals("בדיקת יתרת כרטיס מתנה")) {
						if (driver.getTitle().contains("ברוכים הבאים לפרקסל כרטיסי מתנה")) {
							test2.pass("you in " + aboutString + " page");
						} else {
							test2.fail("you not in " + aboutString + " page",
									MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
						}
						driver.close();
						driver.switchTo().window(tabs2.get(0));
					}
				} else if (driver.getTitle().contains(aboutString)) {
					test2.pass("you in " + aboutString + " page");

				} else if (aboutString.equals("בלוג סטימצקי")) {
					if (driver.getTitle().contains("Blog")) {
						test2.pass("you in " + aboutString + " page");
					} else {
						test2.fail("you not in " + aboutString + " page",
								MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
					}
				} else if (aboutString.equals("מועדון הסיפור שלי")) {
					if (driver.getTitle().contains("חברות במועדון הקוראים של סטימצקי - הסיפור שלי")) {
						test2.pass("you in " + aboutString + " page");
					} else {
						test2.fail("you not in " + aboutString + " page",
								MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
					}

				} else if (aboutString.equals("צור קשר")) {
					if (driver.getTitle().contains("יצירת קשר")) {
						test2.pass("you in " + aboutString + " page");
					} else {
						test2.fail("you not in " + aboutString + " page",
								MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
					}
				} else {
					test2.fail("you not in " + aboutString + " page",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test2.info("-------------- Information_for_buyers_on_the_site ----------------");
			js.executeScript("window.scrollBy(0,10000)", "");
			for (int i = 0; i < pof.Information_for_buyers.size(); i++) {
				String aboutString = pof.Information_for_buyers.get(i).getText();
				actions.moveToElement(pof.Information_for_buyers.get(i)).click().perform();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if (driver.getTitle().contains(aboutString)) {
					test2.pass("you in " + aboutString + " page");

				} else if (aboutString.equals("מדיניות משלוחים")) {
					if (driver.getTitle().contains("תקנון משלוחים")) {
						test2.pass("you in " + aboutString + " page");
					} else {
						test2.fail("you not in " + aboutString + " page",
								MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
					}
				} else if (aboutString.equals("תקנונים")) {
					if (driver.getTitle().contains("תקנון מועדון לקוחות")) {
						test2.pass("you in " + aboutString + " page");
					} else {
						test2.fail("you not in " + aboutString + " page",
								MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
					}
				} else if (aboutString.equals("מדיניות החזרות מוצרים")) {
					if (driver.getTitle().contains("מדיניות החזרת מוצרים וביטולי עיסקאות")) {
						test2.pass("you in " + aboutString + " page");
					} else {
						test2.fail("you not in " + aboutString + " page",
								MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
					}
				} else {
					test2.fail("you not in " + aboutString + " page",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			test2.info("-------------facebook --------------");
			js.executeScript("window.scrollBy(0,10000)", "");
			actions.moveToElement(pof.facebook_link).click().perform();
			Thread.sleep(2000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().window(tabs2.get(1));
			if (driver.getTitle().contains("סטימצקי - דף הבית | פייסבוק")) {
				test2.pass("you in סטימצקי - דף הבית | פייסבוק page");
			} else {
				test2.fail("you not in סטימצקי - דף הבית | פייסבוק page",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
