package Tools;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import ID.Navigation_bar_id;

public class homepage_func {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest test1;
	public static Navigation_bar_id pof;
	public static Extent_reports exm = new Extent_reports(driver);
	
	public static void pageTitleTest(String link, String pageTitle) throws IOException, AWTException {
		if (link.equals(pageTitle)) {
			test.pass("you in " + pageTitle + " page");
		} else {
			test.fail("you not in " + pageTitle + " page",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
		}
	}
	
	public String getData(String nodeName) throws ParserConfigurationException, SAXException, IOException {
		File fXmlFile = new File("C:\\test\\configurtion\\configurtion.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();
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

}
