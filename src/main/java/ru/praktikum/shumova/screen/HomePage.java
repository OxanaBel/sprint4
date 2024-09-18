package ru.praktikum.shumova.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadHeader() {
        new WebDriverWait(driver, Duration.ofMillis(3000L))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Home_Header__iJKdX")));
    }
}
