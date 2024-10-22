package com.bookstore;

import com.bookstore.config.ConfigLoader;
import com.bookstore.model.User;
import com.bookstore.page.LoginPage;
import com.bookstore.page.ProfilePage;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserLoginTest extends ApiUtil {

    private LoginPage loginPage;
    private ProfilePage profilePage;

    @Test
    public void testLoginDeleteUser() {
        System.out.println("Estado de 'page' en test: " + page);
        assertNotNull(page, "Page should not be null. Make sure it is initialized in setUp().");

        //Create the user using restAssured
        final String userName = getARandomUserName();
        final String password = ConfigLoader.getProperty("test.password");
        final Response newUserResponse = createUser(userName, password);
        newUserResponse.then()
                .statusCode(201);
        final User user = newUserResponse.as(User.class);
        assertNotNull(user);

        this.page.navigate(ConfigLoader.getProperty("demoqa.host.base.url")+"login");
        this.loginPage = new LoginPage(this.page);
        this.profilePage = new ProfilePage(this.page);

        //login user credentials sended using restAssured
        this.loginPage.login(user.getUserName(), password);

        this.profilePage.deleteAccount();
        //trying to login after user deleted
        this.loginPage.login(user.getUserName(), password);

        final boolean errorPresent = this.loginPage.isErrorPresent(ConfigLoader.getProperty("login.invalid.username.error"));
        assertTrue(errorPresent);
    }

    private String getARandomUserName() {
        return "usr" + System.currentTimeMillis();
    }


}
