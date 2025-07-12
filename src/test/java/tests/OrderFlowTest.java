package tests;


import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import pageobjects.MainPage;
import pageobjects.OrderPage;
import pageobjects.RentPage;


import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class OrderFlowTest extends BaseTest{

    private final String name;
    private final String lastName;
    private final String address;
    private final String phone;



    public OrderFlowTest(String name, String lastName, String address, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    @Parameterized.Parameters(name = "Тестовые данные: имя={0}, фамилия={1}, адрес={2}, телефон={3}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Иван", "Иванов", "Москва, ул. Пушкина", "89991234567"},
                {"Мария", "Петрова", "Санкт-Петербург, Невский пр.", "89997654321"}
        });
    }

    @Test
    public void testCreateOrderViaHeaderButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButtonHeader();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderForm(name, lastName, address, phone);
        orderPage.clickNextButton();

        RentPage rentPage = new RentPage(driver);
        rentPage.setDeliveryDate("17.07.2025");
        rentPage.selectRentPeriod("сутки");
        rentPage.selectColor("чёрный жемчуг");
        rentPage.enterComment("Позвоните за 5 минут");
        rentPage.clickOrderButtonFooter();

        rentPage.confirmOrder();

        Assert.assertTrue("Модальное окно с подтверждением заказа не отображается",
                rentPage.isOrderConfirmed());
    }

}