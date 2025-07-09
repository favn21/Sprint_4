package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class QuestionsSectionTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void testAccordionQuestionOpens() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));


        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(70000);
        WebElement faqSection = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("Home_FAQ__3uVm4")
        ));


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", faqSection);

        Thread.sleep(70000);
        int index = 0;
        List<WebElement> questions = driver.findElements(By.className("accordion__button"));
        WebElement question = questions.get(index);

        wait.until(ExpectedConditions.elementToBeClickable(question)).click();


        WebElement answer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("accordion__panel-" + index)
        ));
        String answerText = answer.getText().trim();

        Assert.assertFalse("Ответ не должен быть пустым", answerText.isEmpty());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
