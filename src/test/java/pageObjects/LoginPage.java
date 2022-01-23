package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;
@FindBy(xpath="//*[@id='Email']")
WebElement emailTxt;
@FindBy(xpath="//input[@name='Password']")
WebElement passTxt;
@FindBy(xpath="//button[text()='Log in']")
WebElement loginBtn;
@FindBy(xpath="//a[text()='Logout']")
WebElement logoutLink;


public LoginPage(WebDriver driver) 
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
/*
 * This method is used to setTxt for username 
 */
public void setTxtOfUsername(String username)
{
	emailTxt.clear();
	emailTxt.sendKeys(username);
}
/*
 * This method is used to enter passowrd
 */
public void setTxtOfPassoword(String password)
{
	passTxt.clear();
	passTxt.sendKeys(password);
}
/*
 * This method is used to click on login button
 */
public void clickOnLoginBtn()
{
	loginBtn.click();
}
/*
 * This method is used to login
 */
public void login(String username,String password)
{
	setTxtOfUsername( username);
	setTxtOfPassoword(password);
	clickOnLoginBtn();	
}
/*
 * This method is used get the titile of dashboard page
 */
public String getTilteOfDashboardPage() 
{
	System.out.println(driver.getTitle());
	return driver.getTitle();
}
/*
 * This method is used to click on logout link
 */
public void clickOnLogOutLink()
{
	logoutLink.click();
}
/*
 * This methosd is used to get the title of login page
 */
public String getTheTitleofLoginPage()
{
	return driver.getTitle();
}
}
