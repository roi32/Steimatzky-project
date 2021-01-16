package Tools;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class func extends setUp {

	public static String getData(String nodeName) throws ParserConfigurationException, SAXException, IOException {
		File fXmlFile = new File("C:\\test\\configurtion\\configurtion.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}

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
	public static String value(int rows, int cell, String sheets) throws IOException {
		FileInputStream fis3 = new FileInputStream("search - test.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis3);
		XSSFSheet sheet = wb.getSheet(sheets);
		XSSFRow row_r = sheet.getRow(rows);
		XSSFCell cell_r = row_r.getCell(cell);
		String value = cell_r.getStringCellValue();
		return value;
	}

	public static void resuleTest(String titleString, String value, String Description,Extent_reports exm, ExtentTest test)
			throws IOException, AWTException {
		if (titleString.contains(value)) {
			test.pass("Test pass of -  " +Description);
		} else {
			test.fail("Test fail of -  " +Description,
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
			test.pass("all products contains :" + value);
		} else {
			test.fail("not all products contains :" + value,
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}

	}

}
