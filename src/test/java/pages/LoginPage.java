package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginBtn = By.id("login-button");
    By loginTitle = By.className("login_logo");
    By botImage = By.className("bot_column");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String strUserName){
        driver.findElement(usernameField).sendKeys(strUserName);
    }

    public String getUsernameText(){
        return driver.findElement(usernameField).getText();
    }

    public WebElement getUsername(){
        return driver.findElement(usernameField);
    }

    public void setPassword(String strPassword){
        driver.findElement(passwordField).sendKeys(strPassword);
    }

    public String getPassword(){
        return driver.findElement(passwordField).getText();
    }

    public void clearField(WebElement fieldName){
        fieldName.clear();
    }

    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }

    public WebElement getLoginTitle(){
        return driver.findElement(loginTitle);
    }

    public WebElement getBotImage(){
        return driver.findElement(botImage);
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUsername
     * @param strPassword
     * @return
     */

    public void loginToPage(String strUsername,String strPassword){

        this.setUsername(strUsername);
        this.setPassword(strPassword);
        this.clickLogin();
    }
}
