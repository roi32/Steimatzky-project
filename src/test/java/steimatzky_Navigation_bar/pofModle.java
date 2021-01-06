package steimatzky_Navigation_bar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class pofModle {

	@FindBy(how = How.XPATH, using = "//a[@class='sales']")
	WebElement sales;

	@FindBy(how = How.XPATH, using = "//a[@class='club']")
	WebElement club;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[1]/a")
	WebElement books;
	
	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[2]/a")
	WebElement Ebooks;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[3]/a")
	WebElement games;
	
	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[3]/div/ul/li/ul/li[1]")
	WebElement Subgames;
	
	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[6]/a")
	WebElement Gifts_and_leisure;
	
	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[7]/a")
	WebElement music;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[8]/a")
	WebElement Appliances;
	
	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[9]/a")
	WebElement Smartphones;
	
	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[10]/a")
	WebElement Cosmetics_and_perfumes;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[11]/a")
	WebElement HOME;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[12]/a")
	WebElement camping;


}
