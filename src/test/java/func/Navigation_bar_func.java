package func;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Tools.Extent_reports;
import Tools.Navigation_bar_id;

public abstract class Navigation_bar_func {
	public static WebDriver driver;

	public static ExtentReports extent;
	public static ExtentTest test;
	public static Navigation_bar_id pof;
	public static Extent_reports exm = new Extent_reports(driver);

	public static void pageTitleTest(String link, String pageTitle) throws IOException, AWTException {
		if (link.equals(pageTitle)) {
			test.pass("you in " + pageTitle + " page");
		} else {
			test.fail("you not in " + pageTitle + " page",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen(driver)).build());
		}
	}

}
