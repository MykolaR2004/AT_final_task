package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object representing the login page of the Saucedemo application.
 */
public class LoginPage {

    private final WebDriver driver;

    private final By username = By.xpath("//input[@id='user-name']");
    private final By password = By.xpath("//input[@id='password']");
    private final By loginBtn = By.xpath("//input[@id='login-button']");
    private final By error = By.xpath("//h3[@data-test='error']");

    /**
     * Creates a new instance of the LoginPage.
     *
     * @param driver active WebDriver instance
     */
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Opens the login page URL.
     */
    public void open(){
        driver.get("https://www.saucedemo.com/");
    }

    /**
     * Sets the username field.
     *
     * @param u username string
     */
    public void setUsername(String u){
        driver.findElement(username).sendKeys(u);
    }

    /**
     * Sets the password field.
     *
     * @param p password string
     */
    public void setPassword(String p){
        driver.findElement(password).sendKeys(p);
    }

    /**
     * Clears the username field.
     */
    public void clearUsername(){
        driver.findElement(username).clear();
    }

    /**
     * Clears the password field.
     */
    public void clearPassword(){
        driver.findElement(password).clear();
    }

    /**
     * Clicks the login button.
     */
    public void login(){
        driver.findElement(loginBtn).click();
    }

    /**
     * Retrieves the error message displayed on login failure.
     *
     * @return error message text
     */
    public String getError(){
        return driver.findElement(error).getText();
    }
}
