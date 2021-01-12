package ID;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Footer_ID {

	@FindBy(how = How.XPATH, using = "//footer//nav[@class='col-sm-4'][1]/div/ul/li/a")
	public List<WebElement> about;

	@FindBy(how = How.ID, using = "ZA_CANVAS_1093222_CLOSE_IMG5_4_IMG")
	public WebElement popup;

	@FindBy(how = How.XPATH, using = "//footer//nav[@class='col-sm-4'][2]/div/ul/li/a")
	public List<WebElement> Useful_information;

	@FindBy(how = How.XPATH, using = "//footer//nav[@class='col-sm-4'][3]/div/ul/li/a")
	public List<WebElement> Information_for_buyers;

	@FindBy(how = How.ID, using = "email")
	public WebElement email;

	@FindBy(how = How.ID, using = "pass")
	public WebElement pass;

	@FindBy(how = How.ID, using = "send2")
	public WebElement send2;

	@FindBy(how = How.XPATH, using = "//div[@id='userBox']//div[@class='loginbox ']/a[@class='login-btn'][1]")
	public WebElement login;

	@FindBy(how = How.ID, using = "fb-link")
	public WebElement facebook_link;
}
