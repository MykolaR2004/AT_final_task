package com.example.tests;

import com.example.driver.DriverFactory;
import com.example.pages.LoginPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for validating login functionality of Saucedemo.
 */
public class LoginTests {

    /**
     * UC1: Checks that logging in with empty credentials
     * shows the expected validation message.
     *
     * @param browser name of the browser used for test execution
     */
    @ParameterizedTest
    @ValueSource(strings = {"firefox"})
    void testUC1_emptyCredentials(String browser){
        WebDriver driver = DriverFactory.create(browser);
        try {
            LoginPage page = new LoginPage(driver);
            page.open();

            page.setUsername("abc");
            page.setPassword("123");

            page.clearUsername();
            page.clearPassword();

            page.login();

            assertThat(page.getError()).contains("Username is required");

        } finally {
            driver.quit();
        }
    }

    /**
     * UC2: Checks that omitting the password triggers
     * the correct validation error.
     *
     * @param browser name of the browser used for test execution
     */
    @ParameterizedTest
    @ValueSource(strings = {"firefox"})
    void testUC2_missingPassword(String browser){
        WebDriver driver = DriverFactory.create(browser);
        try {
            LoginPage page = new LoginPage(driver);
            page.open();

            page.setUsername("abc");
            page.setPassword("123");

            page.clearPassword();
            page.login();

            assertThat(page.getError()).contains("Password is required");

        } finally {
            driver.quit();
        }
    }

    /**
     * UC3: Checks that logging in with valid credentials
     * leads to successful navigation to the application.
     *
     * @param browser name of the browser used for test execution
     */
    @ParameterizedTest
    @ValueSource(strings = {"firefox"})
    void testUC3_validCredentials(String browser){
        WebDriver driver = DriverFactory.create(browser);
        try {
            LoginPage page = new LoginPage(driver);
            page.open();

            page.setUsername("standard_user");
            page.setPassword("secret_sauce");

            page.login();

            assertThat(driver.getTitle()).contains("Swag Labs");

        } finally {
            driver.quit();
        }
    }
}
