package func;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Tools.Extent_reports;
import Tools.search_id;

public abstract class search_func {
	public void resuleTest(String titleString, String value) throws IOException, AWTException {
		if (titleString.contains(value)) {
			test1.pass("the product " + value + " is found");
		} else {
			test1.fail("the product not " + value + " is found",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
	}

	public static WebDriver driver;
	public	static String value;
	public	static String path = "search - test.xlsx";
	public	static int rows;
	public	static String titleString;
	public	static search_id pof;
	public static Extent_reports exm = new Extent_reports(driver);
	public static ExtentTest test1;
	public static ExtentReports extent;

}
