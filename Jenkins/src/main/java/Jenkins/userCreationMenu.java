package Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userCreationMenu {
	@FindBy (id="username")
	private WebElement username;
	@FindBy (xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement password;
	@FindBy (xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement passwordConf;
	@FindBy (xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement fullName;
	@FindBy (xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	private WebElement email;
	
	public void newUser(String user,String pass,String passConf,String name,String mail) {
		username.sendKeys(user);
		password.sendKeys(pass);
		passwordConf.sendKeys(passConf);
		fullName.sendKeys(name);
		email.sendKeys(mail);
		
	}
	public void submitInfo() {
		email.submit();
	}
}
