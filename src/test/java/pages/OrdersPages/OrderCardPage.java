package pages.OrdersPages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderCardPage extends BaseSeleniumPage {
    @FindBy(xpath = "//div[@data-field_id='order_name']/child::div")
    private WebElement order_name_field;
    @FindBy(xpath = "//span[text()='Редактировать']")
    private WebElement edit_btn;
    @FindBy(xpath = "//button[@class='field-open']/child::span[@class='text']")
    private WebElement status_name;
    @FindBy(xpath = "//div[@class='additional-menu-icon']")
    private WebElement add_menu_btn;
    @FindBy(xpath = "//span[text()='Удалить']")
    private WebElement delete_btn;
    @FindBy(xpath = "//span[text()='Да']")
    private WebElement yes_btn;
    @FindBy(xpath = "//span[text()='Назад']")
    private WebElement go_back_btn;

    public OrderCardPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
    public String get_order_card_URL(){
        wait.until(ExpectedConditions.elementToBeClickable(edit_btn));
        return driver.getCurrentUrl();
    }
    public String get_order_card_name(){
        wait.until(ExpectedConditions.elementToBeClickable(edit_btn));
        return order_name_field.getText();
    }
    public EditOrderCardPage edit_order(){
        wait.until(ExpectedConditions.elementToBeClickable(edit_btn)).click();
        return new EditOrderCardPage();
    }
    public MainOrdersPage delete_order(){
        wait.until(ExpectedConditions.elementToBeClickable(add_menu_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(delete_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(yes_btn)).click();
        return new MainOrdersPage();
    }
    public MainOrdersPage go_back_to_main_o_page(){
        wait.until(ExpectedConditions.elementToBeClickable(go_back_btn)).click();
        return new MainOrdersPage();
    }
}
