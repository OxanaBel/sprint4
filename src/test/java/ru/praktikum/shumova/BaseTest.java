package ru.praktikum.shumova;

import lombok.Getter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.praktikum.shumova.screen.MainPage;
import ru.praktikum.shumova.screen.OrderPage;

import static ru.praktikum.shumova.screen.MainPage.MAIN_URL;

@Getter
public class BaseTest {
    private WebDriver driver;
    private MainPage mainPage;
    private OrderPage orderPage;

    @Before
    public void setUp() {
        initChrome();
        driver.get(MAIN_URL);
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
        mainPage.waitForLoadHeader();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void initChrome() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    public void initFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
    }
}
