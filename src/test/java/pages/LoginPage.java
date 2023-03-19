package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {

    private WebDriver driver;

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginBtn = By.id("login-button");
    By loginTitle = By.className("login_logo");
    By botImage = By.className("bot_column");
    By menuButton = By.id("react-burger-menu-btn");
    By homePageTitle = By.className("title");
    By logoutBtn = By.id("logout_sidebar_link");
    By errorMessage = By.cssSelector("h3[data-test='error']");
    By shoppingCartBadge = By.className("shopping_cart_badge");
    By shoppingCart = By.className("shopping_cart_link");
    By cartTitle = By.className("title");
    By addItem = By.className("btn_inventory");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String strUserName){
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(strUserName);
    }

    public String getUsernameText(){
        return driver.findElement(usernameField).getText();
    }

    public WebElement getUsername(){
        return driver.findElement(usernameField);
    }

    public void setPassword(String strPassword){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(strPassword);
    }

    public String getPasswordText(){
        return driver.findElement(passwordField).getText();
    }

    public WebElement getPassword(){
        return  driver.findElement(passwordField);
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

    public WebElement getMenuBtn(){
        return driver.findElement(menuButton);
    }

    public WebElement getHomePageTitle(){
        return driver.findElement(homePageTitle);
    }

    public WebElement getLoginBtn(){
        return driver.findElement(loginBtn);
    }

    public WebElement getLogoutBtn(){
        return driver.findElement(logoutBtn);
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    public List<WebElement> getItemAddBtn(){
        return driver.findElements(addItem);
    }

    public WebElement getShoppingCartBadge(){
        return driver.findElement(shoppingCartBadge);
    }

    public WebElement getShoppingCart(){
        return driver.findElement(shoppingCart);
    }

    public WebElement getCartTitle(){
        return driver.findElement(cartTitle);
    }
}
