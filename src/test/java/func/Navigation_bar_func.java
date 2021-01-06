package func;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Tools.Extent_reports;
import Tools.Navigation_bar_id;

public abstract class Navigation_bar_func {
	public static void pageTitleTest(String link, String pageTitle) throws IOException, AWTException {
		if (link.equals(pageTitle)) {
			test.pass("you in " + pageTitle + " page");
		} else {
			test.fail("you not in " + pageTitle + " page",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}

	}

	public static WebElement topItem(WebDriver driver, int mCategoryNum) {
		WebElement topItem = driver.findElement(By.xpath("//ul[@id='catMenu']/li[" + mCategoryNum + "]/a"));
		return topItem;

	}

	public static WebElement subCatagory(WebDriver driver, int mCategoryNum, int subCategorynum) {
		subCatagory = driver.findElement(
				By.xpath("//ul[@id='catMenu']/li[" + mCategoryNum + "]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
		return subCatagory;

	}

	public static WebElement books_subCategory(WebDriver driver, int clumNum, int subcatagoryNum) {
		subCatagory = driver.findElement(
				By.xpath("//li[@id='menuCat-398']/div/ul/li[" + clumNum + "]/ul/li[" + subcatagoryNum + "]/a"));
		return subCatagory;

	}

	public	static WebDriver driver;
	public	static Actions actions;
	public static ExtentReports extent;
	public	static ExtentTest test;
	public static Navigation_bar_id pof;
	public static Extent_reports exm = new Extent_reports(driver);
	public	static WebElement topItem;
	public	static String topItemString;
	public static WebElement subCatagory;
	public static String subcatagoryString;
	public static int mCategoryNum;
	public static int subCategoryNum;

}
