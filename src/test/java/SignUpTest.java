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
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;


public class SignUpTest {


    private WebDriver driver;
    private WebDriverWait wait;
    private SignUpPage signUpPage;
    private HomePage homePage;

    @Before
    public void setup() {
        String path = "/opt/homebrew/bin/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);

        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.signUpPage = new SignUpPage(this.driver, wait);
        this.homePage = new HomePage(this.driver, wait);
    }
    @After
    public void teardown() {
        //this.driver.quit();
    }
    @Test
    public void signUpUsingValidcredetentials () {
        SignUpPage signUpPage = new SignUpPage(this.driver, this.wait);
        HomePage homePage = new HomePage(this.driver, this.wait);
        signUpPage.goToSignUpPage();
        //homePage.checkCookie();
        signUpPage.signUp("tex0679tyvv@gmail.com", "AAAzz22!","AAAzz22!");
        new WebDriverWait(driver,5);
        WebElement test2 = this.driver.findElement(By.xpath("//*[@id=\"content-column\"]/div/div[2]/div/div/div/div[1]/div/div[2]"));
        assertTrue(test2.isDisplayed());

        //assertEquals(this.driver.getTitle(), "Création de compte");
        //assertNotEquals(this.driver.getTitle(),"Création de compte");
    }
    /*@Test
    public void signUpUsingInvalidcredetentials () {
        SignUpPage signUpPage = new SignUpPage(this.driver, this.wait);
        signUpPage.goToSignUpPage();
        signUpPage.signUp("invalidUsername", "AAAzz22!", "AAAzz22!");
        new WebDriverWait(driver,7);
        assertTrue(this.driver.getTitle().equals("Création de compte"));
    }
    @Test
    public void signUpUsingExistingUsername () {
        SignUpPage signUpPage = new SignUpPage(this.driver, this.wait);
        signUpPage.goToSignUpPage();
        signUpPage.signUp("testtes33344st@gmail.com", "AAAzz22!", "AAAzz22!");
        new WebDriverWait(driver,5);
        assertTrue(this.driver.getTitle().equals("Création de compte"));
    }
    @Test
    public void signUpUsingInvalidpassword () {
        SignUpPage signUpPage = new SignUpPage(this.driver, this.wait);
        signUpPage.goToSignUpPage();
        signUpPage.signUp("testt33333t7@gmail.com", "AAAzz22!", "AAAzz44!");
        new WebDriverWait(driver,5);
        assertTrue(this.driver.getTitle().equals("Création de compte"));
    }*/
}
