import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class PanierTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private PanierPage panierPage;
    private HomePage homePage;
    @Before
    public void setup() {
        String path = "/opt/homebrew/bin/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);

        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.panierPage = new PanierPage(this.driver, wait);
        this.homePage = new HomePage(this.driver, wait);
    }
    @After
    public void teardown() {
        //this.driver.quit();
    }
    @Test
    public void addItemToCart() {
        PanierPage panierPage = new PanierPage(this.driver, this.wait);
        HomePage homePage = new HomePage(this.driver, this.wait);
        homePage.goToHomePage();
        homePage.checkCookie();
        panierPage.goToProductCategorie();
        homePage.checkCookie();
        panierPage.add();
        //new WebDriverWait(driver,5).until(titleContains("Glisshop - achat ski, vente matériel de ski, ski nordique et snowboard"));
        WebElement test = this.driver.findElement(By.xpath("//*[@id=\"content-column\"]/div/div[10]/div[1]/div/div[1]/div[3]/div/div[2]/table/tbody"));
        new WebDriverWait(driver,5);
        assertTrue(test.isDisplayed());
    }
}
