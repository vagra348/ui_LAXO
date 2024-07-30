package pages.ContactsPages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddContactPage extends BaseSeleniumPage {
    @FindBy(id="text-0-0")
    private WebElement input_name_field;
    @FindBy(xpath = "//*[.='Сохранить']")
    private WebElement save_btn;

    public AddContactPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public ContactCardPage add_new_contact (String new_contact_name){
        wait.until(ExpectedConditions.visibilityOf(input_name_field)).sendKeys(new_contact_name);
        wait.until(ExpectedConditions.elementToBeClickable(save_btn)).click();
        return new ContactCardPage();
    }
}
