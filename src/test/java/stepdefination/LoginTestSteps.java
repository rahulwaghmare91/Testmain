package stepdefination;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import Utility.CommnMethods;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.CustomersPage;
import pageObjects.DashBoardPage;
import pageObjects.LoginPage;

public class LoginTestSteps {
	public WebDriver driver;
	public LoginPage loginPage;
	public DashBoardPage dashboardPage;
	public CustomersPage c1;
	File folder;

	@Given("user launch the browser")
	public void user_launch_the_browser() {
     folder=new File("Download");
    boolean b= folder.mkdir();
    System.out.println(b);
	 System.setProperty("webdriver.chrome.driver","E:\\cucumber practice project\\Cucumber-for-paractice\\Drivers\\chromedriver.exe");
     ChromeOptions options=new ChromeOptions();
     Map<String, Object> prefs=new HashMap<String, Object>();
     prefs.put("profile.default_content_settings.popups", 0);
     prefs.put("download.default_directory", folder.getAbsolutePath());
     options.setExperimentalOption("prefs", prefs);
     DesiredCapabilities cap=new DesiredCapabilities().chrome();
     cap.setCapability(ChromeOptions.CAPABILITY, options);
     driver =new ChromeDriver(cap);
     
	}
	
	@When("user open the url as {string}")
	public void user_open_the_url_as(String Url) {
	 driver.get(Url);
	}

	@When("user enter valid Username as {string} and password as {string}")
	public void user_enter_valid_username_as_and_password_as(String username, String password) {
		loginPage=new LoginPage(driver);
		loginPage.setTxtOfUsername(username);
		loginPage.setTxtOfPassoword(password);
		loginPage.clickOnLoginBtn();
	}

	@Then("validate user is on dashboard page")
	public void validate_user_is_on_dashboard_page() {
		String title=loginPage.getTilteOfDashboardPage();
		Assert.assertEquals("Dashboard / nopCommerce administration",title);
		System.out.println("user able to login into applycation");
	}

	@When("User click logout link")
	public void user_click_logout_link() {
		loginPage.clickOnLogOutLink();	
	}

	@Then("validate user is on log in page")
	public void validate_user_is_on_log_in_page() {
		String loginPagTilte=loginPage.getTheTitleofLoginPage();
		System.out.println(loginPagTilte); 
		Assert.assertEquals("Your store. Login",loginPagTilte);
		System.out.println("user seccessfullyy log out from application");
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();
	}
	/*
	 * Add new customer 
	 */
	@When("User click on customers menu option")
	public void user_click_on_customers_menu_option() {
		dashboardPage=new DashBoardPage(driver);
		dashboardPage.clickOnMenu("Customers");				
	}

	@When("user click on customers submenu")
	public void user_click_on_customers_submenu() {
		dashboardPage.clickOnSubmenuUnderCustomers("Customers");
		//CustomersPage c1=new CustomersPage(driver);
		//c1.searchUserByEntringAllFields("uu","jnj","hh","8","u", "5","11");
		//c1.searchUserByEntringAllFields("Vndfe@gmail.com","Automation", "tester","nice","", "1", "12");


	}

	@Then("validate user is navigate to customerslistPage")
	public void validate_user_is_navigate_to_customerslist_page() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}

	@When("user click on Add new button")
	public void user_click_on_add_new_button() {
		CustomersPage c1=new CustomersPage(driver);
		c1.clickOnAddNewButton();
	}

	@Then("validate User is add new customers Page")
	public void validate_user_is_add_new_customers_page() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}

	@When("user enter customer info")
	public void user_enter_customer_info() {
	    // Write code here that turns the phrase above into concrete actions
		CustomersPage c1=new CustomersPage(driver);
		c1.enterCustomerInfoToAddNewUser("iomhioyu@gmail.com","manual", "tester","nice1","Male");

	}

	@When("click on Save button")
	public void click_on_save_button() {
		CustomersPage c1=new CustomersPage(driver);
		c1.clickOnSaveorSavecontinueeditButton("save");}
	
	@Then("verify sucess message is displayed as {string}")
	public void verify_sucess_message_is_displayed_as(String sucessmessage) {
		CustomersPage c1=new CustomersPage(driver);
		boolean actual=c1.validateUserIsCreated(sucessmessage);
		System.out.println(actual);

	}

  @Then("validate user able to search the user using email")
  public void validate_user_able_to_search_the_user_using_email() throws InterruptedException {
		CustomersPage c1=new CustomersPage(driver);
		c1.searchTheUser("email","iomhioyu@gmail.com","","","");
		String h=c1.getTextOfSearchedUser("email");
		System.out.println(h);

  }

  @Then("validate user able to search the user using name")
  public void validate_user_able_to_search_the_user_using_name() throws InterruptedException {

     
  }

  @Then("validate user able to search the user using company name")
  public void validate_user_able_to_search_the_user_using_company_name() throws InterruptedException {
		CustomersPage c1=new CustomersPage(driver);
		c1.searchTheUser("byCompanyName","","","","nice1");
		String f=c1.getTextOfSearchedUser("companyName");
		System.out.println(f);

  }
  @When("user click on select user checkox")
  public void user_click_on_select_user_checkox() throws InterruptedException {
		CustomersPage c1=new CustomersPage(driver);
		c1.serchUserAndClickOnCorresspondingCheckbox("iomhioyu@gmail.com");
		Thread.sleep(5000);

  }

  @When("user click on export dropdown menu")
  public void user_click_on_export_dropdown_menu() {
		CustomersPage c1=new CustomersPage(driver);
        c1.clickOnExportDropdawn();
  }

  @When("click on export to Excel")
  public void click_on_export_to_excel() {
		CustomersPage c1=new CustomersPage(driver);
		c1.clickONDropDawnItems("exportexcel-selected");

  }


}
