package Tools;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Extent_reports {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest test1;
	public static ExtentTest test2;
	public static ExtentTest test3;
	public static ExtentSparkReporter htmlReporter;
	public WebDriver driver;

	public Extent_reports(WebDriver driver) {
		this.driver = driver;
	}

	static DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	static Date today = Calendar.getInstance().getTime();
	static String reportDate = df.format(today);
	public static String filePath = "C:\\" + reportDate + "\\exReport.html";

	public static ExtentReports GetExtent(String Title) {
		new File("C:\\" + reportDate).mkdirs();
		if (extent != null)
			return extent;
		extent = new ExtentReports();
		extent.attachReporter(getHtmlReporter(Title));
		return extent;
	}

	private static ExtentSparkReporter getHtmlReporter(String Title) {
		htmlReporter = new ExtentSparkReporter(filePath);
		htmlReporter.config().setDocumentTitle("Steimatzky");
		htmlReporter.config().setReportName(Title);
		htmlReporter.config().setEncoding("windows-1255");
		htmlReporter.config().setTheme(Theme.DARK);
		return htmlReporter;
	}

	public static ExtentTest createTest(String name, String description) {
		test = extent.createTest(name, description);
		return test;
	}

	public String CaptureScreen() throws AWTException, IOException {
		LocalDateTime now = LocalDateTime.now();
		String time = now.format(DateTimeFormatter.ofPattern("ddHHmmss"));
		String folderPath = (reportDate);
		String imagePath = "C:\\" + folderPath + "/pic" + time + ".jpg";
		Robot robot = new Robot();
		BufferedImage screenShot = robot
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(screenShot, "JPG", new File(imagePath));
		return imagePath;
	}

}
