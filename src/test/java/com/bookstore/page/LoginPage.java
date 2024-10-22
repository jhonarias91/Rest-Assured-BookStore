package com.bookstore.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class LoginPage {

    private Locator userNameField;
    private Locator passwordField;

    private Locator btnLogin;
    private Locator errorP;
    private Page page;

    public LoginPage(Page page) {
        this.page = page;
        this.userNameField = page.locator("//input[@placeholder='UserName' and @id='userName']");
        this.passwordField = page.locator("//input[@placeholder='Password' and @id='password' and @type='password']");
        this.btnLogin = page.locator("//button[@class='btn btn-primary' and @id='login']");
        this.errorP = page.locator("//p[@class='mb-1' and @id='name']");
    }

    public void login(String username, String password) {
        //Wait the page to full load
        //page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        userNameField.scrollIntoViewIfNeeded(new Locator.ScrollIntoViewIfNeededOptions().setTimeout(1000));

        this.userNameField.pressSequentially(username, new Locator.PressSequentiallyOptions().setDelay(100));
        this.passwordField.pressSequentially(password, new Locator.PressSequentiallyOptions().setDelay(100));
        this.btnLogin.click();
    }

    public boolean isErrorPresent(String error) {
        return error == null || error.equalsIgnoreCase(errorP.innerText());
    }

}
