package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MainPage {
    private final Page page;

    public MainPage(Page page) {
        this.page = page;
    }

    public Locator forYou(){
        return page.locator("//div[@class= 'tbcx-pw-navigation-item__link ng-star-inserted' and text() = ' ჩემთვის ']");
    }

    public Locator searchBtn(){
        return page.locator("//tbcx-icon[@style=\"--icon-mask-image-property: url('/assets/tbcx/icons/search-outlined.svg?');\"]");
    }

    public Locator loanBtn(){
        return page.locator("//span[@class='tbcx-pw-mega-menu-sub-item__title' and text() = 'სამომხმარებლო']");
    }

    public Locator depositBtn(){
        return page.locator("//span[@class='tbcx-pw-mega-menu-sub-item__title' and text() = 'ანაბრები']");
    }

    public Locator moneyTransferBtn(){
        return page.locator("a[href='/ka/other-products/money-transfers']");
    }
}
