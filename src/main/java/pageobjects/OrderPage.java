package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    private final By nameInput = By.xpath("//input[@placeholder='* Имя']");
    private final By lastNameInput = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationInput = By.className("select-search__input");
    private final By metroStationSelectFirst = By.className("select-search__option");
    private final By phoneInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");


    private final By nextButton = By.xpath("//button[text()='Далее']");

    public void fillOrderForm(String name, String lastName, String address, String phone) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(addressInput).sendKeys(address);

        driver.findElement(metroStationInput).click();
        driver.findElement(metroStationSelectFirst).click();

        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}
