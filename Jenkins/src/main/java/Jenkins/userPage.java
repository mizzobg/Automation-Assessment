package Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userPage {
	@FindBy (xpath="//*[@id=\"main-panel\"]/div[2]")
	private WebElement userName;
	@FindBy (xpath="//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement configBtn;
	
	public Boolean checkName(String username) {
		if (userName.getText().contains(username)) {
			return true;
		}
		else {
			return false;
		}
	}
	public void clickConfig() {
		configBtn.click();
	}
}
