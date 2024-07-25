package pages;

import core.BaseSeleniumPage;
import helpers.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class DomenInputPage extends BaseSeleniumPage {
    private By domen_input_field_By = By.name("user_domain");

    public DomenInputPage (){
        driver.get(Config.domen_input_link);
    }

    public AuthPage input_domen_name(String domen_name){
        driver.findElement(domen_input_field_By).sendKeys(domen_name, Keys.ENTER);
        return new AuthPage();
    }
}
