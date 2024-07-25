package pages;

import pages.OrdersPages.MainOrdersPage;
import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthPage extends BaseSeleniumPage {
    @FindBy (xpath = "//input[@placeholder=\"Логин\"]")
    private WebElement login_field;
    @FindBy (xpath = "//input[@placeholder=\"Пароль\"]")
    private WebElement password_field;

    public AuthPage(){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public MainOrdersPage authentification (String log_value, String pass_value){
        wait.until(ExpectedConditions.visibilityOf(login_field)).sendKeys(log_value);
        wait.until(ExpectedConditions.visibilityOf(password_field)).sendKeys(pass_value, Keys.ENTER);
        return new MainOrdersPage();
    }
}
