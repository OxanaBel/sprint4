package ru.praktikum.shumova;

import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.praktikum.shumova.screen.OrderForm;

public class CheckOrderTest {
    private static WebDriver driver;
    private static OrderForm orderForm;

    @Before
    public void setUp() {
        initChrome();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        orderForm = new OrderForm(driver);
        orderForm.waitForLoadHeader();
    }

    //Кнопка заказать сверху
    @Test
    public void CheckOrderTopOfPage() {
        driver.findElement(orderForm.getOrderTopOfPage()).click();
        orderForm.allInformation("Имя", "Фамилия", "Энгельса 40", "89993334444");
        orderForm.allInformationStepTwo("Коммент");
        orderForm.confirmOrder();
        orderForm.checkOrder();
    }

    //Кнопка заказать снизу
    @Test
    public void CheckOrderBottomOfPage() {
        WebElement element = driver.findElement(orderForm.getOrderBottomOfPage());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderForm.getOrderBottomOfPage()).click();
        orderForm.allInformation("Имя", "Фамилия", "Энгельса 40", "89993334444");
        orderForm.allInformationStepTwo("Коммент");
        orderForm.confirmOrder();
        orderForm.checkOrder();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public static void initChrome() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    public static void initFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
    }
}
