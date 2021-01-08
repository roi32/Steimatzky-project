package Navigation_bar;

import org.testng.annotations.Test;

import ID.Navigation_bar_id;
import Tools.Extent_reports;
import Tools.Navigation_bar_func;
import io.github.bonigarcia.wdm.WebDriverManager;

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

public class Test_links extends Navigation_bar_func {

	static Actions actions;

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

	@BeforeMethod
	public void BeforeMethod() {
		pof = new Navigation_bar_id();
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
		for (int i = 0; i < pof.mCategory.size(); i++) {
			String topItemString = pof.mCategory.get(i).getText();
			actions.moveToElement(pof.mCategory.get(i)).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			if (topItemString.equals("מועדון לקוחות")) {
				pageTitleTest("חברות במועדון הקוראים של סטימצקי - הסיפור שלי",
						driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText());
			} else {
				pageTitleTest(topItemString, driver.findElement(By.className("pageTitle")).getText());
			}
		}
	}

	@Test(groups = "subCategory", priority = 3, enabled = true)
	public void books_subCategory() throws IOException, AWTException  {
		test.info("--------books_subCategory links test --------");
		for (int i = 0; i < pof.books_subCategory.size(); i++) {
			// move to books category
			actions.moveToElement(pof.books).perform();
			// click on sub-category
			// Get link text and click on the link
			String subcatagoryString = pof.books_subCategory.get(i).getText();
			actions.moveToElement(pof.books_subCategory.get(i)).click().perform();
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
			}
		}
	}

	@Test(groups = "subCategory", priority = 4, enabled = true)
	public void English_Books_subCategory() throws IOException, AWTException {
		test.info("--------English_Books_subCategory links test --------");
		for (int i = 0; i < pof.ebooks_subCategory.size(); i++) {
			actions.moveToElement(pof.Ebooks).perform();
			// Get link text and click on the link
			String subcatagoryString = pof.ebooks_subCategory.get(i).getText();
			actions.moveToElement(pof.ebooks_subCategory.get(i)).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());
		}
	}

	@Test(groups = "subCategory", priority = 5, enabled = true)
	public void games_subCategory() throws IOException, AWTException {
		test.info("--------games_subCategory links test --------");
		actions.moveToElement(pof.games).perform();
		// Get link text and click on the link
		String subcatagoryString = pof.Subgames.getText();
		actions.moveToElement(pof.Subgames).click().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Check if page title is equal to link text
		pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());
	}

	@Test(groups = "subCategory", priority = 6, enabled = true)
	public void Gifts_and_leisure_subCategory() throws IOException, AWTException {
		test.info("--------Gifts_and_leisure_subCategory links test --------");
		for (int i = 0; i < pof.Gifts_and_leisure_subCategory.size(); i++) {
			actions.moveToElement(pof.Gifts_and_leisure).perform();
			// Get link text and click on the link
			String subcatagoryString = pof.Gifts_and_leisure_subCategory.get(i).getText();
			actions.moveToElement(pof.Gifts_and_leisure_subCategory.get(i)).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());

		}
	}

	@Test(groups = "subCategory", priority = 7, enabled = true)
	public void music_subCategory() throws InterruptedException, IOException, AWTException {
		test.info("--------music_subCategory links test --------");
		for (int i = 0; i < pof.music_subCategory.size(); i++) {
			actions.moveToElement(pof.music).perform();
			// Get link text and click on the link
			String subcatagoryString = pof.music_subCategory.get(i).getText();
			actions.moveToElement(pof.music_subCategory.get(i)).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1[@class='pageTitle']")).getText());
		}
	}

	@Test(groups = "subCategory", priority = 8, enabled = true)
	public void Appliances_subCategory() throws IOException, AWTException {
		test.info("--------Appliances_subCategory links test --------");
		for (int i = 0; i < pof.Appliances_subCategory.size(); i++) {
			actions.moveToElement(pof.Appliances).perform();
			// Get link text and click on the link
			String subcatagoryString = pof.Appliances_subCategory.get(i).getText();
			actions.moveToElement(pof.Appliances_subCategory.get(i)).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());
		}
	}

	@Test(groups = "subCategory", priority = 9, enabled = true)
	public void Smartphones_subCategory() throws IOException, AWTException {
		test.info("--------Smartphones_subCategory links test --------");
		for (int i = 0; i < pof.Smartphones_subCategory.size(); i++) {
			actions.moveToElement(pof.Smartphones).perform();
			// Get link text and click on the link
			String subcatagoryString = pof.Smartphones_subCategory.get(i).getText();
			actions.moveToElement(pof.Smartphones_subCategory.get(i)).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());
		}
	}

	@Test(groups = "subCategory", priority = 10, enabled = true)
	public void Cosmetics_and_perfumes_subCategory() throws IOException, AWTException {
		test.info("--------Cosmetics_and_perfumes_subCategory links test --------");
		for (int i = 0; i < pof.Cosmetics_and_perfumes_subCategory.size(); i++) {
			actions.moveToElement(pof.Cosmetics_and_perfumes).perform();
			// Get link text and click on the link
			String subcatagoryString = pof.Cosmetics_and_perfumes_subCategory.get(i).getText();
			actions.moveToElement(pof.Cosmetics_and_perfumes_subCategory.get(i)).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());
		}
	}

	@Test(groups = "subCategory", priority = 11, enabled = true)
	public void HOME_subCategory() throws IOException, AWTException {
		test.info("--------HOME_subCategory links test --------");
		for (int i = 0; i < pof.home_subCategory.size(); i++) {
			actions.moveToElement(pof.HOME).perform();
			// Get link text and click on the link
			String subcatagoryString = pof.home_subCategory.get(i).getText();
			actions.moveToElement(pof.home_subCategory.get(i)).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());
		}
	}

	@Test(groups = "subCategory", priority = 12, enabled = true)
	public void camping_subCategory() throws IOException, AWTException {
		test.info("--------camping_subCategory links test --------");
		for (int i = 0; i < pof.camping_subCategory.size(); i++) {
			actions.moveToElement(pof.camping).perform();
			// Get link text and click on the link
			String subcatagoryString = pof.camping_subCategory.get(i).getText();
			actions.moveToElement(pof.camping_subCategory.get(i)).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Check if page title is equal to link text
			pageTitleTest(subcatagoryString, driver.findElement(By.xpath("//h1")).getText());
		}
	}

	@Test(groups = "subCategory", priority = 13, enabled = true)
	public void Costumers_club_subCategory() throws IOException, AWTException {
		test.info("--------Costumers_club_subCategory links test --------");
		for (int i = 0; i < pof.club_subCategory.size(); i++) {
			actions.moveToElement(pof.club).perform();
			// Get link text and click on the link
			String subcatagoryString = pof.club_subCategory.get(i).getText();
			pof.club_subCategory.get(i).click();
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
		}
	}
}