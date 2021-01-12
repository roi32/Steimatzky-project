package elements;

import java.awt.AWTException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.interactions.Actions;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.MediaEntityBuilder;

import Navigation_bar.Navigation_bar;

public class login_user extends Navigation_bar {

	public void Login(Actions actions, String Description) throws IOException, AWTException {
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
			test.fail("User login failed", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			test.fail("User login failed", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		} catch (SAXException e) {
			test.fail("User login failed", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		} catch (IOException e) {
			test.fail("User login failed", MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

	}
}