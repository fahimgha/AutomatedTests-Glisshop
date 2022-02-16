import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class SearchItem {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private SearchPage searchPage;
    @Before
    public void setup() {
        String path = "/opt/homebrew/bin/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);

        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.homePage = new HomePage(this.driver, wait);
        this.searchPage = new SearchPage(this.driver, wait);
    }
    @After
    public void teardown() {
        this.driver.quit();
    }
    @Test
    public void searchProduct() {

        HomePage homePage = new HomePage(this.driver, this.wait);
        SearchPage searchPage = new SearchPage(this.driver, this.wait);
        homePage.goToHomePage();
        homePage.checkCookie();
        searchPage.searchItem("0");
        new WebDriverWait(driver,5).until(titleContains("Résultat de recherche - produits"));
        //assertEquals(this.driver.findElement(By.id("df-u5gztjax")), );
        //String ActualTitle = driver.findElement(By.id("df-u5gztjax")).toString();
        //String ExpectedTitle = "df-u5gztjax";
        //assertEquals(ExpectedTitle, ActualTitle);
        WebElement ExpectedTitle = this.driver.findElement(By.id("df-results__embedded"));
        new WebDriverWait(driver,5);
        assertTrue(ExpectedTitle.isDisplayed());
    }
}
