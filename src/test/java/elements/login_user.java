package elements;

import java.awt.AWTException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.MediaEntityBuilder;

import ID.homepage_id;
import Tools.Extent_reports;
import Tools.setUp;

public class login_user extends setUp{
	static Actions actions;

	public static void Login( String Description,Extent_reports exm) throws IOException, AWTException {
		pof = new homepage_id();
		pof = PageFactory.initElements(driver, homepage_id.class);
		actions= new Actions(driver);
		try {
			actions.moveToElement(pof.login).click().perform();
			Thread.sleep(2000);
			// enter email and password
			pof.email.sendKeys(getData("email"));
			pof.pass.sendKeys(getData("pass"));
			// login for user
			actions.moveToElement(pof.send2).click().perform();
			Thread.sleep(2000);
			test.pass("User login successful" + Description);
		} catch (InterruptedException e) {
			test.fail("User login failed"+ Description, MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			test.fail("User login failed"+ Description, MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		} catch (SAXException e) {
			test.fail("User login failed"+ Description, MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		} catch (IOException e) {
			test.fail("User login failed"+ Description, MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

	}
}