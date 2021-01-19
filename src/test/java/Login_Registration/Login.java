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
		test = Extent_reports.createTest("Home page", "Homepage - test");
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
		if (pof.loginbox.getText().equals("שלום רועי")) {
			test.pass("Login verified");
		} else {
			test.fail("Login not verified",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}

	@Test(priority = 2,dependsOnMethods = {"Correct_Login"})
	public void logout() throws AWTException, IOException {
		pof.logout.click();
		if (pof.login.getText().equals("התחברות")) {
			test.pass("Logout verified");
		}else {
			test.fail("Logout not verified",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}
}
