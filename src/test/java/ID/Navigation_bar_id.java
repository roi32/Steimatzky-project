package ID;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Navigation_bar_id {

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li/a")
	public List<WebElement> mCategory;

	@FindBy(how = How.XPATH, using = "//a[@class='sales']")
	public WebElement sales;

	@FindBy(how = How.XPATH, using = "//a[@class='club']")
	public WebElement club;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[13]/div/ul/li/ul/li/a")
	public List<WebElement> club_subCategory;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[1]/a")
	public WebElement books;

	@FindBy(how = How.XPATH, using = "//li[@id='menuCat-398']/div/ul/li/ul/li/a")
	public List<WebElement> books_subCategory;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[2]/a")
	public WebElement Ebooks;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[2]/div/ul/li/ul/li/a")
	public List<WebElement> ebooks_subCategory;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[3]/a")
	public WebElement games;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[3]/div/ul/li/ul/li[1]")
	public WebElement Subgames;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[6]/a")
	public WebElement Gifts_and_leisure;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[6]/div/ul/li/ul/li/a")
	public List<WebElement> Gifts_and_leisure_subCategory;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[7]/a")
	public WebElement music;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[7]/div/ul/li/ul/li/a")
	public List<WebElement> music_subCategory;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[8]/a")
	public WebElement Appliances;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[8]/div/ul/li/ul/li/a")
	public List<WebElement> Appliances_subCategory;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[9]/a")
	public WebElement Smartphones;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[9]/div/ul/li/ul/li/a")
	public List<WebElement> Smartphones_subCategory;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[10]/a")
	public WebElement Cosmetics_and_perfumes;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[10]/div/ul/li/ul/li/a")
	public List<WebElement> Cosmetics_and_perfumes_subCategory;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[11]/a")
	public WebElement HOME;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[11]/div/ul/li/ul/li/a")
	public List<WebElement> home_subCategory;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[12]/a")
	public WebElement camping;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[12]/div/ul/li/ul/li/a")
	public List<WebElement> camping_subCategory;

	@FindBy(how = How.XPATH, using = "//div[@id='userBox']//div[@class='loginbox ']/a[@class='login-btn'][1]")
	public WebElement login;

	@FindBy(how = How.ID, using = "email")
	public WebElement email;

	@FindBy(how = How.ID, using = "pass")
	public WebElement pass;

	@FindBy(how = How.ID, using = "send2")
	public WebElement send2;
}
