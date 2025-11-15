package com.example.tests;

import com.example.driver.DriverFactory;
import com.example.pages.LoginPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTests {

    @ParameterizedTest
    @ValueSource(strings = {"firefox", "edge"})
    void testUC1_emptyCredentials(String browser){
        WebDriver driver = DriverFactory.create(browser);
        try {
            LoginPage p = new LoginPage(driver);
            p.open();
            p.setUsername("abc");
            p.setPassword("123");
            p.clearUsername();
            p.clearPassword();
            p.login();
            assertThat(p.getError()).contains("Username is required");
        } finally { driver.quit(); }
    }

    @ParameterizedTest
    @ValueSource(strings = {"firefox", "edge"})
    void testUC2_missingPassword(String browser){
        WebDriver driver = DriverFactory.create(browser);
        try {
            LoginPage p = new LoginPage(driver);
            p.open();
            p.setUsername("abc");
            p.setPassword("123");
            p.clearPassword();
            p.login();
            assertThat(p.getError()).contains("Password is required");
        } finally { driver.quit(); }
    }

    @ParameterizedTest
    @ValueSource(strings = {"firefox", "edge"})
    void testUC3_validCredentials(String browser){
        WebDriver driver = DriverFactory.create(browser);
        try {
            LoginPage p = new LoginPage(driver);
            p.open();
            p.setUsername("standard_user");
            p.setPassword("secret_sauce");
            p.login();
            assertThat(driver.getTitle()).contains("Swag Labs");
        } finally { driver.quit(); }
    }
}
