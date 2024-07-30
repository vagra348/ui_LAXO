package pages.ContactsPages;

import pages.OrdersPages.EditOrderCardPage;
import pages.OrdersPages.OrderCardPage;
import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditContactCardPage extends BaseSeleniumPage {
    @FindBy(id="text-0-0")
    private WebElement name_field;
    @FindBy(xpath = "//button[text()='Сохранить']")
    private WebElement save_btn;

    public EditContactCardPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public EditContactCardPage edit_contact_name(){
        wait.until(ExpectedConditions.visibilityOf(name_field)).sendKeys("Changed_name");
        return this;
    }
    public ContactCardPage save_changes(){
        wait.until(ExpectedConditions.elementToBeClickable(save_btn)).click();
        return new ContactCardPage();
    }
}
