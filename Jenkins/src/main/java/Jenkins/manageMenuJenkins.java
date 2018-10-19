package Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class manageMenuJenkins {
	@FindBy (xpath="//*[@id=\"main-panel\"]/div[17]/a/dl/dt")
	private WebElement manageUsers;
	
	public void manageUsers() {
		manageUsers.click();
}
}
