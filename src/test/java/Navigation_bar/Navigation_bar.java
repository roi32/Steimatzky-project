package Navigation_bar;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Tools.Extent_reports;
import Tools.Navigation_bar_id;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Navigation_bar {

	public static void pageTitleTest(String link, String pageTitle) throws IOException, AWTException {
		if (link.equals(pageTitle)) {
			test.pass("you in " + pageTitle + " page");
		} else {
			test.fail("you not in " + pageTitle + " page",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}

	}
	public static WebElement topItem(WebDriver driver,int mCategoryNum) {
		WebElement topItem =driver.findElement(By.xpath("//ul[@id='catMenu']/li[" + mCategoryNum + "]/a"));
		return topItem;
		
	}

	public static WebElement subCatagory(WebDriver driver,int mCategoryNum,int subCategorynum) {
		subCatagory = driver.findElement(By.xpath("//ul[@id='catMenu']/li["+mCategoryNum+"]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
		return subCatagory;
		
	}	
	public static WebElement books_subCategory(WebDriver driver,int clumNum,int subcatagoryNum) {
		subCatagory = driver.findElement(By.xpath("//li[@id='menuCat-398']/div/ul/li[" + clumNum + "]/ul/li[" + subcatagoryNum + "]/a"));
		return subCatagory;
		
	}

	static WebDriver driver;
	static Actions actions;
	public static ExtentReports extent;
	static ExtentTest test;
	public	static Navigation_bar_id pof;
    public	static Extent_reports exm = new Extent_reports(driver);
	static WebElement topItem;
	static String topItemString;
	static WebElement subCatagory;
	static String subcatagoryString;
	static int mCategoryNum;
	static int subCategoryNum;

	@BeforeClass
	public void beforeClass() {
		extent = Extent_reports.GetExtent();
		test = Extent_reports.createTest("name", "desc");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
		actions = new Actions(driver);
	}

	@AfterMethod
	public void AfterMethod() throws InterruptedException {
		Thread.sleep(2000);
	}

	@BeforeMethod
	public void BeforeMethod() {
		pof = new Navigation_bar_id();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pof = PageFactory.initElements(driver, Navigation_bar_id.class);
	}

	@AfterClass
	public void afterClass() {
		extent.flush();
		driver.close();
	}

	@Test(groups = "mCategory", priority = 1, enabled = true)
	public void sales() throws IOException, AWTException {
		test.info("--------sales link test --------");
		// Get link text and click on the link
		pof.sales.click();
		// Check if page title is equal to link text
		pageTitleTest(pof.sales.getText(), driver.findElement(By.className("pageTitle")).getText());

	}

	@Test(groups = "mCategorys", priority = 2, enabled = true)
	public void mCategorys() throws IOException, AWTException {
		test.info("--------mCategorys links test --------");
		mCategoryNum = 1;
		while (mCategoryNum < 13) {
			topItem = topItem(driver, mCategoryNum);
			// Get link text and click on the link
			topItemString = topItem.getText();
			topItem.click();
			// Check if page title is equal to link text
			pageTitleTest(topItemString, driver.findElement(By.className("pageTitle")).getText());
			mCategoryNum++;
		}
	}

	@Test(groups = "mCategory", priority = 3, enabled = true)
	public void club() throws IOException, AWTException {
		test.info("--------club link test --------");
		pof.club.click();
		// Check if page title is equal to link text
		pageTitleTest("חברות במועדון הקוראים של סטימצקי - הסיפור שלי", driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText());
	}

	@Test(groups = "subCategory", priority = 4, enabled = true)
	public void books_subCategory() throws IOException, AWTException, InterruptedException {
		test.info("--------books_subCategory links test --------");
		int clumNum = 1;
		while (clumNum <= 5) {
			subCategoryNum = 1;
			while (subCategoryNum < 15) {
				// move to books category
				actions.moveToElement(pof.books).perform();
				// click on sub-category
				subCatagory = books_subCategory(driver, clumNum, subCategoryNum);
				// Get link text and click on the link
				subcatagoryString = subCatagory.getText();
				actions.moveToElement(subCatagory).click().perform();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				Thread.sleep(3000);
				// if open new tab
				if (tabs2.size() == 2) {
					driver.switchTo().window(tabs2.get(1));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					// Check if the browser in right page
					pageTitleTest(driver.getTitle(), "ספרים דיגיטליים בעברית להורדה");
					driver.close();
					driver.switchTo().window(tabs2.get(0));
				} else if (tabs2.size() == 1) {
					// Check if the browser in right page
					pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//div[@id='content']/h1")).getText());
					// stop the loop in last sub-category
					if (subcatagoryString.equals("משרדאות והנהלת חשבונות")) {
						pageTitleTest(subcatagoryString,
								driver.findElement(By.xpath("//div[@id='content']/h1")).getText());
						break;
					}
				}
				subCategoryNum++;
			}
			clumNum++;
		}
	}

	@Test(groups = "subCategory", priority = 5, enabled = true)
	public void English_Books_subCategory() throws IOException, AWTException {
		test.info("--------English_Books_subCategory links test --------");
		mCategoryNum = 2;
		subCategoryNum = 1;
		while (subCategoryNum <= 7) {
			actions.moveToElement(pof.Ebooks).perform();
			subCatagory = subCatagory(driver, mCategoryNum, subCategoryNum);
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			actions.moveToElement(subCatagory).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());
			subCategoryNum++;
		}
	}

	@Test(groups = "subCategory", priority = 6, enabled = true)
	public void games_subCategory() throws IOException, AWTException {
		test.info("--------games_subCategory links test --------");
		actions.moveToElement(pof.games).perform();
		// Get link text and click on the link
		subcatagoryString = pof.Subgames.getText();	
		actions.moveToElement(pof.Subgames).click().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Check if page title is equal to link text
		pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());
	}

	@Test(groups = "subCategory", priority = 7, enabled = true)
	public void Gifts_and_leisure_subCategory() throws IOException, AWTException {
		test.info("--------Gifts_and_leisure_subCategory links test --------");
		mCategoryNum = 6;
		subCategoryNum = 1;
		while (subCategoryNum <= 8) {
			actions.moveToElement(pof.Gifts_and_leisure).perform();
			subCatagory =subCatagory(driver, mCategoryNum, subCategoryNum);
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			actions.moveToElement(subCatagory).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());
			subCategoryNum++;
		}
	}

	@Test(groups = "subCategory", priority = 8, enabled = true)
	public void music_subCategory() throws InterruptedException, IOException, AWTException {
		test.info("--------music_subCategory links test --------");
		mCategoryNum = 7;
		subCategoryNum = 1;
		while (subCategoryNum <= 8) {
			actions.moveToElement(pof.music).perform();
			subCatagory = subCatagory(driver, mCategoryNum, subCategoryNum);
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			actions.moveToElement(subCatagory).click().perform();
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1[@class='pageTitle']")).getText());
			subCategoryNum++;
		}
	}

	@Test(groups = "subCategory", priority = 9, enabled = true)
	public void Appliances_subCategory() throws IOException, AWTException {
		test.info("--------Appliances_subCategory links test --------");
		mCategoryNum = 8;
		subCategoryNum = 1;
		while (subCategoryNum <= 4) {
			actions.moveToElement(pof.Appliances).perform();
			subCatagory = subCatagory(driver, mCategoryNum, subCategoryNum);
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			actions.moveToElement(subCatagory).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());
			subCategoryNum++;
		}
	}

	@Test(groups = "subCategory", priority = 10, enabled = true)
	public void Smartphones_subCategory() throws IOException, AWTException {
		test.info("--------Smartphones_subCategory links test --------");
		mCategoryNum = 9;
		subCategoryNum = 1;
		while (subCategoryNum <= 2) {
			actions.moveToElement(pof.Smartphones).perform();
			subCatagory = subCatagory(driver, mCategoryNum, subCategoryNum);
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			actions.moveToElement(subCatagory).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());
			subCategoryNum++;
		}
	}

	@Test(groups = "subCategory", priority = 11, enabled = true)
	public void Cosmetics_and_perfumes_subCategory() throws IOException, AWTException {
		test.info("--------Cosmetics_and_perfumes_subCategory links test --------");
		mCategoryNum = 10;
		subCategoryNum = 1;
		while (subCategoryNum <= 3) {
			actions.moveToElement(pof.Cosmetics_and_perfumes).perform();
			subCatagory = subCatagory(driver, mCategoryNum, subCategoryNum);
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			actions.moveToElement(subCatagory).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());
			subCategoryNum++;
		}
	}

	@Test(groups = "subCategory", priority = 12, enabled = true)
	public void HOME_subCategory() throws IOException, AWTException {
		test.info("--------HOME_subCategory links test --------");
		mCategoryNum = 11;
		subCategoryNum = 1;
		while (subCategoryNum <= 5) {
			actions.moveToElement(pof.HOME).perform();
			subCatagory = subCatagory(driver, mCategoryNum, subCategoryNum);
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			actions.moveToElement(subCatagory).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());
			subCategoryNum++;
		}
	}

	@Test(groups = "subCategory", priority = 13, enabled = true)
	public void camping_subCategory() throws IOException, AWTException {
		test.info("--------camping_subCategory links test --------");
		mCategoryNum = 12;
		subCategoryNum = 1;
		while (subCategoryNum <= 2) {
			actions.moveToElement(pof.camping).perform();
			subCatagory = subCatagory(driver, mCategoryNum, subCategoryNum);
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			actions.moveToElement(subCatagory).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());
			subCategoryNum++;
		}
	}

	@Test(groups = "subCategory", priority = 14, enabled = true)
	public void Costumers_club_subCategory() throws IOException, AWTException {
		test.info("--------Costumers_club_subCategory links test --------");
		mCategoryNum = 13;
		subCategoryNum = 1;
		while (subCategoryNum <= 4) {
			actions.moveToElement(pof.club).perform();
			subCatagory = subCatagory(driver, mCategoryNum, subCategoryNum);
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			subCatagory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			if (subcatagoryString.equals("חברות במועדון")) {
				pageTitleTest(driver.findElement(By.xpath("//div/h1")).getText(),
						"חברות במועדון הקוראים של סטימצקי - הסיפור שלי");
			} else if (subcatagoryString.equals("תקנון המועדון")) {
				pageTitleTest(driver.findElement(By.xpath("//div/h1")).getText(), "תקנון מועדון הקוראים של סטימצקי");
			} else {
				pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//div/h1")).getText());
			}
			subCategoryNum++;
		}
	}
}