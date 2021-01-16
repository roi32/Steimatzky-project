package elements;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import ID.elelments_id;
import Tools.Extent_reports;
import Tools.func;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Footer_Buttom extends func {

	static Actions actions;
	static JavascriptExecutor js;
	static elelments_id pof = new elelments_id();;

	public static void Footer(WebDriver driver, ExtentTest test, Extent_reports exm) throws AWTException, IOException {

		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
		pof = PageFactory.initElements(driver, elelments_id.class);

		try {
			test.info("-------- About ------------");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// scroll to footer page
			js.executeScript("window.scrollBy(0,250)", "");
			for (int i = 0; i < pof.about.size(); i++) {
				String aboutString = pof.about.get(i).getText();
				actions.moveToElement(pof.about.get(i)).click().perform();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//close popUp
				try {
					if (pof.Cpopup.isDisplayed()) {
						actions.moveToElement(pof.Cpopup).click().perform();
						Thread.sleep(2000);
					}
				} catch (Exception e) {
				}
				//if open new tab
				if (tabs2.size() == 2) {
					driver.switchTo().window(tabs2.get(1));
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					// Check if I got to the right page
					pageTitleTest(driver.getTitle(), "����� ����:", exm, test);
					driver.close();
					driver.switchTo().window(tabs2.get(0));
				// Check if I got to the right page
				} else if (driver.getTitle().contains(aboutString)) {
					test.pass("you in " + aboutString + " page");
				} else if (aboutString.equals("������� ������")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "������� - ������ ������", exm, test);
				} else if (aboutString.equals("������")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "������ ������", exm, test);
				} else {
					test.fail("you not in " + aboutString + " page",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}

			}
		} catch (Exception e) {
			test.fail("The links test of about fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		try {
			test.info("---------- Useful_information -----------");
			// scroll to footer page
			js.executeScript("window.scrollBy(0,250)", "");
			for (int i = 0; i < pof.Useful_information.size(); i++) {
				String aboutString = pof.Useful_information.get(i).getText();
				actions.moveToElement(pof.Useful_information.get(i)).click().perform();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//if open new tab
				if (tabs2.size() == 2) {
					driver.switchTo().window(tabs2.get(1));
					if (aboutString.equals("����� ���� ����� ����")) {
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						// Check if I got to the right page
						pageTitleTest(driver.getTitle(), "������ ����� ������ ������ ����", exm, test);
						driver.close();
						driver.switchTo().window(tabs2.get(0));
					}
					// Check if I got to the right page
				} else if (driver.getTitle().contains(aboutString)) {
					test.pass("you in " + aboutString + " page");

				} else if (aboutString.equals("���� �������")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "Blog", exm, test);

				} else if (aboutString.equals("������ ������ ���")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "����� ������� ������� �� ������� - ������ ���", exm, test);
				} else if (aboutString.equals("��� ���")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "����� ���", exm, test);
				} else {
					test.fail("you not in " + aboutString + " page",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
			}
		} catch (Exception e) {
			test.fail("The links test of useful information fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		try {
			test.info("-------------- Information_for_buyers_on_the_site ----------------");
			// scroll to footer page
			js.executeScript("window.scrollBy(0,250)", "");
			for (int i = 0; i < pof.Information_for_buyers.size(); i++) {
				String aboutString = pof.Information_for_buyers.get(i).getText();
				actions.moveToElement(pof.Information_for_buyers.get(i)).click().perform();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Check if I got to the right page
				if (driver.getTitle().contains(aboutString)) {
					test.pass("you in " + aboutString + " page");
				} else if (aboutString.equals("������� �������")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "����� �������", exm, test);
				} else if (aboutString.equals("�������")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "����� ������ ������", exm, test);
				} else if (aboutString.equals("������� ������ ������")) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					pageTitleTest(driver.getTitle(), "������� ����� ������ ������� �������", exm, test);
				} else {
					test.fail("you not in " + aboutString + " page",
							MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
				}
			}
		} catch (Exception e) {
			test.fail("The links test of information for buyers on the site fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}

		try {
			test.info("------------- facebook --------------");
			// scroll to footer page
			js.executeScript("window.scrollBy(0,250)", "");
			actions.moveToElement(pof.facebook_link).click().perform();
			Thread.sleep(2000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().window(tabs2.get(1));
			// Check if I got to the right page
			pageTitleTest(driver.getTitle(), "������� - �� ���� | �������", exm, test);
		} catch (Exception e) {
			test.fail("The link test of facebook fail",
					MediaEntityBuilder.createScreenCaptureFromPath(exm.CaptureScreen()).build());
			e.printStackTrace();
		}
	}
}