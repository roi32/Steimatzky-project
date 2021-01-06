package steimatzky_search;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class pofModle {

	@FindBy(how = How.ID, using = "search")
	WebElement search;

	@FindBy(how = How.XPATH, using = "//form[@id='search_mini_form']/input[2]")
	WebElement submit;




}
