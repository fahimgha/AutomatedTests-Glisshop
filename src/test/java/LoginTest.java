import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private HomePage homePage;
    @Before
    public void setup() {
        String path = "/opt/homebrew/bin/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.loginPage = new LoginPage(this.driver, wait);
        this.homePage = new HomePage(this.driver, wait);
    }
    @After
    public void teardown() {
        this.driver.quit();
    }
    @Test
    public void loginUsingValidcredetentials () {
        LoginPage loginPage = new LoginPage(this.driver, this.wait);
        loginPage.goToLoginPage();
        loginPage.login("ror17@kruay.com", "Testtest1!");
        new WebDriverWait(driver,5).until(titleContains("Mon compte"));
        assertEquals(this.driver.getTitle(), "Mon compte");
    }
    @Test
    public void loginUsingInvalidPassword () {
        LoginPage loginPage = new LoginPage(this.driver, this.wait);
        loginPage.goToLoginPage();
        loginPage.login("civon21745@chinamkm.com", "e");
        new WebDriverWait(driver,5);
        assertNotEquals(this.driver.getTitle(), "Mon compte");
    }
}
