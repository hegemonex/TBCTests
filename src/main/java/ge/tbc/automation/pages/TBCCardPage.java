package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TBCCardPage {
    private final Page page;

    public TBCCardPage(Page page) {
        this.page = page;
    }

    public Locator getCardBtn(){
        return page.locator("//tbcx-pw-button[@class='tbcx-pw-cta-section__info__button ng-star-inserted']");
    }

    public Locator QRCode(){
        return page.locator("//canvas[@class='tbcx-pw-app-download-banner-popup__qr']");
    }

    public Locator searchBtn(){
        return page.locator("//button[@class='tbcx-pw-search__button ng-tns-c4211022679-2 icon-flat size-s ng-star-inserted state-initial']");
    }
}
