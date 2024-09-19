package ru.praktikum.shumova;

import org.junit.*;
import ru.praktikum.shumova.screen.MainPage;
import ru.praktikum.shumova.screen.OrderPage;

import static org.junit.Assert.assertTrue;

public class CheckOrderTest extends BaseTest {

    //Кнопка заказать сверху
    @Test
    public void checkOrderTopOfPage() {
        MainPage mainPage = getMainPage();
        mainPage.clickOrderTopOfPage();
        OrderPage orderPage = getOrderPage();
        orderPage.allInformation("Имя", "Фамилия", "Энгельса 40", "89993334444");
        orderPage.allInformationStepTwo("Коммент");
        orderPage.confirmOrder();
        orderPage.checkOrder();
        assertTrue(orderPage.getElement(orderPage.getOrderCard()).isDisplayed());
    }

    //Кнопка заказать снизу
    @Test
    public void checkOrderBottomOfPage() {
        MainPage mainPage = getMainPage();
        mainPage.scrollIntoOrderBottomOfPage();
        mainPage.clickOrderBottomOfPage();
        OrderPage orderPage = getOrderPage();
        orderPage.allInformation("Имя", "Фамилия", "Энгельса 40", "89993334444");
        orderPage.allInformationStepTwo("Коммент");
        orderPage.confirmOrder();
        orderPage.checkOrder();
        assertTrue(getOrderPage().getElement(getOrderPage().getOrderCard()).isDisplayed());
    }
}
