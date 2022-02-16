import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;


    By searchInputLocator = By.xpath("/html/body/header/div/div[1]/div/div[3]/div/form/div/input");
    public SearchPage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait=wait;
    }
    public void searchItem(String search) {
        WebElement searchInput = this.driver.findElement(this.searchInputLocator);
        WebElement searchButton = this.driver.findElement(By.xpath("/html/body/header/div/div[1]/div/div[3]/div/form/div/span/button"));
        searchInput.sendKeys(search);

        this.wait.until(ExpectedConditions.elementToBeClickable(searchButton)).sendKeys(Keys.ENTER);


    }

}
