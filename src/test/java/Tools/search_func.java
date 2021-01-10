package Tools;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

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
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}

	@SuppressWarnings("resource")
	public String Product_value(int rows,int cell,String sheets) throws IOException {
		FileInputStream fis3 = new FileInputStream("search - test.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet(sheets);
		XSSFRow row_r = sheet.getRow(rows);
		XSSFCell cell_r = row_r.getCell(cell);
		String value = cell_r.getStringCellValue();
		return value;
	}

public void resuleTest2(String product_grid, String value) throws IOException, AWTException {
	if (product_grid.contains(value)) {
		test1.pass("the result contain " + value);
	}else {
		test1.fail("the result not contain " + value,
				MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
	}
	}


public void resuleTest3(List<WebElement> product_grid, String value) throws IOException, AWTException {
	for (int i = 0; i < product_grid.size(); i++) {
		if(!product_grid.get(i).getText().contains(value)) {
		test1.fail("not all products contains :"+value,MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}
	test1.pass("all products contains :"+value);
	}
}
