package Footer;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import ID.Footer_ID;
import Tools.Footer_func;
import elements.login_user;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class link_test extends Footer_func {
	static Actions actions;
	static login_user login;
	static JavascriptExecutor js;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
		actions = new Actions(driver);
		login = new login_user() {
		};
		js = (JavascriptExecutor) driver;
	}

	@BeforeMethod
	public void BeforeMethod() {
		pof = new Footer_ID();
		pof = PageFactory.initElements(driver, Footer_ID.class);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test(priority = 1)
	public void About() {
		js.executeScript("window.scrollBy(0,10000)", "");
		for (int i = 0; i < pof.about.size(); i++) {
			String aboutString = pof.about.get(i).getText();
			actions.moveToElement(pof.about.get(i)).click().perform();
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (tabs2.size() == 2) {
				driver.switchTo().window(tabs2.get(1));
				if (driver.getTitle().contains(aboutString)) {
					System.out.println("you in " + aboutString + " page");
				} else {
					System.err.println("you not in " + aboutString + " page");
				}
				driver.close();
				driver.switchTo().window(tabs2.get(0));
			} else if (driver.getTitle().contains(aboutString)) {
				System.out.println("you in " + aboutString + " page");
			} else if (aboutString.equals("סטימצקי לעסקים")) {
				if (driver.getTitle().contains("סטימצקי - המחלקה העסקית")) {
					System.out.println("you in " + aboutString + " page");
				} else {
					System.err.println("you not in " + aboutString + " page");
				}
			} else if (aboutString.equals("סניפים")) {
				if (pof.popup.isDisplayed()) {
					actions.moveToElement(pof.popup).click().perform();

					if (driver.getTitle().contains("סניפים פתוחים")) {
						System.out.println("you in " + aboutString + " page");
					} else {
						System.err.println("you not in " + aboutString + " page");
					}
				}
			} else {
				System.err.println("you not in " + aboutString + " page");
			}

		}

	}

	@Test(priority = 2)
	public void Useful_information() {
		js.executeScript("window.scrollBy(0,10000)", "");
		for (int i = 0; i < pof.Useful_information.size(); i++) {
			String aboutString = pof.Useful_information.get(i).getText();
			actions.moveToElement(pof.Useful_information.get(i)).click().perform();
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (tabs2.size() == 2) {
				driver.switchTo().window(tabs2.get(1));
				if (aboutString.equals("בדיקת יתרת כרטיס מתנה")) {
					if (driver.getTitle().contains("ברוכים הבאים לפרקסל כרטיסי מתנה")) {
						System.out.println("you in " + aboutString + " page");
					} else {
						System.err.println("you not in " + aboutString + " page");
					}
					driver.close();
					driver.switchTo().window(tabs2.get(0));
				}
			} else if (driver.getTitle().contains(aboutString)) {
				System.out.println("you in " + aboutString + " page");

			} else if (aboutString.equals("בלוג סטימצקי")) {
				if (driver.getTitle().contains("Blog")) {
					System.out.println("you in " + aboutString + " page");
				} else {
					System.err.println("you not in " + aboutString + " page");
				}
			} else if (aboutString.equals("מועדון הסיפור שלי")) {
				if (driver.getTitle().contains("חברות במועדון הקוראים של סטימצקי - הסיפור שלי")) {
					System.out.println("you in " + aboutString + " page");
				} else {
					System.err.println("you not in " + aboutString + " page");
				}

			} else if (aboutString.equals("צור קשר")) {
				if (driver.getTitle().contains("יצירת קשר")) {
					System.out.println("you in " + aboutString + " page");
				} else {
					System.err.println("you not in " + aboutString + " page");
				}
			} else {
				System.err.println("you not in " + aboutString + " page");
			}
		}
	}

	// login for test all club subCategory
	@Test(priority = 3)
	public void Login() throws IOException, AWTException {
		try {
			actions.moveToElement(pof.login).click().perform();
			Thread.sleep(2000);
			// enter email and password
			pof.email.sendKeys(getData("email"));
			pof.pass.sendKeys(getData("pass"));
			// login for user
			actions.moveToElement(pof.send2).click().perform();
			Thread.sleep(2000);
			System.out.println("User login successful");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(dependsOnMethods = { "Login" }, priority = 4)
	public void Information_for_buyers_on_the_site() {
		js.executeScript("window.scrollBy(0,10000)", "");
		for (int i = 0; i < pof.Information_for_buyers.size(); i++) {
			String aboutString = pof.Information_for_buyers.get(i).getText();
			actions.moveToElement(pof.Information_for_buyers.get(i)).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (driver.getTitle().contains(aboutString)) {
				System.out.println("you in " + aboutString + " page");

			} else if (aboutString.equals("מדיניות משלוחים")) {
				if (driver.getTitle().contains("תקנון משלוחים")) {
					System.out.println("you in " + aboutString + " page");
				} else {
					System.err.println("you not in " + aboutString + " page");
				}
			} else if (aboutString.equals("תקנונים")) {
				if (driver.getTitle().contains("תקנון מועדון לקוחות")) {
					System.out.println("you in " + aboutString + " page");
				} else {
					System.err.println("you not in " + aboutString + " page");
				}

			} else if (aboutString.equals("מדיניות החזרות מוצרים")) {
				if (driver.getTitle().contains("מדיניות החזרת מוצרים וביטולי עיסקאות")) {
					System.out.println("you in " + aboutString + " page");
				} else {
					System.err.println("you not in " + aboutString + " page");
				}
			} else {
				System.err.println("you not in " + aboutString + " page");
			}
		}
	}
	
@Test(priority = 5)
public void facebook() throws InterruptedException {
	js.executeScript("window.scrollBy(0,10000)", "");
	actions.moveToElement(pof.facebook_link).click().perform();
	Thread.sleep(2000);
	ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.switchTo().window(tabs2.get(1));
	if (driver.getTitle().contains("סטימצקי - דף הבית | פייסבוק")) {
		System.out.println("you in סטימצקי - דף הבית | פייסבוק page");
	} else {
		System.err.println("you not in סטימצקי - דף הבית | פייסבוק page");
	}
	
}
}
