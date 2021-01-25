package Login_Registration;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.MediaEntityBuilder;

import GUI.Runner;
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
		test2 = Extent_reports.createTest("login test", "Unregister email - test");
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
		Runner.label2.setText("Login test ended");
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
		test1.info("--------- Empty text fields test ---------");
		actions.moveToElement(pof.login).click().perform();
		Thread.sleep(1000);
		// click on login
		actions.moveToElement(pof.send2).click().perform();
		// Check if error massages is displayed
		func.validFeilds(pof.error_email, pof.error_pass, exm, test1);
		Thread.sleep(1000);
	}

	@Test(priority = 4)
	public void Enter_spaces_in_text_fields() throws InterruptedException, AWTException, IOException {
		test1.info("--------- Enter spaces in text fields test ---------");
		pof.email.sendKeys("  ");
		pof.pass.sendKeys("  ");
		// click on login
		actions.moveToElement(pof.send2).click().perform();
		// Check if error massages is displayed
		func.validFeilds(pof.error_email, pof.error_pass, exm, test1);
		Thread.sleep(1000);
	}

	@Test(priority = 5)
	public void worng_email() throws IOException, AWTException, InterruptedException {
		test1.info("--------- worng email test ---------");
		int rows = 0;
		pof.pass.sendKeys("123456");
		while (rows <= 3) {
			pof.email.clear();
			pof.email.sendKeys(func.value(rows, 1, "login", fileString));
			pof.send2.click();
			Thread.sleep(2000);
			func.error_message(pof.error_email2, exm, test1,"נראה שנפלה טעות בכתובת הדוא\"ל. אנא בדקו ונסו שוב");
			rows++;
		}
		Thread.sleep(1000);
	}

	@Test(priority = 6)
	public void worng_email_num() throws IOException, AWTException, InterruptedException {
		test1.info("--------- worng email num test ---------");
		pof.pass.sendKeys("123456");
		pof.email.clear();
		pof.email.sendKeys("1");
		pof.send2.click();
		Thread.sleep(2000);
		func.error_message(pof.error_email2, exm, test1,"נראה שנפלה טעות בכתובת הדוא\"ל. אנא בדקו ונסו שוב");
		Thread.sleep(1000);
	}

	@Test(priority = 7)
	public void worng_pass()
			throws IOException, InterruptedException, AWTException, ParserConfigurationException, SAXException {
		test1.info("--------- worng pass test ---------");
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
			} else if (pof.ajs_content.getText()
					.contains("נראה שנפלה טעות בכתובת הדוא\"ל או אולי הסיסמה. אנא בדקו ונסו שוב")) {
				test1.pass("The password error massage is displayed in windows");
				test1.pass(pof.ajs_content.getText());
				pof.ajs_button.click();
				pof.email.sendKeys(func.getData("email"));
			} else {
				test1.fail("The password error massage is not displayed",
						MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			}
			rows++;
		}
	}

	@Test(priority = 8)
	public void worng_pass_num()
			throws IOException, InterruptedException, AWTException, ParserConfigurationException, SAXException {
		test1.info("--------- worng pass num test ---------");
		pof.email.clear();
		pof.email.sendKeys(func.getData("email"));
		pof.pass.clear();
		pof.pass.sendKeys("1");
		pof.send2.click();
		Thread.sleep(2000);
		func.error_message(pof.error_pass2, exm, test1,"נראה שנפלה טעות בהקשת הסיסמה . אנא בדקו ונסו שוב." );
	}

	@Test(priority = 9)
	public void Unregister_email() throws AWTException, IOException, InterruptedException {
		test2.info("--------- Unregister email test ---------");
		pof.email.clear();
		pof.pass.clear();
		pof.email.sendKeys("roi@gmail.com");
		pof.pass.sendKeys("123456");
		pof.send2.click();
		if (pof.ajs_content.getText()
				.contains("לא נמצא חשבון באתר המשוייך לכתובת המייל שהוקלדה\n" + "אתה מוזמן להירשם, זה קל ומהיר!")) {
			test2.pass(("Error message username does not exist appears"));
			test2.pass((pof.ajs_content.getText()));
		} else {
			test2.fail("Error message username does not exist is not appears",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
		Thread.sleep(1000);
	}
}
