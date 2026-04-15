import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void loginCorrecto() throws InterruptedException {
        loginPage.fullLogin("standard_user", "secret_sauce");
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("inventory"));
    }

    @Test
    public void loginIncorrecto() throws InterruptedException {
        loginPage.fullLogin("fake_user", "fake_sauce");
        String url = driver.getCurrentUrl();
        assertFalse(url.contains("inventory"));
    }
}
