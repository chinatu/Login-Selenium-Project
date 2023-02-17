package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    LoginPage objLogin;

    String username = "standard_user";
    String password = "secret_sauce";

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
    @Test (priority = 0)
    public void verify_Login_Page_Elements(){
        objLogin = new LoginPage(driver);
        Assert.assertTrue(objLogin.getLoginTitle().isDisplayed());
        Assert.assertTrue(objLogin.getBotImage().isDisplayed());
    }

    /*
     * Test to verify that user is able login successfully
     */
    @Test (priority = 1)
    public void verify_successful_login() throws InterruptedException {
        objLogin = new LoginPage(driver);
        objLogin.setUsername(username);
        objLogin.setPassword(password);
        objLogin.clickLogin();
        Assert.assertTrue(objLogin.getHomePageTitle().isDisplayed());
        Assert.assertTrue(objLogin.getMenuBtn().isDisplayed());
        objLogin.getMenuBtn().click();
        Thread.sleep(2000);
        objLogin.getLogoutBtn().click();
        Thread.sleep(2000);
    }

    @Test (priority = 2)
    public void verify_locked_out_user(){
        objLogin.setUsername("locked_out_user");
        objLogin.setPassword(password);
        objLogin.clickLogin();
        Assert.assertTrue(objLogin.getErrorMessage().contains("Sorry, this user has been locked out."), "The error message does not contain text");

    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
