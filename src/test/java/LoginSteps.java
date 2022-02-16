import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class LoginSteps implements En {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    public LoginSteps() {
        Before(() -> {
            String path = "/opt/homebrew/bin/chromedriver";
            System.setProperty("webdriver.chrome.driver", path);
            this.driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
            this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.loginPage = new LoginPage(this.driver, wait);
            this.homePage = new HomePage(this.driver, wait);
        });
        Given("^user is at the login page$", () -> {
            this.loginPage.goToLoginPage();

        });

        When ("^user is logging-in with (.*) (.*)$", (String username, String password) ->{
                this.loginPage.login(username, password);
        });
        Then("^he should be at the home page Then$", () -> {
            new WebDriverWait(driver,5).until(titleContains("Creation"));
            assertEquals(this.driver.getTitle(), "Mon compte");
            //assertTrue(driver.getCurrentUrl().equals("https://www.glisshop.com/mon-compte/mon-compte.html"));
            // Write code here that turns the phrase above into concrete actions

        });
    }
}
