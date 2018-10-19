package Jenkins;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class stepExecution {
	ExtentReports report = new ExtentReports(constants.Path_Reports+constants.UserCreation_Report, false);
	ExtentTest TestScenario1;
	ExtentTest TestScenario2;
	ExtentTest TestScenario3;
	ExtentTest TestScenario4;
	static int userCnt1=1;
	static int userCnt2=1;
	static int userCnt3=1;
//	static int test=1;
//	static int t1row=1;
//	static int t1coll=1;
	public WebDriver driver = null;
	
	
	@Before
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", constants.Chrome_Driver);
		driver = new ChromeDriver();
//		FileInputStream file = new FileInputStream(constants.Path_TestData+constants.File_TestData);
//		XSSFWorkbook workbook = new XSSFWorkbook(file);
//		XSSFSheet sheet = workbook.getSheetAt(test);
	}
	
	@After
	public void tearDown() {
		driver.quit();			
//		report.endTest(startTest);
//		report.endTest(loginCheck);
//		report.endTest(userCreationCheck);
		userCnt1++;
		userCnt2++;
		userCnt3++;
//		test++;
		report.flush();	
	}
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() {	//1&2
		driver.get(constants.User_Creation_Page);
		loginJenkins login = PageFactory.initElements(driver, loginJenkins.class);
		manageUsersJenkins userMangeMenu = PageFactory.initElements(driver, manageUsersJenkins.class);
		login.loginPrompt(constants.Admin_User,constants.Admin_Pass);
		userMangeMenu.createUser();
				
	}

	@When("^the User details are entered on the Create UserScreen$")	//1
	public void the_User_details_are_entered_on_the_Create_UserScreen() {
		TestScenario1 = report.startTest("Test Scenario 1 creation of random user");
		userCreationMenu newUserMenu= PageFactory.initElements(driver, userCreationMenu.class);
		newUserMenu.newUser(constants.Test_User, constants.Test_Password, constants.Test_Password, constants.Test_Name, constants.Test_Email);
		TestScenario1.log(LogStatus.INFO,"Test User data input Completed");
	}

	@When("^the details are submitted on the Create UserScreen$")	//1&2
	public void the_details_are_submitted_on_the_Create_UserScreen() {
		userCreationMenu newUserMenu= PageFactory.initElements(driver, userCreationMenu.class);
		newUserMenu.submitInfo();
	}

	@Then("^the Username should be visible on the UsersScreen$") //1
	public void the_Username_should_be_visible_on_the_UsersScreen() {
		TestScenario1.log(LogStatus.INFO,"Check If Created User Exists");
		manageUsersJenkins userMangeMenu = PageFactory.initElements(driver, manageUsersJenkins.class);
		if (constants.Test_User.equals(userMangeMenu.findUser(driver,constants.Test_User))) {
			TestScenario1.log(LogStatus.PASS, "Verify creation successful");
		}else {
			TestScenario1.log(LogStatus.FAIL, "Verify creation Failed");
		}
	    assertEquals("Creation Check",constants.Test_User, userMangeMenu.findUser(driver,constants.Test_User));
		report.endTest(TestScenario1);
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, and \"([^\"]*)\" Fullname are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_and_Fullname_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4) {
		TestScenario2 = report.startTest("Test Scenario 2 creation muiltiple users from Cucumber"+" For User :"+userCnt1);
		userCreationMenu newUserMenu= PageFactory.initElements(driver, userCreationMenu.class);
		newUserMenu.newUser(arg1,arg2,arg3,arg4,constants.Test_Email);
		TestScenario2.log(LogStatus.INFO,"User Created "+arg4);
		}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")//2
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
		manageUsersJenkins userMangeMenu = PageFactory.initElements(driver, manageUsersJenkins.class);
		if (arg1.equals(userMangeMenu.findUser(driver,arg1))) {
			TestScenario2.log(LogStatus.PASS, "Verify creation successful");
		}else {
			TestScenario2.log(LogStatus.FAIL, "Verify creation Failed");
		}
		assertEquals("Creation Check",arg1, userMangeMenu.findUser(driver,arg1)); 
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")//3
	public void the_username_is_visible_on_the_UsersScreen(String arg1) {
		TestScenario3 = report.startTest("Test Scenario 2 creation muiltiple users from Cucumber"+" For User :"+arg1+" Num: "+userCnt2);
		driver.get(constants.User_Creation_Page);
		loginJenkins login = PageFactory.initElements(driver, loginJenkins.class);
		manageUsersJenkins userMangeMenu = PageFactory.initElements(driver, manageUsersJenkins.class);
		login.loginPrompt(constants.Admin_User,constants.Admin_Pass);
		assertEquals("Creation Check",arg1, userMangeMenu.findUser(driver,arg1)); 
		if (arg1.equals(userMangeMenu.findUser(driver,arg1))) {
			TestScenario3.log(LogStatus.PASS, "Verify creation successful"+" User " +userCnt2);
		}else {
			TestScenario3.log(LogStatus.FAIL, "Verify creation Failed"+" User " +userCnt2);
		}
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")//3
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
		manageUsersJenkins userMangeMenu = PageFactory.initElements(driver, manageUsersJenkins.class);
		userMangeMenu.selectUser(driver,arg1);
		TestScenario3.log(LogStatus.INFO,"User Selected "+arg1);
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")//2
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) {
		userPage userPageCheck = PageFactory.initElements(driver, userPage.class);
		Assert.assertTrue("Creation Check", userPageCheck.checkName(arg1)); 
		if (userPageCheck.checkName(arg1)) {
			TestScenario3.log(LogStatus.PASS, "Verify creation successful");
		}else {
			TestScenario3.log(LogStatus.FAIL, "Verify creation Failed");
		}
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")//4
	public void the_Username_s_profile_page_has_been_loaded(String arg1) {
		TestScenario4 = report.startTest("Test Scenario 4 full name change in system"+" For User :"+arg1+" Num: "+userCnt3);
		driver.get(constants.User_Creation_Page);
		loginJenkins login = PageFactory.initElements(driver, loginJenkins.class);
		manageUsersJenkins userMangeMenu = PageFactory.initElements(driver, manageUsersJenkins.class);
		
		login.loginPrompt(constants.Admin_User,constants.Admin_Pass);
		userMangeMenu.selectUser(driver,arg1);
		TestScenario4.log(LogStatus.INFO,"User located: "+arg1);
	}

	@Given("^the configure button has been clicked on the profile page$")//4
	public void the_configure_button_has_been_clicked_on_the_profile_page() {
		userPage user = PageFactory.initElements(driver, userPage.class);
		user.clickConfig();
		TestScenario4.log(LogStatus.INFO,"Config change selected.");
		
	}

	@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
	public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1)  {
		editUserPage user = PageFactory.initElements(driver, editUserPage.class);
		user.changeName(arg1);
		TestScenario4.log(LogStatus.INFO,"New name put in textbox for = " +arg1);
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page(){
		editUserPage user = PageFactory.initElements(driver, editUserPage.class);
		user.saveChanges();
		TestScenario4.log(LogStatus.INFO,"Changes Saved!");
	}

	@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_NewFullName(String arg1){
		userPage user = PageFactory.initElements(driver, userPage.class);
		editUserPage edit = PageFactory.initElements(driver, editUserPage.class);
		user.clickConfig();
		if (arg1.equals(edit.returnName())) {
			TestScenario4.log(LogStatus.PASS, "Verify change successful");
		}else {
			TestScenario4.log(LogStatus.FAIL, "Verify change Failed");
		}
		assertEquals("Check if name has changed",arg1, edit.returnName());
	}

}
