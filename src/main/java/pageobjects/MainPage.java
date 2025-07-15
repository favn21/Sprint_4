package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By orderButtonHeader = By.className("Button_Button__ra12g");
    private final By faqSection = By.className("Home_FAQ__3uVm4");
    private final By questionsLocator = By.className("accordion__button");
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final By orderButtonFooter = By.xpath("(//button[text()='Заказать'])[2]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    public void scrollToFaqSection() {
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(faqSection));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
    }

    private List<WebElement> getQuestions() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(questionsLocator));
    }



    public void clickQuestion(int index) {
        WebElement question = getQuestions().get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", question);
        wait.until(ExpectedConditions.elementToBeClickable(question)).click();
    }

    public String getAnswerText(int index) {
        By answerLocator = By.id("accordion__panel-" + index);
        WebElement answer = wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
        return answer.getText().trim();
    }

    public void scrollToOrderButtonFooter() {
        WebElement orderButton = driver.findElement(orderButtonFooter);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", orderButton);
    }

    public void clickOrderButtonFooter() {
        WebElement orderButton = wait.until(ExpectedConditions.elementToBeClickable(orderButtonFooter));
        orderButton.click();
    }
}
