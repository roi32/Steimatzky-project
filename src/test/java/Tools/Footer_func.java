package Tools;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import ID.Footer_ID;

public abstract class Footer_func {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Footer_ID pof;
	public static Extent_reports exm = new Extent_reports(driver);

	public String getData(String nodeName) throws ParserConfigurationException, SAXException, IOException {
		File fXmlFile = new File("C:\\test\\configurtion\\configurtion.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}
}
