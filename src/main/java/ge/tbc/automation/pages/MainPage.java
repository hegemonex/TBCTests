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

    public Locator currencyBtn(){
        return page.locator("//span[@class='tbcx-pw-mega-menu-quick-acitons-item__title' and text() = ' ვალუტის კურსები']");
    }

    public Locator TBCCard(){
        return page.locator("//span[@class='tbcx-pw-mega-menu-sub-item__title' and text() = 'თიბისი ბარათი']");
    }

    public Locator searchBtn(){
        return page.locator("//button[@class='tbcx-pw-search__button ng-tns-c4211022679-2 icon-flat size-s ng-star-inserted state-initial']");
    }
}
