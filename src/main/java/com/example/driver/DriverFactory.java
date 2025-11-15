package com.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Factory class responsible for creating WebDriver instances.
 */
public class DriverFactory {

    /**
     * Creates a WebDriver instance for the specified browser.
     * Currently supports only Firefox.
     *
     * @param browser name of the browser (e.g., "firefox")
     * @return configured WebDriver instance
     */
    public static WebDriver create(String browser) {
        WebDriver driver;
        driver = new FirefoxDriver();
        return driver;
    }
}
