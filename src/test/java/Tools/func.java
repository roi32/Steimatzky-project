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
import com.aventstack.extentreports.MediaEntityBuilder;

public class func extends setUp {

	static String Description = "home page";

	public static void pageTitleTest(String link, String pageTitle, Extent_reports exm)
			throws IOException, AWTException {
		if (link.equals(pageTitle)) {
			test.pass("you in " + pageTitle + " page");
		} else {
			test.fail("you not in " + pageTitle + " page",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}

	@SuppressWarnings("resource")
	public static String Product_value(int rows, int cell, String sheets) throws IOException {
		FileInputStream fis3 = new FileInputStream("search - test.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet(sheets);
		XSSFRow row_r = sheet.getRow(rows);
		XSSFCell cell_r = row_r.getCell(cell);
		String value = cell_r.getStringCellValue();
		return value;
	}

	public static void resuleTest(String titleString, String value, Extent_reports exm) throws IOException, AWTException {
		if (titleString.contains(value)) {
			test1.pass("the product " + value + " is found");
		} else {
			test1.fail("the product not " + value + " is found",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}

	public static void resuleTest3(List<WebElement> product_grid, String value, Extent_reports exm)
			throws IOException, AWTException {
		boolean check = true;
		for (int i = 0; i < product_grid.size(); i++) {
			if (!product_grid.get(i).getText().contains(value)) {
				check = false;
			}
		}

		if (check == true) {
			test1.pass("all products contains :" + value);
		} else {
			test1.fail("not all products contains :" + value,
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}

	}

}
