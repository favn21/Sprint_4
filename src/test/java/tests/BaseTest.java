package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.MainPage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(MainPage.BASE_URL); ;
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
