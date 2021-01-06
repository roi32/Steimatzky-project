package steimatzky_Navigation_bar;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
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

public class navi {
	public static void pageTitleTest(String link,String pageTitle) throws IOException, AWTException {
		if (link.equals(pageTitle)) {
			test.pass("you in " + pageTitle + " page");
		} else {
			test.fail("you not in " + pageTitle + " page",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
		
	}

	static WebDriver driver;
	static Actions actions;
	static ExtentReports extent;
	static ExtentTest test;
	static pofModle pof;
	static String saleString;
	static Extent_reports exm = new Extent_reports(driver);
	static WebElement topItem;
	static String topItemString;
	static String clubString;
	static WebElement subCatagory;
	static String subcatagoryString;
	static String pageTitleString;

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
		pof = new pofModle();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pof = PageFactory.initElements(driver, pofModle.class);
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
		saleString = pof.sales.getText();
		pof.sales.click();
	    pageTitleString=driver.findElement(By.className("pageTitle")).getText();
		// Check if page title is equal to link text
		pageTitleTest(saleString,pageTitleString );

	}

	@Test(groups = "mCategorys", priority = 2, enabled = true)
	public void mCategorys() throws IOException, AWTException {
		test.info("--------mCategorys links test --------");
		int mCategoryNum = 1;
		while (mCategoryNum < 13) {
			topItem = driver.findElement(By.xpath("//ul[@id='catMenu']/li[" + mCategoryNum + "]/a"));
			// Get link text and click on the link
			topItemString = topItem.getText();
			topItem.click();
			pageTitleString=driver.findElement(By.className("pageTitle")).getText();
			// Check if page title is equal to link text
			pageTitleTest(topItemString,pageTitleString );
			mCategoryNum++;
		}
	}

	@Test(groups = "mCategory", priority = 3, enabled = true)
	public void club() throws IOException, AWTException {
		test.info("--------club link test --------");
		// Get link text and click on the link
		clubString = "חברות במועדון הקוראים של סטימצקי - הסיפור שלי";
		pof.club.click();
		pageTitleString=driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
		// Check if page title is equal to link text
		pageTitleTest(clubString,pageTitleString );
	}

	@Test(groups = "subCategory", priority = 4, enabled = true)
	public void books_subCategory() throws IOException, AWTException, InterruptedException {
		test.info("--------books_subCategory links test --------");
		int clumNum = 1;
		while (clumNum <= 5) {
			int subcatagoryNum = 1;
			while (subcatagoryNum < 15) {
				// move to books category
				
				actions.moveToElement(pof.books).perform();
				// click on sub-category
				subCatagory = driver.findElement(By.xpath("//li[@id='menuCat-398']/div/ul/li[" + clumNum + "]/ul/li[" + subcatagoryNum + "]/a"));
				// Get link text and click on the link
				subcatagoryString = subCatagory.getText();
				subCatagory.click();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				Thread.sleep(3000);
				// if open new tab
				if (tabs2.size() == 2) {
					driver.switchTo().window(tabs2.get(1));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					// Check if the browser in right page
					pageTitleTest(driver.getTitle(),"ספרים דיגיטליים בעברית להורדה" );
					driver.close();
					driver.switchTo().window(tabs2.get(0));
					} else if (tabs2.size() == 1) {
					// Check if the browser in right page
						pageTitleTest(subcatagoryString,driver.findElement(By.xpath("//div[@id='content']/h1")).getText() );
					// stop the loop in last sub-category
					if (subcatagoryString.equals("משרדאות והנהלת חשבונות")) {
						pageTitleTest(subcatagoryString,driver.findElement(By.xpath("//div[@id='content']/h1")).getText() );
						break;
					}
				}
				subcatagoryNum++;
			}
			clumNum++;
		}
	}

	@Test(groups = "subCategory", priority = 5, enabled = true)
	public void English_Books_subCategory() throws IOException, AWTException{
		test.info("--------English_Books_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 7) {
			actions.moveToElement(pof.Ebooks).perform();
			subCatagory = driver.findElement(By.xpath("//ul[@id='catMenu']/li[2]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
		    subcatagoryString = subCatagory.getText();
			subCatagory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			pageTitleString=driver.findElement(By.xpath("//h1")).getText();
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString,pageTitleString );
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 6, enabled = true)
	public void games_subCategory() throws IOException, AWTException {
		test.info("--------games_subCategory links test --------");
		actions.moveToElement(pof.games).perform();
		// Get link text and click on the link
		subcatagoryString = pof.Subgames.getText();
		pof.Subgames.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pageTitleString=driver.findElement(By.xpath("//h1")).getText();
		// Check if page title is equal to link text
		pageTitleTest(subcatagoryString,pageTitleString );
	}

	@Test(groups = "subCategory", priority = 7, enabled = true)
	public void Gifts_and_leisure_subCategory() throws IOException, AWTException {
		test.info("--------Gifts_and_leisure_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 8) {
			actions.moveToElement(pof.Gifts_and_leisure).perform();
			subCatagory = driver.findElement(By.xpath("//ul[@id='catMenu']/li[6]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			subCatagory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			pageTitleString=driver.findElement(By.xpath("//h1")).getText();
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString,pageTitleString );
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 8, enabled = true)
	public void music_subCategory() throws InterruptedException, IOException, AWTException {
		test.info("--------music_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 8) {
			actions.moveToElement(pof.music).perform();
			subCatagory = driver.findElement(By.xpath("//ul[@id='catMenu']/li[7]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			subCatagory.click();
			pageTitleString=driver.findElement(By.xpath("//h1[@class='pageTitle']")).getText();
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString,pageTitleString );
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 9, enabled = true)
	public void Appliances_subCategory() throws IOException, AWTException {
		test.info("--------Appliances_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 4) {
			actions.moveToElement(pof.Appliances).perform();
			subCatagory = driver.findElement(By.xpath("//ul[@id='catMenu']/li[8]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			subCatagory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			pageTitleString=driver.findElement(By.xpath("//h1")).getText();
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString,pageTitleString );
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 10, enabled = true)
	public void Smartphones_subCategory() throws IOException, AWTException {
		test.info("--------Smartphones_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 2) {
			actions.moveToElement(pof.Smartphones).perform();
			 subCatagory = driver.findElement(By.xpath("//ul[@id='catMenu']/li[9]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			 subcatagoryString = subCatagory.getText();
			subCatagory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			pageTitleString=driver.findElement(By.xpath("//h1")).getText();
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString,pageTitleString );
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 11, enabled = true)
	public void Cosmetics_and_perfumes_subCategory() throws IOException, AWTException {
		test.info("--------Cosmetics_and_perfumes_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 3) {
			actions.moveToElement(pof.Cosmetics_and_perfumes).perform();
			 subCatagory = driver.findElement(By.xpath("//ul[@id='catMenu']/li[10]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			subCatagory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			pageTitleString=driver.findElement(By.xpath("//h1")).getText();
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString,pageTitleString );
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 12, enabled = true)
	public void HOME_subCategory() throws IOException, AWTException {
		test.info("--------HOME_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 5) {
			actions.moveToElement(pof.HOME).perform();
			subCatagory = driver.findElement(By.xpath("//ul[@id='catMenu']/li[11]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			subCatagory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			pageTitleString=driver.findElement(By.xpath("//h1")).getText();
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString,pageTitleString );
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 13, enabled = true)
	public void camping_subCategory() throws IOException, AWTException {
		test.info("--------camping_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 2) {
			actions.moveToElement(pof.camping).perform();
			subCatagory = driver.findElement(By.xpath("//ul[@id='catMenu']/li[12]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			subCatagory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			pageTitleString=driver.findElement(By.xpath("//h1")).getText();
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString,pageTitleString );
			subCategorynum++;
		}
	}

	@Test(groups = "subCategory", priority = 14, enabled = true)
	public void Costumers_club_subCategory() throws IOException, AWTException {
		test.info("--------Costumers_club_subCategory links test --------");
		int subCategorynum = 1;
		while (subCategorynum <= 4) {
			actions.moveToElement(pof.club).perform();
			subCatagory = driver.findElement(By.xpath("//ul[@id='catMenu']/li[13]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
			// Get link text and click on the link
			subcatagoryString = subCatagory.getText();
			subCatagory.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			if (subcatagoryString.equals("חברות במועדון")) {
				pageTitleTest(driver.findElement(By.xpath("//div/h1")).getText(),"חברות במועדון הקוראים של סטימצקי - הסיפור שלי" );
			} else if (subcatagoryString.equals("תקנון המועדון")) {
				pageTitleTest(driver.findElement(By.xpath("//div/h1")).getText(),"תקנון מועדון הקוראים של סטימצקי" );
			}else  {
				pageTitleTest(subcatagoryString,driver.findElement(By.xpath("//div/h1")).getText() );
			} 
			subCategorynum++;
		}
	}
}