package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
    LoginPage objLogin;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        objLogin = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
        wait.until(ExpectedConditions.visibilityOf(objLogin.getLoginTitle()));
    }

    /*
     * Test to verify that all elements on the LoginPage are displayed correctly
     */
    @Test
    public void verify_Login_Page_Elements(){
        objLogin = new LoginPage(driver);
        Assert.assertTrue(objLogin.getLoginTitle().isDisplayed());
        Assert.assertTrue(objLogin.getBotImage().isDisplayed());
    }

    /*
     * Test to verify that user is able to input username and password
     */
    @Test
    public void verify_login_credential_input(){
        String username = "standard_user";
        String password = "secret_sauce";
        objLogin = new LoginPage(driver);
        objLogin.setUsername(username);
        objLogin.setPassword("secret_sauce");
        Assert.assertEquals(objLogin.getUsername().getAttribute("value"), username);
        Assert.assertNotEquals(objLogin.getPassword(), password);
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
