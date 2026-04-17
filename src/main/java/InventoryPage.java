import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;
    private final By sauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By sauceLabsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By itemNumber = By.cssSelector("[data-test='shopping-cart-badge']");

    public InventoryPage (WebDriver driver) {
        this.driver = driver;
    }

    public void anadirBackpack() {
        driver.findElement(sauceLabsBackpack).click();
    }

    public void anadirBikeLight() {
        driver.findElement(sauceLabsBikeLight).click();
    }

    public int checkItemNumber() {
        return Integer.parseInt(driver.findElement(itemNumber).getText());
    }

    // Return true if exists
    public boolean checkIfExist() {
        return !driver.findElements(itemNumber).isEmpty();
    }
}
