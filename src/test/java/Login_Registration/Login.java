package Login_Registration;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.MediaEntityBuilder;

import ID.Login_Registration_id;
import Tools.Extent_reports;
import Tools.func;
import Tools.setUp;
import elements.login_user;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class Login extends setUp {

	static String fileString = "Login_Registration - test.xlsx";
	static String Title = "steimatzky - login test";
	static Extent_reports exm = new Extent_reports(driver);
	static Login_Registration_id pof;

	@BeforeClass
	public void beforeClass() {
		extent = Extent_reports.GetExtent(Title);
		test = Extent_reports.createTest("login test", "Correct Login - test");
		test1 = Extent_reports.createTest("login test", "Negative Login - test");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
		actions = new Actions(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pof = new Login_Registration_id();
		pof = PageFactory.initElements(driver, Login_Registration_id.class);

	}

	@AfterClass
	public void afterClass() {
		extent.flush();
		driver.quit();
	}

	@Test(priority = 1)
	public void Correct_Login() throws IOException, AWTException {
		// Check if user is login
		login_user.Login(Title, exm, test, actions);
	}

	@Test(priority = 2, dependsOnMethods = { "Correct_Login" })
	public void logout() throws AWTException, IOException {
		pof.logout.click();
		// Check if user is logout
		if (pof.login.getText().equals("התחברות")) {
			test.pass("Logout verified");
		} else {
			test.fail("Logout not verified",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}

	@Test(priority = 3)
	public void Empty_text_fields() throws InterruptedException, AWTException, IOException {
		actions.moveToElement(pof.login).click().perform();
		Thread.sleep(1000);
		// click on login
		actions.moveToElement(pof.send2).click().perform();
		// Check if error massages is displayed
		if (pof.error_email.isDisplayed() && pof.error_email.getText().equals("שדה זה הינו חובה.")) {
			test1.pass("The email error massage is displayed");
		} else {
			test1.fail("The email error massage is not displayed",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
		if (pof.error_pass.isDisplayed() && pof.error_pass.getText().equals("שדה זה הינו חובה.")) {
			test1.pass("The password error massage is displayed");
		} else {
			test1.fail("The password error massage is not displayed",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
		Thread.sleep(1000);
	}

	@Test(priority = 4)
	public void worng_email() throws IOException, AWTException, InterruptedException {
		int rows = 0;
		pof.pass.sendKeys("123456");
		while (rows <= 3) {
			pof.email.clear();
			pof.email.sendKeys(func.value(rows, 1, "login", fileString));
			pof.send2.click();
			Thread.sleep(2000);
			if (pof.error_email2.isDisplayed()
					&& pof.error_email2.getText().equals("נראה שנפלה טעות בכתובת הדוא\"ל. אנא בדקו ונסו שוב")) {
				test1.pass("The email error massage is displayed");
			} else {
				test1.fail("The email error massage is not displayed",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
			rows++;
		}

	}

	@Test(priority = 5)
	public void worng_pass()
			throws IOException, InterruptedException, AWTException, ParserConfigurationException, SAXException {
		int rows = 0;
		pof.email.clear();
		pof.email.sendKeys(func.getData("email"));
		while (rows <= 3) {
			pof.pass.clear();
			pof.pass.sendKeys(func.value(rows, 1, "login", fileString));
			pof.send2.click();
			Thread.sleep(2000);
			if (pof.error_pass2.isDisplayed()
					&& pof.error_pass2.getText().equals("נראה שנפלה טעות בהקשת הסיסמה . אנא בדקו ונסו שוב.")) {
				test1.pass("The password error massage is displayed");
			} else if (pof.ajs_button.isDisplayed()) {
				pof.ajs_button.click();
				pof.email.sendKeys(func.getData("email"));
				test1.pass("The password error massage is displayed in windows");
			} else {
				test1.fail("The password error massage is not displayed",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
			rows++;
		}

	}
}
