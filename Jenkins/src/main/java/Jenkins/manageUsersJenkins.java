package Jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class manageUsersJenkins {
	@FindBy (xpath="//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createUser;
	@FindBy (xpath="/html/body/div[4]/div[2]/h1")
	private WebElement checkMenu;
	
	public void createUser() {
		createUser.click();	
}
	public String findUser(WebDriver driver, String username) {
		return	driver.findElement(By.linkText(username)).getText();
}
	public void selectUser(WebDriver driver, String username) {
		driver.findElement(By.cssSelector("a[href*='"+username+"'")).click();
}
	public String checkMenu() {
		return checkMenu.getText();	
}
}
