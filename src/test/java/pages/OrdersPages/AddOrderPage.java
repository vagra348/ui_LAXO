package pages.OrdersPages;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddOrderPage extends BaseSeleniumPage {

    private By input_name_field_By = By.id("text-0-0");
    private By save_btn_By = By.xpath("//*[.='Сохранить']");
    private By select_contact_list_By = By.xpath("//input[@placeholder='Выбрать...']");
    private By select_contact_By = By.xpath("//div[@class='select-dropdown-static']/child::div[2]");

    public AddOrderPage(){
    }

    public OrderCardPage add_new_order (String new_order_name){
        driver.findElement(input_name_field_By).sendKeys(new_order_name);
        driver.findElement(select_contact_list_By).click();
        driver.findElement(select_contact_By).click();
        driver.findElement(save_btn_By).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Редактировать']"))));
        return new OrderCardPage();
    }
}
