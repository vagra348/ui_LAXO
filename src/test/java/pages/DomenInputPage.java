package pages;

import core.BaseSeleniumPage;
import helpers.TestData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DomenInputPage extends BaseSeleniumPage {
    @FindBy(name="user_domain")
    private WebElement domen_input_field;

    public DomenInputPage (){
        driver.get(TestData.domen_input_link);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public AuthPage input_domen_name(String domen_name){
        wait.until(ExpectedConditions.visibilityOf(domen_input_field)).sendKeys(domen_name, Keys.ENTER);
        return new AuthPage();
    }
}
