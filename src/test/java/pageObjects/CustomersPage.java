package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomersPage {
	@FindBy(xpath="//input[@id='SearchEmail']")
	WebElement searchemailTxt;
	@FindBy(xpath="//input[@id='SearchCompany']")
	WebElement searchcompanyTxt;
	@FindBy(xpath="//input[@id='SearchFirstName']")
	WebElement searchfirstNameTxt;
	@FindBy(xpath="//input[@id='SearchLastName']")
	WebElement searchlastNameTxt;
	@FindBy(xpath="//input[@id='SearchIpAddress']")
	WebElement searchipAddrssTxt;
	@FindBy(xpath="//select[@id='SearchMonthOfBirth']")
	WebElement searchdropdawnmonth;
	@FindBy(xpath="//select[@id='SearchDayOfBirth']")
	WebElement searchdropdawndate;
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement searchBtn;
	@FindBy(xpath="/html/body/div[3]/div[1]/form[1]/div/div/a/i")
	WebElement addnewBtn;
	@FindBy(xpath="//input[@id='Email']")
	WebElement emailTxt;
	@FindBy(xpath="//input[@id='Company']")
	WebElement companyTxt;
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement firstNameTxt;
	@FindBy(xpath="//input[@id='LastName']")
	WebElement lastNameTxt;
	@FindBy(xpath="//input[@id='Gender_Male']")
	WebElement gendMaleradiBTN;
	@FindBy(xpath="//input[@id='Gender_Female']")
	WebElement gendfeMaleradiBTN;
	@FindBy(xpath="//button[@name='save']")
	WebElement saveBTN;
	@FindBy(xpath="//button[@name='save-continue']")
	WebElement saveandcntnueedit;
	@FindBy(xpath="/html/body/div[3]/div[1]/div[1]")
	WebElement sucessMsg;
	@FindBy(xpath="/html/body/div[3]/div[1]/form[1]/div/div/div/button[2]")
	WebElement exportDopdawn;
	@FindBy(xpath="//*[@id='exportexcel-selected']")
	WebElement exportexcellselected;



public WebDriver driver;
public CustomersPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);

}
/*
 * This method is used to SetTxt of texbox depend value provided
 */
public void setTxtOfTexbox(WebElement texbox, String keysToSend) {
	texbox.clear();
	texbox.sendKeys(keysToSend);
}
/*
 * This method is used to select the Month from dropdawn
 */
public void selectvalueFromDropdawn(WebElement dropdawn,String value) {
	Select s=new Select(dropdawn);
	s.selectByValue(value);
	
}
/*
 * This method is used to enter date of birth
 */
public void enterDateOfBirth(String month,String day) {
	selectvalueFromDropdawn(searchdropdawnmonth,month);
	selectvalueFromDropdawn(searchdropdawndate,day);

}
/*
 *This method is used to search user by  entering All field 
 */
