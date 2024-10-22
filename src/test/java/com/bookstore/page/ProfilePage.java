package com.bookstore.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class ProfilePage {

    private Page page;
    private Locator btnDeleteAccount;
    private Locator btnModalDeleteOk;

    public ProfilePage(Page page) {
        this.page = page;
        this.btnDeleteAccount = page.locator("//button[@id='submit' and @type='button' and text()='Delete Account']");
        this.btnModalDeleteOk = page.locator("//div[@class='modal-footer']/button[@id='closeSmallModal-ok']");

        page.onDialog(dialog -> {
            //Listen for the alert dialon for delete and then confirm it
            dialog.accept();
        });
    }

    public void deleteAccount(){

        this.btnDeleteAccount.click();
        btnModalDeleteOk.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        page.click("#closeSmallModal-ok");
    }

}
