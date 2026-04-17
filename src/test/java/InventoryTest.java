import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void anadirUnProductoAlCarrito() throws InterruptedException {
        loginPage.fullLogin("standard_user", "secret_sauce");
        inventoryPage.anadirBackpack();
        Thread.sleep(2000);
        assertEquals(1, inventoryPage.checkItemNumber());
    }

    @Test
    public void anadirDosProductosAlCarrito() throws InterruptedException {
        loginPage.fullLogin("standard_user", "secret_sauce");
        inventoryPage.anadirBackpack();
        inventoryPage.anadirBikeLight();
        Thread.sleep(2000);
        assertEquals(2, inventoryPage.checkItemNumber());
    }


}
