package Jenkins;


//public class userCreationTest {
//	ExtentReports report = new ExtentReports(constants.Path_Reports+constants.UserCreation_Report, true);
//	ExtentTest eTest;
//
//		public WebDriver driver = null;
//		
//	
//		@Before
//		public void setup() {
//			eTest = report.startTest("User Creation Report");
//			System.setProperty("webdriver.chrome.driver", constants.Chrome_Driver);
//			driver = new ChromeDriver();
//			eTest.log(LogStatus.INFO, "Browser/Driver setup completed");
//		}
//		@After
//		public void tearDown() {
//			driver.quit();			
//			report.endTest(eTest);	
//			report.flush();			
//		}
//		@Test
//		public void create() {
//			driver.get(constants.website);
//			eTest.log(LogStatus.INFO, "Browser started and Page loaded");
//			
//			loginJenkins login = PageFactory.initElements(driver, loginJenkins.class);
//			mainMenuJenkins mainMenu = PageFactory.initElements(driver, mainMenuJenkins.class);
//			manageMenuJenkins manageMenu = PageFactory.initElements(driver, manageMenuJenkins.class);
//			manageUsersJenkins userMangeMenu = PageFactory.initElements(driver, manageUsersJenkins.class);
//			userCreationMenu newUserMenu= PageFactory.initElements(driver, userCreationMenu.class);
//			
//			login.loginPrompt(constants.Admin_User,constants.Admin_Pass);
//			eTest.log(LogStatus.INFO, "Admin login Completed");
//			mainMenu.manageMenu();
//			eTest.log(LogStatus.INFO, "Navigated from main menu to mange menu");
//			manageMenu.manageUsers();
//			eTest.log(LogStatus.INFO, "Navigated from mange menu to user management menu");
//			userMangeMenu.createUser();
//			eTest.log(LogStatus.INFO, "Navigated from user management menu to user creation menu");
//			newUserMenu.newUser(constants.Test_User, constants.Test_Password,constants.Test_Password, constants.Test_Name, constants.Test_Email);
//			eTest.log(LogStatus.INFO, "Created user using constants set variables.");
//			if (constants.Test_User.equals(userMangeMenu.findUser())) {
//				eTest.log(LogStatus.PASS, "verify creation successful");
//			}else {
//				eTest.log(LogStatus.FAIL, "verify creation Failed");
//			}
//		    assertEquals("Creation Check",constants.Test_User, userMangeMenu.findUser());
//		}
//}
