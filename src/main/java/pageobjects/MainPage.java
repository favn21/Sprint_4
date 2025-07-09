package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    private final By orderButtonHeader = By.className("Button_Button__ra12g");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }


}
