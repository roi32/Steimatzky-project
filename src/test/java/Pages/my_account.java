package Pages;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import GUI.Runner;
import ID.my_account_id;
import Tools.Extent_reports;
import Tools.func;
import Tools.setUp;
import elements.Footer_Buttom;
import elements.Navigation_bar;
import elements.login_user;
import io.github.bonigarcia.wdm.WebDriverManager;
import search.search;
import search.search_product;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class my_account extends setUp {

	static String Title = "steimatzky - My account pages test";
	static Extent_reports exm = new Extent_reports(driver);
	static my_account_id pof;

	@BeforeClass
	public void beforeClass() {
		extent = Extent_reports.GetExtent(Title);
		test = Extent_reports.createTest("My account", "My account pages - test");
		test1 = Extent_reports.createTest("My account", "Navigation Bar - test");
		test2 = Extent_reports.createTest("My account", "Search - test");
		test3 = Extent_reports.createTest("My account", "footer - test");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/customer/account/");
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
		Runner.label3.setText("My account test ended");
		driver.quit();
	}

	@Test(priority = 1, groups = "elements")
	public void login() throws IOException, AWTException {
		test.info("---------- login to user -----------");
		login_user.Login(Title, exm, test, actions);
	}

	@Test(priority = 2, groups = "my account", dependsOnMethods = { "login" })
	public void Account_Control_Panel() throws IOException, AWTException {
		test.info("---------- Account Control Panel page test -----------");
		pof.loginbox.click();
		func.pageTitleTest("החשבון שלי", driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText(), exm,
				test);
		String Description;
		Description = "The subtitle contains the message";
		func.resuleTest(pof.subtitle.getText(), "אנחנו שמחים לראותך כלקוח בחנות שלנו", Description, exm, test);
		Description = "If the default shipping address is correct in Account Control Panel page";
		func.resuleTest(pof.address_Account_Control_Panel.getText(),
				"רועי יצחק\n" + "עמק החולה\n" + "9\n" + "מודיעין, 45645\n" + "Israel\n" + "טלפון: 0525254545",
				Description, exm, test);
		Description = "The second title contains the full name of the user";
		func.resuleTest(pof.welcome_msg.getText(), "שלום, רועי יצחק", Description, exm, test);
		Description = "Checking details for contacting the customer";
		func.resuleTest(pof.accountDetailes.getText(), "רועי יצחק\n" + "roi.steimatzky@gmail.com", Description, exm,
				test);
	}

	@Test(priority = 3, groups = "my account", dependsOnMethods = { "login" }, enabled = true)
	public void Account_Details() throws AWTException, IOException {
		test.info("---------- Account Details page test -----------");
		pof.right_sidebar.get(0).click();
		func.pageTitleTest("ערוך פרטי חשבון", driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText(),
				exm, test);
		String Description;
		Description = "The subtitle contains the message";
		func.resuleTest(pof.subtitle.getText(), "פרטי החשבון", Description, exm, test);
		if (pof.customer_name.get(0).getAttribute("value").contains("רועי")
				&& pof.customer_name.get(1).getAttribute("value").contains("יצחק")) {
			test.pass("test pass of - first name and last name fields");
		} else {
			test.fail("test fail of - first name and last name fields",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
		Description = "If the email is correct it appears in the email field";
		func.resuleTest(pof.email.getAttribute("value"), "roi.steimatzky@gmail.com", Description, exm, test);
		Description = "If the phone number is correct it appears in the phone number field";
		func.resuleTest(pof.phone_num.getAttribute("value"), "0525254545", Description, exm, test);
		pof.gender.click();
		Description = "If the correct gender appears in the gender field";
		func.resuleTest(pof.selected.getText(), "זכר", Description, exm, test);
		actions.moveToElement(pof.save).click().perform();
		Description = "If it appears in the window that the account information has been saved";
		func.resuleTest3(pof.ajs_content.getText(), "פרטי החשבון שלך נשמרו.", pof.ajs_content, Description, exm, test);
		pof.ajs_button.click();
		func.pageTitleTest("החשבון שלי", driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText(), exm,
				test);
		pof.right_sidebar.get(1).click();
	}

	// WIP
	@Test(priority = 4, groups = "my account", dependsOnMethods = { "login" }, enabled = true)
	public void Address_book() throws IOException, AWTException {
		test.info("---------- Address book page test -----------");
		func.pageTitleTest("ספר הכתובות", driver.findElement(By.xpath("//h1")).getText(), exm, test);
		String Description;
		Description = "If the correct text appears in the first subtitle";
		func.resuleTest(pof.subtitles.get(0).getText(), "כתובות ברירת מחדל", Description, exm, test);
		Description = "If the default shipping address is correct";
		func.resuleTest(pof.address.getText(),
				"רועי יצחק\n" + "עמק החולה\n" + "9\n" + "מודיעין, 45645\n" + "Israel\n" + "טלפון: 0525254545",
				Description, exm, test);
		Description = "If the correct text appears in the second subtitle";
		func.resuleTest(pof.subtitles.get(1).getText(), "כתובות נוספות", Description, exm, test);
		Description = "If the additional shipping address is correct";
		func.resuleTest(pof.addresses_additional.getText(),
				"רועי יצחק\n" + "נחל עיון\n" + "8\n" + "מודיעין, 45645\n" + "Israel\n" + "טלפון: 0525275545",
				Description, exm, test);
		pof.right_sidebar.get(2).click();

	}

	@Test(priority = 5, groups = "my account", dependsOnMethods = { "login" }, enabled = true)
	public void My_orders() throws IOException, AWTException {
		test.info("---------- My orders page test -----------");
		func.pageTitleTest("ההזמנות שלי", driver.findElement(By.xpath("//h1")).getText(), exm, test);
		String Description = "If there are no orders";
		func.resuleTest(pof.content.getText(), "אין לך הזמנות עדיין", Description, exm, test);
		pof.right_sidebar.get(3).click();
	}

	@Test(priority = 6, groups = "my account", dependsOnMethods = { "login" }, enabled = true)
	public void Club() throws IOException, AWTException {
		test.info("---------- Club test -----------");
		func.pageTitleTest("מועדון לקוחות סטימצקי", driver.findElement(By.xpath("//h1")).getText(), exm, test);
		String Description;
		Description = "The subtitle contains the message";
		func.resuleTest(pof.subtitle.getText(), "הצטרף למועדון!", Description, exm, test);
		Description = "The text of of content is correct";
		func.resuleTest(pof.content2.getText(), "אינך חבר מועדון סטימצקי. לחץ כאן לרכישת חברות במועדון", Description,
				exm, test);
		actions.moveToElement(pof.orderDetails).click().perform();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		func.pageTitleTest("חברות במועדון הקוראים של סטימצקי - הסיפור שלי ",
				driver.findElement(By.xpath("//h1")).getText(), exm, test);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		actions.moveToElement(pof.createClub).click().perform();
		Description = "If it appears in the window that you need to purchase a club card to become a club member";
		func.resuleTest3(pof.ajs_content2.getText(),
				"כרטיס החבר התווסף לעגלת הקניות שלך, על מנת להשלים את ההצטרפות למועדון החברים של סטימצקי יש לסיים את תהליך התשלום",
				pof.ajs_content2, Description, exm, test);
		actions.moveToElement(pof.ajs_button2).click().perform();
	}

	@Test(priority = 7, groups = "my account", dependsOnMethods = { "login" }, enabled = true)
	public void Cart() throws IOException, AWTException {
		test.info("---------- Cart test -----------");
		func.pageTitleTest("סל הקניות שלי", driver.findElement(By.xpath("//h1")).getText(), exm, test);
		String Description;
		Description = "If the title of procuct name appears on the shopping cart";
		func.resuleTest(pof.cart_titles.get(0).getText(), "שם המוצר", Description, exm, test);
		Description = "If the title of Catalog price appears on the shopping cart";
		func.resuleTest(pof.cart_titles.get(1).getText(), "מחיר קטלוגי", Description, exm, test);
		Description = "If the title of online price appears on the shopping cart";
		func.resuleTest(pof.cart_titles.get(2).getText(), "מחיר באתר", Description, exm, test);
		Description = "If the Club Member card appears on the shopping cart page";
		func.resuleTest(pof.product_name.getText(), "כרטיס חבר מועדון סטימצקי", Description, exm, test);
		Description = "If the title of quantity appears on the shopping cart";
		func.resuleTest(pof.titeqty.getText(), "כמות", Description, exm, test);
		Description = "If the number of club cards is 1";
		func.resuleTest(pof.qty.getAttribute("value"), "1", Description, exm, test);
		Description = "If the title of Subtotal price appears on the shopping cart";
		func.resuleTest(pof.pricetitle.getText(), "סך ביניים", Description, exm, test);
		Description = "If the price is right everywhere on the shopping cart page";
		func.resuleTest(pof.price.getText(), "29.90 ₪", Description, exm, test);
	}

	@Test(priority = 8, groups = "my account", dependsOnMethods = { "login" }, enabled = true)
	public void Popup_cart() throws AWTException, IOException {
		test.info("---------- Popup cart test -----------");
		actions.moveToElement(pof.top_cart_icon).perform();
		String Description;
		Description = "If the mini cart Title appears next to the mini cart";
		func.resuleTest(pof.minicartTitle.getText(), "סל הקניות שלי", Description, exm, test);
		Description = "If the correct quantity of products appears next to the cart icon";
		func.resuleTest(pof.num_cart.getText(), "1", Description, exm, test);
		Description = "If the Club Member card appears on the popup shopping cart page";
		func.resuleTest(pof.mini_cart_item.getAttribute("aria-label"), "כרטיס חבר מועדון סטימצקי", Description, exm,
				test);
		String priceString = pof.price2.getText() + pof.price3.getText();
		if (priceString.equals("29.90")) {
			test.pass("test pass of - price of Club Member card is correct");
		} else {
			test.fail("test fail of - price of Club Member card is correct",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
		Description = "If the number of club cards is 1";
		func.resuleTest(pof.prdQty.getText(), "1", Description, exm, test);
		pof.forPay.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		func.pageTitleTest("סל הקניות שלי", driver.findElement(By.xpath("//h1")).getText(), exm, test);
		pof.remove.click();
		Description = "If the club card is remove";
		func.resuleTest(pof.cart_empty.getText(), "סל הקניות שלך ריק", Description, exm, test);
		pof.loginbox.click();
		func.pageTitleTest("החשבון שלי", driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText(), exm,
				test);
		pof.right_sidebar.get(4).click();
	}

	@Test(priority = 9, groups = "my account", dependsOnMethods = { "login" }, enabled = true)
	public void Steimatzky_prime() throws IOException, AWTException {
		test.info("---------- Steimatzky prime page test -----------");
		func.pageTitleTest(driver.getTitle(), "סטימצקי PRIME", exm, test);
		String Description;
		Description = "The Description of Steimatzky prime page";
		func.resuleTest(pof.subtitle.getText(), "הצטרפו לחברות ב'סטימצקי PRIME'", Description, exm, test);
		Description = "The subtitle contains the message";
		func.resuleTest(pof.desc.getText(),
				"מצטרפים לסטימצקי PRIME באתר האינטרנט של סטימצקי ונהנים מהטבות שאסור לפספס!\n"
						+ "  במסגרת התכנית, חברי סטימצקי PRIME יהיו זכאים למספר הטבות:\n"
						+ "משלוחים חינם של כל ההזמנות שהם יבצעו באתר האינטרנט במהלך שנה קלנדרית אחת מיום ההצטרפות לתכנית.\n"
						+ "  הטבת יום הולדת – 15% כולל כפל מבצעים!\n" + "   לשאלות ופרטים service@steimatzky.co.il",
				Description, exm, test);
		pof.add_premium.click();
		Description = "If a page title is a Steimatzky Prime policy";
		func.resuleTest(pof.ajs_content2.getText(), "יש לאשר את קריאת תקנון 'סטימצקי PRIME'", Description, exm, test);
		pof.ajs_button2.click();
		pof.Steimatzkys_Prime.click();
		func.pageTitleTest("סטימצקי PRIME", driver.findElement(By.xpath("//div[@id='content']/div/p[1]")).getText(),
				exm, test);
	}

	@Test(priority = 10, groups = "elements", dependsOnMethods = { "login" }, enabled = false)
	public void Navigation_bar() throws AWTException, IOException {
		Navigation_bar.NavigationBar(driver, test1, exm, actions);
	}

	@Test(priority = 11, groups = "elements", enabled = false)
	public void SearchProduct() throws AWTException, IOException {
		search_product.searchProduct(driver, test2, exm);
	}

	@Test(priority = 12, groups = "elements", enabled = false)
	public void Search() throws IOException, InterruptedException, AWTException {
		search.Search(driver, test2, exm);
	}

	@Test(priority = 13, groups = "elements", dependsOnMethods = { "login" }, enabled = false)
	public void footer() throws AWTException, IOException {
		Footer_Buttom.Footer(driver, test3, exm, actions);
	}
}
