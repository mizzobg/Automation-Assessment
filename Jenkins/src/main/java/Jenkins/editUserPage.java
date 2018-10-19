package Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class editUserPage {
	@FindBy (xpath="//*[@id=\"main-panel\"]/form/table/tbody/tr[1]/td[3]/input")
	private WebElement fullName;
	@FindBy (id="yui-gen2-button")
	private WebElement saveBtn;
	public void changeName(String name) {
		fullName.clear();
		fullName.sendKeys(name);
	}
	public void saveChanges() {
		saveBtn.click();
	}
	public String returnName() {
		return fullName.getAttribute("value");
	}
}
