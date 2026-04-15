import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;
    private By sauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By sauceLabsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By itemNumber = By.cssSelector("shopping_cart_badge");
    private By redBalloon = By.cssSelector("shopping_cart_badge");
    private By buyinfBtn = By.cssSelector("shopping_cart_link");

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
        return !driver.findElements(redBalloon).isEmpty();
    }
}
