package ID;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login_id {

	@FindBy(how = How.ID, using = "email")
	public WebElement email;

	@FindBy(how = How.ID, using = "pass")
	public WebElement pass;

	@FindBy(how = How.ID, using = "send2")
	public WebElement send2;

	@FindBy(how = How.XPATH, using = "//div[@id='userBox']//div[@class='loginbox ']/a[@class='login-btn'][1]")
	public WebElement login;

	@FindBy(how = How.XPATH, using = "//div[@id='userBox']//div[@class='loginbox islogin']/a[2]")
	public WebElement logout;

	@FindBy(how = How.XPATH, using = "//div[@class='loginbox islogin']/a[1]")
	public WebElement loginbox;

	@FindBy(how = How.ID, using = "advice-required-entry-email")
	public WebElement error_email;

	@FindBy(how = How.ID, using = "advice-validate-email-email")
	public WebElement error_email2;

	@FindBy(how = How.ID, using = "advice-required-entry-pass")
	public WebElement error_pass;

	@FindBy(how = How.ID, using = "advice-validate-password-pass")
	public WebElement error_pass2;

	@FindBy(how = How.XPATH, using = "//div[@class='ajs-dialog']//button[@class='ajs-button']")
	public WebElement ajs_button;

	@FindBy(how = How.XPATH, using = "//div[@class='alertify  ajs-closable ajs-unpinned ajs-pulse']/div[2]/div/div[3]/div")
	public WebElement ajs_content;

}
