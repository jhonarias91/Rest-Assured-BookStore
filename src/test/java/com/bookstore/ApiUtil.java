package com.bookstore;

import com.bookstore.config.ConfigLoader;
import com.bookstore.model.User;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

import static io.restassured.RestAssured.given;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApiUtil {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeEach
    public void setUp(){
        this.playwright = Playwright.create();
        this.browser = playwright
                .chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(Boolean.parseBoolean(ConfigLoader.getProperty("playwright.config.is.headless"))));
        this.page = browser.newPage();
    }

    public static Response createUser(final String userName, final String password) {
        final User newUser = new User(userName, password);
        return given()
                .contentType(ContentType.JSON)
                .body(newUser)
                .when()
                .post(ConfigLoader.getProperty("demoqa.host.base.url")+"Account/v1/User");
    }

    @AfterEach
    public void tearDown(){
        browser.close();
        this.playwright.close();
    }

}
