package ID;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class my_account_id {

	@FindBy(how = How.XPATH, using = "//div[@class='loginbox islogin']/a[1]")
	public WebElement loginbox;

	@FindBy(how = How.XPATH, using = "//div[@id='right_sidebar']/div/div[2]/ul/li/a")
	public List<WebElement> right_sidebar;

	@FindBy(how = How.XPATH, using = "//div[@class='welcome-msg']/h2")
	public WebElement welcome_msg;

	@FindBy(how = How.XPATH, using = "//div[@class='col-md-6'][1]/div/div[2]/p")
	public WebElement accountDetailes;

	@FindBy(how = How.XPATH, using = "//div[@class='customer-name']/div/div/input")
	public List<WebElement> customer_name;

	@FindBy(how = How.XPATH, using = "//li[@class='fields'][2]/div[1]/div/input")
	public WebElement email;

	@FindBy(how = How.XPATH, using = "//li[@class='fields'][3]/div[1]/div/input")
	public WebElement phone_num;

	@FindBy(how = How.ID, using = "gender")
	public WebElement gender;

	@FindBy(how = How.XPATH, using = "//select[@id='gender']/option[@selected]")
	public WebElement selected;

	@FindBy(how = How.XPATH, using = "//div[@class='col-md-10 buttons-set']/button")
	public WebElement save;

	@FindBy(how = How.XPATH, using = "//div[@class='ajs-dialog']//div[@class='ajs-content']//span")
	public WebElement ajs_content;

	@FindBy(how = How.XPATH, using = "//div[@class='ajs-dialog']//button[@class='ajs-button ajs-ok']")
	public WebElement ajs_button;

	@FindBy(how = How.XPATH, using = "//li[@class='col-md-6 box-info'][2]//address")
	public WebElement address;

	@FindBy(how = How.XPATH, using = "//div[@id='content']/p")
	public WebElement content;

}
