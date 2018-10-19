package Jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class loginJenkins {
	@FindBy (id="j_username")
	private WebElement username;
	@FindBy (xpath="/html/body/div/div/form/div[2]/input")
	private WebElement password;
	@FindBy (xpath="//*[@id=\"loginIntroDefault\"]/h1")
	private WebElement message;
	

	public void loginPrompt(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		password.submit();
	}
	public String loginCheck(WebDriver driver) {
		WebElement wait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("loginIntroDefault")));
		return wait.getText();
	}
}
