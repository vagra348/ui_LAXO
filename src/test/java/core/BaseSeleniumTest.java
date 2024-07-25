package core;

import helpers.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DomenInputPage;
import pages.OrdersPages.MainOrdersPage;

import java.time.Duration;


abstract public class BaseSeleniumTest {
    protected static WebDriver driver;

    protected MainOrdersPage mainOrdersPage;

    @BeforeAll
    public static void test_beginning() {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeForTesting\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.setBinary("D:\\ChromeForTesting\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        BaseSeleniumPage.set_driver(driver);
    }

    @BeforeEach
    public void domen_and_login(){
        mainOrdersPage = new DomenInputPage()
                .input_domen_name(Config.domen_value)
                .authentification(Config.login, Config.password);
    }
    @AfterEach
    public void tear_down(){
        driver.close();
        driver.quit();
    }
}