package search;

import org.testng.annotations.Test;

import Tools.Extent_reports;
import Tools.search_id;
import func.search_func;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class search extends search_func {

	static search_id pof;

	@BeforeClass
	public void beforeClass() {
		extent = Extent_reports.GetExtent();
		test1 = Extent_reports.createTest("name", "desc");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.steimatzky.co.il/");
	}

	@BeforeMethod
	public void BeforeMethod() {
		pof = new Tools.search_id();
		pof = PageFactory.initElements(driver, search_id.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		extent.flush();
		driver.close();

	}

	@Test(priority = 1, enabled = true)
	public void books() throws IOException, InterruptedException, AWTException {
		test1.info("---------books search----------- ");
		int rows = 0;
		while (rows <= 58) {
			// read from excel file
			XSSFRow row_r = getsheet().getRow(rows);
			XSSFCell cell_r = row_r.getCell(0);
			String value = cell_r.getStringCellValue();
			Thread.sleep(500);
			// search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			resuleTest(driver.getTitle(), value);
			Thread.sleep(1000);
			rows++;
		}
	}

	@Test(priority = 2, enabled = true)
	public void English_Books() throws IOException, InterruptedException, AWTException {
		test1.info("---------English Books search----------- ");
		int rows = 0;
		while (rows <= 11) {
			// read from excel file
			XSSFRow row_r = getsheet().getRow(rows);
			XSSFCell cell_r = row_r.getCell(1);
			String value = cell_r.getStringCellValue();
			Thread.sleep(500);
			// search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			resuleTest(driver.getTitle(), value);
			Thread.sleep(1000);
			rows++;
		}
	}

	@Test(priority = 3, enabled = true)
	public void Games_toys_and_puzzles() throws IOException, InterruptedException, AWTException {
		test1.info("---------Games toys and puzzles search----------- ");
		int rows = 0;
		while (rows <= 5) {
			// read from excel file
			XSSFRow row_r = getsheet().getRow(rows);
			XSSFCell cell_r = row_r.getCell(2);
			String value = cell_r.getStringCellValue();
			Thread.sleep(500);
			// search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			resuleTest(driver.getTitle(), value);
			Thread.sleep(1000);
			rows++;
		}
	}

	@Test(priority = 3, enabled = true)
	public void Gifts_and_leisure() throws IOException, InterruptedException, AWTException {
		test1.info("---------Gifts and leisure search----------- ");
		int rows = 0;
		while (rows <= 13) {
			// read from excel file
			XSSFRow row_r = getsheet().getRow(rows);
			XSSFCell cell_r = row_r.getCell(3);
			String value = cell_r.getStringCellValue();
			Thread.sleep(500);
			// search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			resuleTest(driver.getTitle(), value);
			Thread.sleep(1000);
			rows++;
		}
	}

	@Test(priority = 4, enabled = true)
	public void music() throws IOException, InterruptedException, AWTException {
		test1.info("---------music search----------- ");
		int rows = 0;
		while (rows <= 6) {
			// read from excel file
			XSSFRow row_r = getsheet().getRow(rows);
			XSSFCell cell_r = row_r.getCell(4);
			String value = cell_r.getStringCellValue();
			Thread.sleep(500);
			// search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			resuleTest(driver.getTitle(), value);
			Thread.sleep(1000);
			rows++;
		}
	}

	@Test(priority = 5, enabled = true)
	public void Appliances_and_smartphones() throws IOException, InterruptedException, AWTException {
		test1.info("---------Appliances and smartphones search----------- ");
		int rows = 0;
		while (rows <= 10) {
			// read from excel file
			XSSFRow row_r = getsheet().getRow(rows);
			XSSFCell cell_r = row_r.getCell(5);
			String value = cell_r.getStringCellValue();
			Thread.sleep(500);
			// search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			resuleTest(driver.getTitle(), value);
			Thread.sleep(1000);
			rows++;
		}
	}

	@Test(priority = 6, enabled = true)
	public void Cosmetics_and_perfumes() throws IOException, InterruptedException, AWTException {
		test1.info("---------Cosmetics and perfumes search----------- ");
		int rows = 0;
		while (rows <= 5) {
			// read from excel file
			XSSFRow row_r = getsheet().getRow(rows);
			XSSFCell cell_r = row_r.getCell(6);
			String value = cell_r.getStringCellValue();
			Thread.sleep(500);
			// search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			resuleTest(driver.getTitle(), value);
			Thread.sleep(1000);
			rows++;
		}
	}

	@Test(priority = 7, enabled = true)
	public void Home_and_camping() throws IOException, InterruptedException, AWTException {
		test1.info("---------Home and camping----------- ");
		int rows = 0;
		while (rows <= 11) {
			// read from excel file
			XSSFRow row_r = getsheet().getRow(rows);
			XSSFCell cell_r = row_r.getCell(7);
			String value = cell_r.getStringCellValue();
			Thread.sleep(500);
			// search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			resuleTest(driver.getTitle(), value);
			Thread.sleep(1000);
			rows++;
		}
	}
}
