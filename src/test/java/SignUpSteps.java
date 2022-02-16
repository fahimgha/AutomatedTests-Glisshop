import io.cucumber.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class SignUpSteps implements En {
    private WebDriver driver;
    private SignUpPage signUpPage;
    private HomePage homePage;
    public SignUpSteps() {
        Before(() -> {
            String path = "/opt/homebrew/bin/chromedriver";
            System.setProperty("webdriver.chrome.driver", path);
            this.driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
            this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.signUpPage = new SignUpPage(this.driver, wait);
            this.homePage = new HomePage(this.driver, wait);
        });
        Given("^user is at the sign up page$", () -> {
            this.signUpPage.goToSignUpPage();

        });

        When ("^user is sign-up with (.*) (.*) (.*)$", (String username, String password, String confirmPassword) ->{
            this.signUpPage.signUp(username, password,confirmPassword);
        });
        Then("^he should be at the account page Then$", () -> {
            new WebDriverWait(driver,5);
            WebElement test2 = this.driver.findElement(By.xpath("//*[@id=\"content-column\"]/div/div[2]/div/div/div/div[1]/div/div[2]"));
            assertTrue(test2.isDisplayed());
            //assertEquals(this.driver.getTitle(), "Création de compte");
            //assertTrue(driver.getCurrentUrl().equals("https://www.glisshop.com/mon-compte/mon-compte.html"));
            // Write code here that turns the phrase above into concrete actions
        });
    }
}
