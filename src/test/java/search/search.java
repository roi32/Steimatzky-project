package search;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Tools.Extent_reports;
import Tools.search_id;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class search {


	public void resuleTest(String titleString, String value) throws IOException, AWTException {
		if (titleString.contains(value)) {
			test1.pass("the product " + value + " is found");
		} else {
			test1.fail("the product not " + value + " is found",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
	}

	public static WebDriver driver;
	static String value;
	static String path = "search - test.xlsx";
	static int rows;
	static String titleString;
	static search_id pof;
	public static Extent_reports exm = new Extent_reports(driver);
	public	static ExtentTest test1;
	public	static ExtentReports extent;

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

	@SuppressWarnings("resource")
	@Test(priority = 1)
	public void books() throws IOException, InterruptedException, AWTException {
		test1.info("---------books search----------- ");
		// read from excel file
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 58) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(0);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			//search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			titleString = driver.getTitle();
			resuleTest(titleString, value);
			Thread.sleep(1000);
			rows++;
		}
	}

	@SuppressWarnings("resource")
	@Test(priority = 2)
	public void English_Books() throws IOException, InterruptedException, AWTException {
		test1.info("---------English Books search----------- ");
		// read from excel file
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 11) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(1);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			//search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			titleString = driver.getTitle();
			resuleTest(titleString, value);
			Thread.sleep(1000);
			rows++;
		}
	}

	@SuppressWarnings("resource")
	@Test(priority = 3)
	public void Games_toys_and_puzzles() throws IOException, InterruptedException, AWTException {
		test1.info("---------Games toys and puzzles search----------- ");
		// read from excel file
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 5) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(2);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			//search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			titleString = driver.getTitle();
			resuleTest(titleString, value);
			Thread.sleep(1000);
			rows++;
		}
	}

	@SuppressWarnings("resource")
	@Test(priority = 3)
	public void Gifts_and_leisure() throws IOException, InterruptedException, AWTException {
		test1.info("---------Gifts and leisure search----------- ");
		// read from excel file
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 13) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(3);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			//search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			titleString = driver.getTitle();
			resuleTest(titleString, value);
			Thread.sleep(1000);
			rows++;
		}
	}

	@SuppressWarnings("resource")
	@Test(priority = 4)
	public void music() throws IOException, InterruptedException, AWTException {
		test1.info("---------music search----------- ");
		// read from excel file
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 6) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(4);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			//search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			titleString = driver.getTitle();
			resuleTest(titleString, value);
			Thread.sleep(1000);
			rows++;
		}
	}

	@SuppressWarnings("resource")
	@Test(priority = 5)
	public void Appliances_and_smartphones() throws IOException, InterruptedException, AWTException {
		test1.info("---------Appliances and smartphones search----------- ");
		// read from excel file
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 10) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(5);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			//search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			titleString = driver.getTitle();
			resuleTest(titleString, value);
			Thread.sleep(1000);
			rows++;
		}
	}

	@SuppressWarnings("resource")
	@Test(priority = 6)
	public void Cosmetics_and_perfumes() throws IOException, InterruptedException, AWTException {
		test1.info("---------Cosmetics and perfumes search----------- ");
		// read from excel file
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 5) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(6);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			//search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			titleString = driver.getTitle();
			resuleTest(titleString, value);
			Thread.sleep(1000);
			rows++;
		}
	}

	@SuppressWarnings("resource")
	@Test(priority = 7)
	public void Home_and_camping() throws IOException, InterruptedException, AWTException {
		test1.info("---------Home and camping----------- ");
		// read from excel file
		FileInputStream fis3 = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		rows = 0;
		while (rows <= 11) {
			XSSFRow row_r = sheet.getRow(rows);
			XSSFCell cell_r = row_r.getCell(7);
			value = cell_r.getStringCellValue();
			Thread.sleep(500);
			//search the product
			pof.search.clear();
			pof.search.sendKeys(value);
			pof.submit.click();
			Thread.sleep(1000);
			// test if product is found
			titleString = driver.getTitle();
			resuleTest(titleString, value);
			Thread.sleep(1000);
			rows++;
		}
	}
}
