package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li")
List<WebElement> menu;
@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li")
List<WebElement> custSubmenu;
public WebDriver driver;
public DashBoardPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
/*
 * This method is used to click on menu based on value provided
 */
public void clickOnMenu(String menuName) {
	for(int i=0;i<menu.size();i++) {
		if(menu.get(i).getText().contentEquals(menuName)) {
			menu.get(i).click();
		}
	}
}
/*
 * This method is used to click on submenu under customers menu	
 */
public void clickOnSubmenuUnderCustomers(String submenuName) {
	for(int i=0;i<custSubmenu.size();i++) {
		if(custSubmenu.get(i).getText().contentEquals(submenuName)) {
			custSubmenu.get(i).click();
		}
	}
}
}

