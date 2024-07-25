package pages.OrdersPages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class OrderCardPage extends BaseSeleniumPage {
    private By order_name_field_By = By.xpath("//div[@data-field_id='order_name']/child::div");
    private By edit_btn_By = By.xpath("//span[text()='Редактировать']");
    private By status_name_By = By.xpath("//button[@class='field-open']/child::span[@class='text']");
    private By add_menu_btn_By = By.xpath("//div[@class='additional-menu-icon']");
    private By delete_btn_By = By.xpath("//span[text()='Удалить']");
    private By yes_btn_By = By.xpath("//span[text()='Да']");
    private By go_back_btn_By = By.xpath("//span[text()='Назад']");

    public OrderCardPage(){
    }
    public String get_order_card_URL(){
        return driver.getCurrentUrl();
    }
    public String get_order_card_name(){
        WebElement e = driver.findElement(order_name_field_By);
        return e.getText();
    }
    public EditOrderCardPage edit_order(){
        driver.findElement(edit_btn_By).click();
        return new EditOrderCardPage();
    }
    public MainOrdersPage delete_order(){
        driver.findElement(add_menu_btn_By).click();
        driver.findElement(delete_btn_By).click();
        driver.findElement(yes_btn_By).click();
        return new MainOrdersPage();
    }
    public MainOrdersPage go_back_to_main_o_page(){
        driver.findElement(go_back_btn_By).click();
        return new MainOrdersPage();
    }
}
