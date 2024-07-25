package pages.OrdersPages;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;

public class EditOrderCardPage extends BaseSeleniumPage {
    private By name_field_By = By.id("text-0-0");
    private By save_btn_By = By.xpath("//button[text()='Сохранить']");

    public EditOrderCardPage(){
    }

    public EditOrderCardPage edit_order_name(){
        driver.findElement(name_field_By).sendKeys("Changed_name");
        return this;
    }

    public OrderCardPage save_changes(){
        driver.findElement(save_btn_By).click();
        return new OrderCardPage();
    }
}
