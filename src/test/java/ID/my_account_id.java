package ID;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class my_account_id {
	
	@FindBy(how = How.XPATH, using = "//a[@class='club']")
	public WebElement club;
	
	@FindBy(how = How.XPATH,using = "//li[@class='club-menu']/div/ul/li/ul/li[4]/a")
	public WebElement my_details;
	
	@FindBy (how = How.XPATH,using = "//div[@id='right_sidebar']/div/div[2]/ul/li/a")
	public List<WebElement> right_sidebar;

}
