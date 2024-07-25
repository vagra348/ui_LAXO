package pages;

import org.openqa.selenium.By;
import pages.OrdersPages.MainOrdersPage;
import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;

public class AuthPage extends BaseSeleniumPage {
    private By login_field_By = By.xpath("//input[@placeholder=\"Логин\"]");
    private By password_field_By = By.xpath("//input[@placeholder=\"Пароль\"]");

    public AuthPage(){
    }

    public MainOrdersPage authentification (String log_value, String pass_value){
        driver.findElement(login_field_By).sendKeys(log_value);
        driver.findElement(password_field_By).sendKeys(pass_value, Keys.ENTER);
        return new MainOrdersPage();
    }
}
