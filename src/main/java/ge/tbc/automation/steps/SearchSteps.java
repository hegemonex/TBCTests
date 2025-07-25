package ge.tbc.automation.steps;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import ge.tbc.automation.pages.SearchPage;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class SearchSteps {
    private SearchPage searchPage;
    private Faker faker = new Faker();

    public SearchSteps(Page page) {
        searchPage = new SearchPage(page);
    }

    public SearchSteps searchInvalid() {
        searchPage.searchBox().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        searchPage.searchBox().click();
        searchPage.searchBox().clear();
        searchPage.searchBox().fill(faker.name().name());

        searchPage.nothingFound().waitFor(new Locator.WaitForOptions().setTimeout(5000));
        assertTrue(searchPage.nothingFound().isVisible());
        return this;
    }

    public SearchSteps searchValid() {
        searchPage.searchBox().click();
        searchPage.searchBox().clear();
        searchPage.searchBox().fill("სესხი");

        int count = searchPage.searchResult().count();

        for (int i = 0; i < count; i++) {
            assertTrue(searchPage.searchResult().nth(i).isVisible(), "Element at index " + i + " is not visible");
        }
        return this;
    }
}
