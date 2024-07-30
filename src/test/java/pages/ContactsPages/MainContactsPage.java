package pages.ContactsPages;

import pages.OrdersPages.OrderCardPage;
import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MainContactsPage extends BaseSeleniumPage {
    @FindBy(xpath = "//div[contains(@class,'second-header')]/descendant::a[@href=\"/contacts/add/\"]")
    private WebElement add_contact_btn;
    @FindBy(xpath = "//div[@class='table-list-contact--row'][1]/descendant::a[@class='crm-link']")
    private WebElement first_contact;

    public MainContactsPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public AddContactPage open_add_contact_card(){
        wait.until(ExpectedConditions.elementToBeClickable(add_contact_btn)).click();
        return new AddContactPage();
    }
    public ContactCardPage open_contact(){
        wait.until(ExpectedConditions.elementToBeClickable(first_contact)).click();
        return new ContactCardPage();
    }
    public ContactCardPage open_contact(String name_value){
        String order_xpath = "//*[text()='"+name_value+"']";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(order_xpath))).click();
        return new ContactCardPage();
    }
    public List<String> get_list_of_contacts(){
        List<WebElement> list_one = driver.findElements(By.xpath("//div[@class='table-list-contact--row']/descendant::a[@class='crm-link']/child::span"));
        List<String> list_two = new ArrayList<>();
        for (WebElement e : list_one){
            list_two.add(e.getText());
        }
        return list_two;
    }
}
