import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginBtn = By.id("login-button");

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    public void writeUsername(String username) {
        driver.findElement(userField).clear();
        driver.findElement(userField).sendKeys(username);
    }

    public void writePassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitForm() {
        driver.findElement(loginBtn).click();
    }

    public void fullLogin(String username, String password) throws InterruptedException {
        writeUsername(username);
        writePassword(password);
        submitForm();
    }
}
