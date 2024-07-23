package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseSeleniumPage {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static void set_driver(WebDriver web_driver){
        driver = web_driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

}
