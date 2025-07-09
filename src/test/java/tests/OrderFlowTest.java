package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.MainPage;
import pageobjects.OrderPage;
import pageobjects.RentPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class OrderFlowTest {
    private WebDriver driver;

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

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Иван", "Иванов", "Москва, ул. Пушкина", "89991234567"},
                {"Мария", "Петрова", "Санкт-Петербург, Невский пр.", "89997654321"}
        });
    }

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void testCreateOrderViaHeaderButton() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButtonHeader();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderForm(name, lastName, address, phone);
        orderPage.clickNextButton(); // Переход на шаг "Про аренду"

        RentPage rentPage = new RentPage(driver);
        rentPage.setDeliveryDate("17.07.2025");
        Thread.sleep(10000);
        rentPage.selectRentPeriod("сутки");
        Thread.sleep(10000);
        rentPage.selectColor("чёрный жемчуг");
        Thread.sleep(10000);
        rentPage.enterComment("Позвоните за 5 минут");
        Thread.sleep(10000);
        rentPage.clickOrderButtonFooter();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Да']")));
        confirmButton.click();

        WebElement confirmationModal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(), 'Заказ оформлен')]")));
        Assert.assertTrue("Модальное окно с подтверждением заказа не отображается", confirmationModal.isDisplayed());

      }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}