package Login_Registration;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import ID.Login_Registration_id;
import Tools.Extent_reports;
import Tools.setUp;
import elements.login_user;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class Login extends setUp {

	static String Title = "steimatzky - login test";
	static Extent_reports exm = new Extent_reports(driver);
	static Login_Registration_id pof;

	@BeforeClass
	public void beforeClass() {
		extent = Extent_reports.GetExtent(Title);
		test = Extent_reports.createTest("Home page", "Correct Login - test");
		test1 = Extent_reports.createTest("Home page", "Navigation bar - test");
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
		login_user.Login(Title, exm, test, actions);
		//Check if user is login
		if (pof.loginbox.getText().equals("שלום רועי")) {
			test.pass("Login verified");
		} else {
			test.fail("Login not verified",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}

	@Test(priority = 2, dependsOnMethods = { "Correct_Login" })
	public void logout() throws AWTException, IOException {
		pof.logout.click();
		//Check if user is logout
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
		//Check if error massage is displayed
		if (pof.error_email.isDisplayed() && pof.error_email.getText().equals("שדה זה הינו חובה.")) {
			test1.pass("The error massage is displayed");
		} else {
			test1.fail("The error massage is not displayed",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
		if (pof.error_pass.isDisplayed() && pof.error_pass.getText().equals("שדה זה הינו חובה.")) {
			test1.pass("The eror massage is displayed");
		} else {
			test1.fail("The eror massage is not displayed",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
		Thread.sleep(1000);

	}
}
