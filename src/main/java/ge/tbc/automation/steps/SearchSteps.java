package ge.tbc.automation.steps;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import ge.tbc.automation.pages.SearchPage;
import io.qameta.allure.Step;

public class SearchSteps {
    private SearchPage searchPage;

    public SearchSteps(Page page) {
        searchPage = new SearchPage(page);
    }

    @Step("Search with a valid query 'სესხი' and verify results are visible")
    public SearchSteps searchMoneyTransfer() {
        searchPage.searchBox().click();
        searchPage.searchBox().clear();
        searchPage.searchBox().fill("გზავნილი");

        searchPage.searchResult().click();

        return this;
    }
}
