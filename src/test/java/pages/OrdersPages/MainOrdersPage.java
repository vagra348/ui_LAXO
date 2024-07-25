package pages.OrdersPages;

import core.BaseSeleniumPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MainOrdersPage extends BaseSeleniumPage {
    //Используемые элементы из DOM: кнопки, иконки, текстовые поля
    @FindBy(xpath = "//div[contains(@class,'crm-component--second-header')]/descendant::a[@href='/orders/add']")
    private WebElement add_order_btn;
    @FindBy(xpath = "//div[@id='swiper']/child::div[1]/descendant::div[@class='dealings-preview__title'][1]/child::a")
    private WebElement first_order_in_first_column;


    //Конструктор
    public MainOrdersPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    //Пользовательские методы

    public AddOrderPage open_add_order_card(){
        wait.until(ExpectedConditions.elementToBeClickable(add_order_btn)).click();
        return new AddOrderPage();
    }
    public OrderCardPage open_order(){ //нужно переписать н
        wait.until(ExpectedConditions.elementToBeClickable(first_order_in_first_column)).click();
        return new OrderCardPage();
    }
    public OrderCardPage open_order(String name_value){
        String order_xpath = "//*[text()='"+name_value+"']";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(order_xpath))).click();
        return new OrderCardPage();
    }
    public List<String> get_list_of_orders(){
        List<WebElement> list_one = driver.findElements(By.xpath("//div[@class='dealings-preview__title']/descendant::span"));
        List<String> list_two = new ArrayList<>();
        for (WebElement e : list_one){
            list_two.add(e.getText());
        }
        return list_two;
    }
}
