package elements;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import ID.elelments_id;
import Tools.Extent_reports;
import Tools.func;
import Tools.setUp;

public class login_user extends setUp {
	static Actions actions;
	static elelments_id pof = new elelments_id();

	public static void Login(String Description, Extent_reports exm, ExtentTest test) throws IOException, AWTException {
		pof = PageFactory.initElements(driver, elelments_id.class);
		actions = new Actions(driver);
		try {
			actions.moveToElement(pof.login).click().perform();
			Thread.sleep(2000);
			// enter email and password
			pof.email.sendKeys(func.getData("email"));
			pof.pass.sendKeys(func.getData("pass"));
			// login for user
			actions.moveToElement(pof.send2).click().perform();
			Thread.sleep(2000);
			test.pass("User login successful - " + Description);
		} catch (Exception e) {
			test.fail("User login failed" + Description,
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

	}
}