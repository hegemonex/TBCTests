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

    public Locator nothingFound(){
        return page.locator("//p[@class='global-search__bottom-content__container__not-fount-result__title tbcx-pw-title']");
    }

    public Locator searchResult(){
        return page.locator("//app-search-result-item[@class='ng-star-inserted']");
    }
}

