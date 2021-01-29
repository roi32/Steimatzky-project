package Pages;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import ID.my_account_id;
import Tools.Extent_reports;
import Tools.func;
import Tools.setUp;
import elements.login_user;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class my_account extends setUp {

	static String Title = "steimatzky - my account test";
	static Extent_reports exm = new Extent_reports(driver);
	static my_account_id pof;

	@BeforeClass
	public void beforeClass() {
		extent = Extent_reports.GetExtent(Title);
		test = Extent_reports.createTest("login test", "Correct Login - test");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
		actions = new Actions(driver);
	}

	@BeforeMethod
	public void BeforeMethod() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pof = new my_account_id();
		pof = PageFactory.initElements(driver, my_account_id.class);
	}

	@AfterClass
	public void afterClass() {
		extent.flush();
		driver.quit();
	}

	@Test(priority = 1)
	public void login() throws IOException, AWTException {
		login_user.Login(Title, exm, test, actions);
	}

	@Test(priority = 2)
	public void Account_Control_Panel() throws IOException, AWTException {
		pof.loginbox.click();
		func.pageTitleTest("החשבון שלי", driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText(), exm,
				test);
		if (pof.welcome_msg.getText().contains("שלום, רועי יצחק")) {
			test.pass("test pass");
		} else {
			test.fail("test fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}

		if (pof.accountDetailes.getText().contains("רועי יצחק\n" + "roi.steimatzky@gmail.com")) {
			test.pass("test pass");
		} else {
			test.fail("test fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}

	@Test(priority = 3)
	public void Account_Detailes() throws AWTException, IOException {
		pof.right_sidebar.get(0).click();
		func.pageTitleTest("ערוך פרטי חשבון", driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText(),
				exm, test);
		if (pof.customer_name.get(0).getAttribute("value").contains("רועי")
				&& pof.customer_name.get(1).getAttribute("value").contains("יצחק")) {
			test.pass("test pass");
		} else {
			test.fail("test fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}

		if (pof.email.getAttribute("value").contains("roi.steimatzky@gmail.com")) {
			test.pass("test pass");
		} else {
			test.fail("test fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}

		if (pof.phone_num.getAttribute("value").contains("0525254545")) {
			test.pass("test pass");
		} else {
			test.fail("test fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
		pof.gender.click();
		if (pof.selected.getText().contains("זכר")) {
			test.pass("test pass");
		} else {
			test.fail("test fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
		actions.moveToElement(pof.save).click().perform();
		if (pof.ajs_content.isEnabled() && pof.ajs_content.getText().contains("פרטי החשבון שלך נשמרו.")) {
			test.pass("test pass");
		} else {
			test.fail("test fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
		func.pageTitleTest("ערוך פרטי חשבון", driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText(),
				exm, test);
		pof.ajs_button.click();
		pof.right_sidebar.get(1).click();
	}

	@Test(priority = 4)
	public void address_book() throws IOException, AWTException {
		func.pageTitleTest("ספר הכתובות", driver.findElement(By.xpath("//h1")).getText(), exm, test);
		if (pof.address.getText().contains(
				"רועי יצחק\n" + "עמק החולה\n" + "9\n" + "מודיעין, 45645\n" + "Israel\n" + "טלפון: 0525254545")) {
			test.pass("test pass");
		} else {
			test.fail("test fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
		pof.right_sidebar.get(2).click();

	}

	@Test(priority = 5)
	public void my_orders() throws IOException, AWTException {
		func.pageTitleTest("ההזמנות שלי", driver.findElement(By.xpath("//h1")).getText(), exm, test);
		if (pof.address.getText().contains("אין לך הזמנות עדיין")) {
			test.pass("test pass");
		} else {
			test.fail("test fail", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
		pof.right_sidebar.get(3).click();

	}
}
