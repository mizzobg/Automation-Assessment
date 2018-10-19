package Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mainMenuJenkins {
	@FindBy (xpath="//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement manage;
	
	public void manageMenu() {
		manage.click();
	}
	public String checkMenu() {
		return manage.getText();
	}
}
