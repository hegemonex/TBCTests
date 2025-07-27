package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class MoneyTransferPage {
    private final Page page;

    public MoneyTransferPage(Page page) {
        this.page = page;
    }

    public Locator moneyTransferBtn() {
        return page.locator("//button[@class='tbcx-pw-tab-menu__item ng-star-inserted' and span[text()='გზავნილის გაგზავნის საკომისიო']]");
    }

    public Locator currencyDropdown() {
        return page.locator("(//div[contains(@class,'tbcx-dropdown-selector')])[1]");
    }

    public Locator countryDropdown() {
        return page.locator("//div[contains(@class,'tbcx-dropdown-selector')]//div[contains(@class,'tbcx-field')]");
    }

    public Locator dropdownItem(String text) {
        return page.locator("//div[@class='tbcx-dropdown-popover-item__title' and text()='" + text + "']");
    }

    public Locator inputField() {
        return page.locator("//input[contains(@class,'input') and @type='text']");
    }

    public Locator cards() {
        return page.locator("//div[@class='tbcx-pw-money-transfer-fee-calculator__cards']//tbcx-pw-card");
    }

    public void selectDropdownItem(Locator dropdownLocator, String optionText) {
        dropdownLocator.click();

         Locator option = dropdownLocator.page().locator(
                "//div[contains(@class, 'tbcx-dropdown-popover-item__title') and normalize-space(text())='" + optionText + "']"
        );

        option.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        option.evaluate("el => el.scrollIntoView()");

        option.click();
    }
}