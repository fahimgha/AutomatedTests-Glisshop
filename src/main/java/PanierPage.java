import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class PanierPage {
    private WebDriver driver;
    private WebDriverWait wait;


    //By packSkiCategLocator = By.linkText("Pack ski alpin");
    //By passwordInputLocator = By.id("block2-password");
    public PanierPage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait=wait;
    }
    public void goToProductCategorie () {
        this.driver.get("https://www.glisshop.com/ski/pack-ski-fix/");
        WebElement cookieButton = this.driver.findElement(By.xpath("//*[@id=\"tarteaucitronPersonalize2\"]"));
        this.wait.until(ExpectedConditions.elementToBeClickable(cookieButton)).sendKeys(Keys.ENTER);
    }
    public void add() {

        this.driver.get("https://www.glisshop.com/pack-ski-fixations/black-crows/pack-ski-alpin-atris-fix18093567");


        WebElement addItem = this.driver.findElement(By.xpath("//*[@id=\"cartBox\"]/div/div/div[2]/button"));
        this.wait.until(ExpectedConditions.elementToBeClickable(addItem)).sendKeys(Keys.ENTER);

        WebElement confirmAddItem = this.driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div[4]/div[2]/a"));
        this.wait.until(ExpectedConditions.elementToBeClickable(confirmAddItem)).sendKeys(Keys.ENTER);
    }
}