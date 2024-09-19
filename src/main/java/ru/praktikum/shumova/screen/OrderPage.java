package ru.praktikum.shumova.screen;

import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class OrderPage {
    private final WebDriver driver;
    //Первый этап заказа
    private By fieldName = By.xpath("//input[@placeholder='* Имя']");
    private By lastNameField = By.xpath("//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroField = By.xpath("//input[@placeholder='* Станция метро']");
    private By phoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By continueButton = By.className("Button_Middle__1CSJM");
    //Второй этап заказа
    private By deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By nextMonthButton = By.className("react-datepicker__navigation--next");
    private By deliveryDay = By.className("react-datepicker__week");
    private By rentPeriod = By.className("Dropdown-placeholder");
    private By rentPeriodList = By.className("Dropdown-menu");
    private By rentalPeriod = By.xpath(".//div[text()='сутки']");
    private By blackScooterColor = By.id("black");
    private By greyScooterColor = By.id("grey");
    private By commentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Последний этап
    private By confirmationPopup = By.className("Order_Modal__YZ-d3");
    private By confirmOrderButton = By.xpath("//div[@class='Order_Modal__YZ-d3']/div/button[text()='Да']");
    private By successOrderPopup = By.className("Track_OrderInfo__2fpDL");
    private By orderStatus = By.className("Order_ModalHeader__3FDaJ");
    private By orderStatusButton = By.xpath("//div[@class='Order_Modal__YZ-d3']/div/button[text()='Посмотреть статус']");
    private By orderStatusHeader = By.className("Order_ModalHeader__3FDaJ");
    private By orderCard = By.className("Track_Row__1sN1F");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы первого этапа заказа
    public void setFillName(String firstName) {
        driver.findElement(fieldName).sendKeys(firstName);
    }

    public void setFillLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setFillAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void chooseSubway() {
        driver.findElement(metroField).click();
        driver.findElement(metroField).sendKeys(Keys.DOWN, Keys.ENTER);
    }

    public void setFillPhone(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void allInformation(String firstName, String lastName, String address, String phoneNumber) {
        setFillName(firstName);
        setFillLastName(lastName);
        setFillAddress(address);
        chooseSubway();
        setFillPhone(phoneNumber);
        clickContinueButton();
    }

    //Методы второго этапа заказа
    public void fillComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    public void allInformationStepTwo(String comment) {
        driver.findElement(deliveryDate).click();
        driver.findElement(nextMonthButton).click();
        driver.findElement(deliveryDay).click();
        driver.findElement(rentPeriod).click();
        driver.findElement(rentPeriodList).isEnabled();
        driver.findElement(rentalPeriod).click();
        driver.findElement(greyScooterColor).click();
        fillComment(comment);
        driver.findElement(orderButton).click();
    }

    public void confirmOrder() {
        new WebDriverWait(driver, Duration.ofMillis(3000L))
                .until(ExpectedConditions.visibilityOfElementLocated(confirmationPopup));
        driver.findElement(confirmOrderButton).click();
    }

    public void checkOrder() {
        driver.findElement(orderStatusButton).click();
        new WebDriverWait(driver, Duration.ofMillis(3000L))
                .until(ExpectedConditions.visibilityOfElementLocated(orderCard));
    }

    public WebElement getElement(By by) {
        return driver.findElement(by);
    }
}
