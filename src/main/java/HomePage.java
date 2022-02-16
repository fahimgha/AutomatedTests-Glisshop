import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "logo")
    private WebElement zenityLogo;
    public HomePage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements (this.driver, this);
    }
    public String getTitle() {
        return this.driver.getTitle();
    }
    public void goToHomePage() {
        this.driver.get("https://www.glisshop.com/");
    }
    public void checkCookie() {
        WebElement cookieButton = this.driver.findElement(By.xpath("//*[@id=\"tarteaucitronPersonalize2\"]"));
        this.wait.until(ExpectedConditions.elementToBeClickable(cookieButton)).sendKeys(Keys.ENTER);
    }
}
