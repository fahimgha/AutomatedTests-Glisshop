import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    By usernameInputLocator = By.xpath("//*[@id='block2-login']");
    By passwordInputLocator = By.id("block2-password");
    public LoginPage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait=wait;
    }
    public void goToLoginPage () {
        this.driver.get("https://www.glisshop.com/identification/");
    }
    public void login(String username, String password) {
        WebElement usernameInput = this.driver.findElement(this.usernameInputLocator);

        WebElement passwordInput = this.driver.findElement(this.passwordInputLocator);

        WebElement submitButton = this.driver.findElement(By.xpath("//*[@id='content-column']/div/div[2]/div[1]/div/div/div/div/div/form/fieldset/div/div[2]/div[1]/button"));
        WebElement cookieButton = this.driver.findElement(By.xpath("//*[@id=\"tarteaucitronPersonalize2\"]"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        this.wait.until(ExpectedConditions.elementToBeClickable(cookieButton)).sendKeys(Keys.ENTER);
        this.wait.until(ExpectedConditions.elementToBeClickable(submitButton)).sendKeys(Keys.ENTER);
    }
}