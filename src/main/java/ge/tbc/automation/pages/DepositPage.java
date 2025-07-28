package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DepositPage {
    private final Page page;

    public DepositPage(Page page) {
        this.page = page;
    }

    public Locator myGoalCard(){
        return page.locator("//a[@href='/ka/deposits/my-goal-deposit']");
    }

    public Locator getTheDepositBtn(){
        return page.locator("//a[@href='https://tbcbank.onelink.me/YiId/kol49xj9']");
    }
}
