package ID;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class search_id {

	@FindBy(how = How.ID, using = "search")
	public WebElement search;

	@FindBy(how = How.XPATH, using = "//form[@id='search_mini_form']/input[2]")
	public WebElement submit;

	@FindBy(how = How.XPATH, using = "//section[@id='product-grid']//div[@class='inner']//h4[@class='bookTitle']/a")
	public List<WebElement> product_grid;

	@FindBy(how = How.XPATH, using = "//section[@id='product-grid']//span[@class='bookAuthor']/a")
	public List<WebElement> authorTitle;

}
