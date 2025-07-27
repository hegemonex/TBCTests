package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MoneyTransferPage {
    private final Page page;

    public MoneyTransferPage(Page page) {
        this.page = page;
    }

    public Locator moneyTransferBtn(){
        return page.locator("//button['@_ngcontent-serverapp-c3605796308']");
    }

    public Locator chooseCurrency(){
        return page.locator("//div[@class='tbcx-dropdown-popover-item__title' and text() = 'USD']");
    }

    public Locator inputField(){
        return page.locator("//input[contains(@class, 'input') and @type='text']");
    }

    public Locator dropDownBtn(){
        return page.locator("//i[@class=\"tbcx-popover-state-icon\"]");
    }

    public Locator selectQountry(){
        return page.locator("//div[@class='tbcx-dropdown-popover-item__title' and text()='აშშ']");
    }

    public Locator cards(){
        return page.locator("//div[@class='tbcx-pw-money-transfer-fee-calculator__cards']//tbcx-pw-card");
    }
}
