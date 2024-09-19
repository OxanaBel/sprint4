package ru.praktikum.shumova.screen;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class MainPage {
    public static final String MAIN_URL = "https://qa-scooter.praktikum-services.ru/";

    private final WebDriver driver;
    private By orderTopOfPage = By.className("Button_Button__ra12g");
    private By orderBottomOfPage = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private By listOfQuestions = By.className("accordion");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadHeader() {
        new WebDriverWait(driver, Duration.ofMillis(3000L))
                .until(ExpectedConditions.visibilityOfElementLocated(orderBottomOfPage));
    }

    public void scrollIntoQuestions() {
        WebElement element = driver.findElement(listOfQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickQuestion(String number) {
        driver.findElement(By.id("accordion__heading-" + number)).click();
    }

    public String getAnswer(String number) {
        String elementId = "accordion__panel-";
        new WebDriverWait(driver, Duration.ofMillis(3000L))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId + number)));
        return driver.findElement(By.id(elementId + number)).getText();
    }

    public String getQuestion(String number) {
        return driver.findElement(By.id("accordion__heading-" + number)).getText();
    }

    public void scrollIntoOrderBottomOfPage() {
        WebElement element = driver.findElement(orderBottomOfPage);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickOrderTopOfPage() {
        driver.findElement(orderTopOfPage).click();
    }

    public void clickOrderBottomOfPage() {
        driver.findElement(orderBottomOfPage).click();
    }
}
