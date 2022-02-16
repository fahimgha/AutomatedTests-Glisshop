import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class AppTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private SignUpPage signUpPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private SearchPage searchPage;
    // creation de compte + connexion + recherche d'article + mise au panier
    @Before
    public void setup() {
        String path = "/opt/homebrew/bin/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.loginPage = new LoginPage(this.driver, wait);
        this.signUpPage =new SignUpPage(this.driver, wait);
        this.homePage = new HomePage(this.driver, wait);
        this.searchPage = new SearchPage(this.driver, wait);
    }
    @After
    public void teardown() {
        this.driver.quit();
    }
    @Test
    public void loginUsingValidcredetentials () {
        SignUpPage signUpPage = new SignUpPage(this.driver, this.wait);
        LoginPage loginPage = new LoginPage(this.driver, this.wait);
        signUpPage.goToSignUpPage();
        signUpPage.signUp("tex0679tyyvv@gmail.com", "AAAzz22!","AAAzz22!");

        loginPage.goToLoginPage();
        loginPage.login("tex0679tyyvv@gmail.com", "AAAzz22!");
        homePage.goToHomePage();
        homePage.checkCookie();
        searchPage.searchItem("ski");
        //new WebDriverWait(driver,5).until(titleContains("Mon compte"));
        //assertEquals(this.driver.getTitle(), "Mon compte");
    }
}
