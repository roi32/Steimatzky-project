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

	@FindBy(how = How.ID, using = "orderDetails")
	public WebElement orderDetails;

	@FindBy(how = How.ID, using = "createClub")
	public WebElement createClub;

	@FindBy(how = How.XPATH, using = "//div[@class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-pulse']/div[@class='ajs-modal']//div[@class='ajs-content']")
	public WebElement ajs_content2;

	@FindBy(how = How.XPATH, using = "//div[@class='alertify  ajs-movable ajs-closable ajs-pinnable ajs-pulse']//div[@class='ajs-footer']//button")
	public WebElement ajs_button2;

	@FindBy(how = How.CLASS_NAME, using = "product-name")
	public WebElement product_name;

	@FindBy(how = How.CLASS_NAME, using = "price")
	public WebElement price;

	@FindBy(how = How.XPATH, using = "//table[@id='shopping-cart-table']//input")
	public WebElement qty;

	@FindBy(how = How.ID, using = "top-cart-icon")
	public WebElement top_cart_icon;

	@FindBy(how = How.XPATH, using = "//div[@id='userBox']//a[@id='top-cart-icon']/span[1]")
	public WebElement num_cart;

	@FindBy(how = How.XPATH, using = "//li[@class='clearafter minicartitem']")
	public WebElement mini_cart_item;

	@FindBy(how = How.XPATH, using = "//div[@class='prdDetails']//span[@class='price']/span[2]")
	public WebElement price2;

	@FindBy(how = How.XPATH, using = "//div[@class='prdDetails']//span[@class='price']/span[3]")
	public WebElement price3;

	@FindBy(how = How.XPATH, using = "//div[@class='prdQty']//span[1]")
	public WebElement prdQty;

	@FindBy(how = How.XPATH, using = "//footer[@class='minicartFooter']/button")
	public WebElement forPay;

	@FindBy(how = How.XPATH, using = "//div[@id='content']//table/tbody/tr/td[@class='prdTotal  a-right col-md-2 last']/a")
	public WebElement remove;

	@FindBy(how = How.XPATH, using = "//div[@class='cart-empty']/p[1]")
	public WebElement cart_empty;

	@FindBy(how = How.ID, using = "add-premium")
	public WebElement add_premium;

	@FindBy(how = How.XPATH, using = "//div[@id='main_content']/div/div/div/div/p/a")
	public WebElement Steimatzkys_Prime;

//	
}
