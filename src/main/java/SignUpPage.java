import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignUpPage {
    private WebDriver driver;
    private WebDriverWait wait;


    By usernameInputLocator = By.xpath(" //*[@id='rbs-user-create-account-email']");
    By passwordInputLocator = By.id("rbs-user-create-account-password");
    By confirmPasswordInputLocator = By.id("rbs-user-create-account-confirm-password");
    public SignUpPage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait=wait;
    }
    public void goToSignUpPage () {
        this.driver.get("https://www.glisshop.com/glisshop/creation-de-compte.html");
    }
    public void signUp(String username, String password, String confirmPassword) {
        WebElement usernameInput = this.driver.findElement(this.usernameInputLocator);

        WebElement passwordInput = this.driver.findElement(this.passwordInputLocator);

        WebElement confirmPasswordInput = this.driver.findElement(this.confirmPasswordInputLocator);
        WebElement submitButton = this.driver.findElement(By.xpath("//*[@id=\"content-column\"]/div/div[2]/div/div/div/div[1]/div/form/fieldset[2]/div/button"));
        WebElement cookieButton = this.driver.findElement(By.xpath("//*[@id=\"tarteaucitronPersonalize2\"]"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
        this.wait.until(ExpectedConditions.elementToBeClickable(cookieButton)).sendKeys(Keys.ENTER);
        this.wait.until(ExpectedConditions.elementToBeClickable(submitButton)).sendKeys(Keys.ENTER);
    }
}
