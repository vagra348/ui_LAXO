package pages.ContactsPages;

import pages.OrdersPages.MainOrdersPage;
import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactCardPage extends BaseSeleniumPage {
    @FindBy(xpath = "//div[@data-field_id='contact_name']/child::div")
    private WebElement contact_name_field;
    @FindBy(xpath = "//span[text()='Редактировать']")
    private WebElement edit_btn;
    @FindBy(xpath = "//div[@class='additional-menu-icon']")
    private WebElement add_menu_btn;
    @FindBy(xpath = "//span[text()='Удалить']")
    private WebElement delete_btn;
    @FindBy(xpath = "//span[text()='Да']")
    private WebElement yes_btn;
    @FindBy(xpath = "//span[text()='Назад']")
    private WebElement go_back_btn;
    public ContactCardPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
    public String get_contact_card_URL(){
        wait.until(ExpectedConditions.elementToBeClickable(edit_btn));
        return driver.getCurrentUrl();
    }
    public EditContactCardPage edit_contact(){
        wait.until(ExpectedConditions.elementToBeClickable(edit_btn)).click();
        return new EditContactCardPage();
    }
    public String get_contact_name(){
        wait.until(ExpectedConditions.visibilityOf(contact_name_field));
        return contact_name_field.getText();
    }
    public MainContactsPage delete_contact(){
        wait.until(ExpectedConditions.elementToBeClickable(add_menu_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(delete_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(yes_btn)).click();
        return new MainContactsPage();
    }
    public MainContactsPage go_back_to_main_c_page(){
        wait.until(ExpectedConditions.elementToBeClickable(go_back_btn)).click();
        return new MainContactsPage();
    };
}
