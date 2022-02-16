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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;


public class JunitTest {

    // Déclaration de la variable de classe de type WebDriver
    private WebDriver driver;
    // Déclaration de la variable de classe de type WebDriverWait
    private WebDriverWait wait;

    @Before
    public void setup() {
        // Définition du chemin du ChromeDriver dans les proprietes du
        String path = "/opt/homebrew/bin/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        // Association de l’instance de classe ChromeDriver au WebDriver
        this.driver = new ChromeDriver();
        // Instanciation du Selenium WebDriverWait avec le WebDriver pour une durée de 5 secondes
        this.wait = new WebDriverWait(this.driver,Duration.ofSeconds(5));
        // Définition de l'attente implicite du WebDriver à 10 secondes
        this.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @After
    public void teardown() {
// Fermeture du navigateur et de la session
       // this.driver.quit();
    }
    @Test
    public void navigationTest() {
// Navigation vers l'url du site à tester
        this.driver.get("https://www.glisshop.com/identification/");

        // Assertion sur le titre de la page de connexion
        assertEquals(this.driver.getTitle(), "Identification") ;
        // Recherche d'éléments avec l'objet By
        By usernameInputLocator = By.xpath(" //*[@id='block2-login']");
        WebElement usernameInput = this.driver.findElement(usernameInputLocator);
        By passwordInputLocator = By.id("block2-password");

        WebElement passwordInput =
                this.driver.findElement(passwordInputLocator);
        // Recherche d'élément avec l'objet RelativeLocator
        WebElement submitButton = this.driver.findElement(By.xpath("//*[@id='content-column']/div/div[2]/div[1]/div/div/div/div/div/form/fieldset/div/div[2]/div[1]/button"));


// Définition de la valeur des input
        usernameInput.sendKeys("identifiant");
        passwordInput.sendKeys("motDePasse");
// Attente explicite de l'etat cliquable de l'élément
        this.wait.until(ExpectedConditions.elementToBeClickable(submitButton));
// Clic sur un élément
        submitButton.sendKeys(Keys.ENTER);
// Assertion sur le titre de la page d'accueil
        assertTrue(this.driver.getTitle().equals("Identification"));}

}