public void searchUserByEntringAllFields(String email, String firstName,String lastName,String company,String ipaddress,String day,String month) {
	setTxtOfTexbox(searchemailTxt,email);
	setTxtOfTexbox(searchfirstNameTxt,firstName);
	setTxtOfTexbox(searchlastNameTxt,lastName);
	setTxtOfTexbox(searchcompanyTxt,company);
	setTxtOfTexbox(searchipAddrssTxt,ipaddress);
	enterDateOfBirth(month,day);
	clickOnSearchButton();
}
/*
 * This method is used to click on search Button
 */
 public void clickOnSearchButton() {
	 searchBtn.click();
 }
 /*
  * This method is used to click on add bew button
  */
 public void clickOnAddNewButton() {
	 addnewBtn.click();
 }
 /*
  * This method is used to select male or female gender
  */
 public void clickOnMaleorFemaleGenderRadioButton(String genderType) {
	 if(genderType.equalsIgnoreCase("Male")) {
	 gendMaleradiBTN.click();
	 }	 gendfeMaleradiBTN.click();

	 
		 
	 }
 
 /*
  * This method is used to enter customer information
  */
 public void enterCustomerInfoToAddNewUser(String email,String firstName,String lastName,String company,String gender) {
		setTxtOfTexbox(emailTxt,email);
		setTxtOfTexbox(firstNameTxt,firstName);
		setTxtOfTexbox(lastNameTxt,lastName);
		setTxtOfTexbox(companyTxt,company);
		clickOnMaleorFemaleGenderRadioButton(gender);

 }
 /*
  * This method used to click on save or save edit continue button
  */
 public void clickOnSaveorSavecontinueeditButton(String button) {
	 switch(button) {
		 case "save":
		  saveBTN.click();
		   break;
		 case "save and continue edit":
		   saveandcntnueedit.click();
		    break;
	 }
			 
 
	 
 }
 /*
  * This method is used to get the txt of success msg after adding new user
  */
 public boolean  validateUserIsCreated(String msg) {
	 if(sucessMsg.getText().contains(msg)){
		 return true;
	 }return false;
 }
 /*
  * This method is used get the text of search user 
  */
 public String  getTextOfSearchedUser(String searchType) throws InterruptedException {
	 Thread.sleep(5000);

	 switch(searchType) {
	 case("email"):
		 for(int i=1;i<=getTotalRows();i++) {
			 String emailTxt = driver.findElement(By.xpath("//*[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText(); 
			 return emailTxt;
		 }
	 case"Name":
		 for(int i=1;i<getTotalRows();i++) {
			 String nameTxt = driver.findElement(By.xpath("//*[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			 return nameTxt;
		 }
	 case"Customer roles":
		 for(int i=1;i<getTotalRows();i++) {
			 String custRoleTxt = driver.findElement(By.xpath("//*[@id='customers-grid']/tbody/tr["+i+"]/td[4]")).getText();
			 return custRoleTxt;
		 }
	 case("companyName"):
		 for(int i=1;i<getTotalRows();i++) {
			 String companyNameTxt = driver.findElement(By.xpath("//*[@id='customers-grid']/tbody/tr["+i+"]/td[5]")).getText();
			 return companyNameTxt;
		 }
	 }return null;
	 }
		 
/*
 * This method is used to get the total number of rows from search user table		 
 */
	 public int getTotalRows() throws InterruptedException{
		 Thread.sleep(5000);
		 List <WebElement> totalRows= driver.findElements(By.xpath("//*[@id='customers-grid']/tbody/tr/td[1]"));
		 System.out.println(totalRows.size());
		 return totalRows.size();
	 }
			 
/*
 * This method is used to search user by email
 * 
 */
	 public void searcUser(String email) throws InterruptedException {
		setTxtOfTexbox(searchemailTxt,email);
		clickOnSearchButton();
		//Thread.sleep(5000);

	 }
	 /*
	  * This method is used to search the user  by various field
	  */
	 public void searchTheUser(String searchType,String email,String firstName, String lastName,String companyName) {
		 switch(searchType) 
		 {
		   case("email"):
		     setTxtOfTexbox(searchemailTxt,email);
		     clickOnSearchButton();
		    break;
		   case("byName"):
		    setTxtOfTexbox(firstNameTxt,firstName);
			setTxtOfTexbox(lastNameTxt,lastName);
			clickOnSearchButton();
			break;
		   case("byCompanyName"):
			setTxtOfTexbox(searchcompanyTxt,companyName);
			clickOnSearchButton();
			break;		   			  		   
  }
		 }
/*
 * This method is used search the userand select corrosponding checkbox
 */
	 public void serchUserAndClickOnCorresspondingCheckbox(String email) throws InterruptedException {
		 for(int i=1;i<=getTotalRows();i++) {
		 String searchemail= getTextOfSearchedUser("email");
		 if(searchemail.equalsIgnoreCase(email)) {
			 driver.findElement(By.xpath("//*[@id='customers-grid']/tbody/tr["+i+"]/td[1]/input")).click();
		 }
 }
		 
	}
/*
 * This method is used to click export dropdawn
 */
	public void clickOnExportDropdawn() {
		exportDopdawn.click();
	}
/*
 * This method is used to click on dropdawn items depends upon value privided
 */
	public void clickONDropDawnItems(String itemsName) {
		switch(itemsName) {
		case("exportxml-all"):
			break;
		case("exportxml-selected"):
			break;
		case("exportexcel-all"):
			break;
		case("exportexcel-selected"):
			exportexcellselected.click();
			break;
		}
	}
	 
		 
	 }
		 
	 
	 
 
 


