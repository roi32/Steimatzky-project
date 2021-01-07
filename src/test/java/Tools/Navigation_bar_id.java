package Tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Navigation_bar.Navigation_bar;

public class Navigation_bar_id extends Navigation_bar {

	public WebElement topItem(WebDriver driver, int mCategoryNum) {
		WebElement topItem = driver.findElement(By.xpath("//ul[@id='catMenu']/li[" + mCategoryNum + "]/a"));
		return topItem;

	}

	public WebElement subCatagory(WebDriver driver, int mCategoryNum, int subCategorynum) {
		WebElement subCatagory = driver.findElement(By.xpath("//ul[@id='catMenu']/li[" + mCategoryNum + "]/div/ul/li/ul/li[" + subCategorynum + "]/a"));
		return subCatagory;

	}

	public WebElement books_subCategory(WebDriver driver, int clumNum, int subcatagoryNum) {
		WebElement subCatagory = driver.findElement(By.xpath("//li[@id='menuCat-398']/div/ul/li[" + clumNum + "]/ul/li[" + subcatagoryNum + "]/a"));
		return subCatagory;

	}

	@FindBy(how = How.XPATH, using = "//a[@class='sales']")
	public WebElement sales;

	@FindBy(how = How.XPATH, using = "//a[@class='club']")
	public WebElement club;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[1]/a")
	public WebElement books;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[2]/a")
	public WebElement Ebooks;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[3]/a")
	public WebElement games;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[3]/div/ul/li/ul/li[1]")
	public WebElement Subgames;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[6]/a")
	public WebElement Gifts_and_leisure;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[7]/a")
	public WebElement music;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[8]/a")
	public WebElement Appliances;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[9]/a")
	public WebElement Smartphones;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[10]/a")
	public WebElement Cosmetics_and_perfumes;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[11]/a")
	public WebElement HOME;

	@FindBy(how = How.XPATH, using = "//ul[@id='catMenu']/li[12]/a")
	public WebElement camping;

}
