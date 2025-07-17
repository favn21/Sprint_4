package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class RentPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public RentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By dateInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By dateToSelect = By.cssSelector("div.react-datepicker__day--017");

    private final By rentDropdown = By.cssSelector("div.Dropdown-placeholder");
    private final By rentOptionSutki = By.xpath("//div[@class='Dropdown-option' and text()='сутки']");

    private final By colorCheckboxBlack = By.id("black");

    private final By commentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");

    private final By orderButtonFooter = By.xpath("//button[text()='Заказать' and contains(@class,'Button_Middle__1CSJM')]");
    private final By confirmButton = By.xpath("//button[text()='Да']");
    private final By confirmationModal = By.xpath("//div[contains(text(), 'Заказ оформлен')]");
    public void setDeliveryDate(String date) {
        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(dateInput));
        dateField.click();
        wait.until(ExpectedConditions.elementToBeClickable(dateToSelect)).click();
    }

    public void selectRentPeriod(String period) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(rentDropdown));
        dropdown.click();
        wait.until(ExpectedConditions.elementToBeClickable(rentOptionSutki)).click();
    }

    public void selectColor(String color) {
        if ("чёрный жемчуг".equalsIgnoreCase(color)) {
            wait.until(ExpectedConditions.elementToBeClickable(colorCheckboxBlack)).click();
        }
    }

    public void enterComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }

    public void clickOrderButtonFooter() {
        wait.until(ExpectedConditions.elementToBeClickable(orderButtonFooter)).click();
    }

    public void confirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
    }

    public boolean isOrderConfirmed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationModal)).isDisplayed();
    }
    public void fillRentPage() {
        setDeliveryDate("17.07.2025");
        selectRentPeriod("сутки");
        selectColor("чёрный жемчуг");
        enterComment("Позвоните за 5 минут");
    }

}