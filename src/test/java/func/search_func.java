package func;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Tools.Extent_reports;

public abstract class search_func {

	public static WebDriver driver;
	public static Extent_reports exm = new Extent_reports(driver);
	public static ExtentTest test1;
	public static ExtentReports extent;

	public void resuleTest(String titleString, String value) throws IOException, AWTException {
		if (titleString.contains(value)) {
			test1.pass("the product " + value + " is found");
		} else {
			test1.fail("the product not " + value + " is found",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
	}

	@SuppressWarnings("resource")
	public XSSFSheet getsheet() throws IOException {
		FileInputStream fis3 = new FileInputStream("search - test.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet("Product_search");
		return sheet;
	}

}
