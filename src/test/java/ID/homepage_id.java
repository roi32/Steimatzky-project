package ID;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class homepage_id {
	
	@FindBy(how = How.ID, using = "ZA_CANVAS_1261041_CLICKABLE_BIMAGE_2_CID_54994")
	public WebElement callPoppup;
	
	@FindBy(how = How.XPATH, using = "//div[@id='ZA_CANVAS_1093222_CLOSE_IMG5_4_CONT']/img")
	public WebElement Cpopup;

	@FindBy(how = How.CLASS_NAME, using = "logo-site")
	public WebElement logo;

	
	

}
