package pages.OrdersPages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddOrderPage extends BaseSeleniumPage {
    @FindBy(id="text-0-0")
    private WebElement input_name_field;
    @FindBy(xpath = "//*[.='Сохранить']")
    private WebElement save_btn;
    @FindBy(xpath = "//input[@placeholder='Выбрать...']")
    private WebElement select_contact_list;
    @FindBy(xpath = "//div[@class='select-dropdown-static']/child::div[2]")
    private WebElement select_contact;
    public AddOrderPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public OrderCardPage add_new_order (String new_order_name){
        wait.until(ExpectedConditions.elementToBeClickable(input_name_field)).sendKeys(new_order_name);
        wait.until(ExpectedConditions.elementToBeClickable(select_contact_list)).click();
        wait.until(ExpectedConditions.elementToBeClickable(select_contact)).click();
        wait.until(ExpectedConditions.elementToBeClickable(save_btn)).click();
        return new OrderCardPage();
    }
}
