package Tools;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class func extends setUp {

	public static void pageTitleTest(String link, String pageTitle, Extent_reports exm, ExtentTest test)
			throws IOException, AWTException {
		if (link.contains(pageTitle)) {
			test.pass("You in " + pageTitle + " page");
		} else {
			test.fail("You not in " + pageTitle + " page",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}

	@SuppressWarnings("resource")
	public static String value(int rows, int cell, String sheets, String fileString) throws IOException {
		FileInputStream fis3 = new FileInputStream(fileString);
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet(sheets);
		XSSFRow row_r = sheet.getRow(rows);
		XSSFCell cell_r = row_r.getCell(cell);
		String value = cell_r.getStringCellValue();
		return value;
	}

	public static void resuleTest(String titleString, String value, String Description, Extent_reports exm,
			ExtentTest test) throws IOException, AWTException {
		if (titleString.contains(value)) {
			test.pass("Test pass of -  " + Description);
		} else {
			test.fail("Test fail of -  " + Description,
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}

	public static void resuleTest2(List<WebElement> product_grid, String value, Extent_reports exm, ExtentTest test)
			throws IOException, AWTException {
		boolean check = true;
		for (int i = 0; i < product_grid.size(); i++) {
			if (!product_grid.get(i).getText().contains(value)) {
				check = false;
			}
		}

		if (check == true) {
			test.pass("All products contains :" + value);
		} else {
			test.fail("Not all products contains :" + value,
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}

	public static void validFeilds(WebElement error_email, WebElement error_pass, Extent_reports exm, ExtentTest test)
			throws AWTException, IOException {
		if (error_email.isDisplayed() && error_email.getText().equals("שדה זה הינו חובה.")) {
			test.pass("The email error massage is displayed");
		} else {
			test.fail("The email error massage is not displayed",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
		if (error_pass.isDisplayed() && error_pass.getText().equals("שדה זה הינו חובה.")) {
			test.pass("The password error massage is displayed");
		} else {
			test.fail("The password error massage is not displayed",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}

	public static void error_message(WebElement error_message, Extent_reports exm, ExtentTest test, String errorString)
			throws AWTException, IOException {
		if (error_message.isDisplayed() && error_message.getText().equals(errorString)) {
			test.pass("The email error massage is displayed");
		} else {
			test.fail("The email error massage is not displayed",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}

	public static void resuleTest3(String titleString, String value, WebElement Element, String Description,
			Extent_reports exm, ExtentTest test) throws IOException, AWTException {
		if (titleString.contains(value) && Element.isDisplayed()) {
			test.pass("Test pass of -  " + Description);
			test.info(Element.getText());
		} else {
			test.fail("Test fail of -  " + Description,
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}
//
}
