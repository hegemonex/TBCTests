package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SearchPage {
    private final Page page;
    public SearchPage(Page page) {
        this.page = page;
    }

    public Locator searchBox(){
        return page.locator("//input[contains(@class, 'input') and @type='text']");
    }

    public Locator searchResult(){
        return page.locator("//a[@href='/ka/other-products/money-transfers']");
    }
}

