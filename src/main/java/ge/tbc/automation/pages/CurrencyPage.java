package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CurrencyPage {
    private final Page page;

    public CurrencyPage(Page page) {
        this.page = page;
    }

    public Locator USD(){
        return page.locator("//tbcx-text-input[contains(@class,'tbcx-input-with-selector__text-input') and .//text()[contains(., 'USD')]]//input");
    }

    public Locator GEL(){
        return page.locator("//tbcx-text-input[contains(@class,'tbcx-input-with-selector__text-input') and .//text()[contains(., 'GEL')]]//input");
    }

    public Locator wholsalePriceBtn(){
        return page.locator("//span[text() = 'საბითუმო კურსები']");
    }

    public Locator wholsaleCourse(){
        return page.locator("//div[@class='tbcx-pw-table-cell__content__title tbcx-pw-title ng-star-inserted']");
    }

    public Locator officialCourse(){
        return page.locator("//span[@class='tbcx-pw-table-cell__content__subtitle ng-star-inserted']");
    }

    public Locator messagePriceBtn(){
        return page.locator("//span[text() = 'გზავნილის კურსები']");
    }

    public Locator messageCourse(){
        return page.locator("//div[@class='tbcx-pw-table-cell__content__title tbcx-pw-title ng-star-inserted']");
    }

    public Locator conversionRate(){
        return page.locator("//div[@class='tbcx-pw-exchange-rates-calculator__description ng-star-inserted']");
    }

    public Locator changeBtn(){
        return page.locator("//button[@class='icon-flat size-l state-initial']");
    }

    public Locator searchBtn(){
        return page.locator("//button[@class='tbcx-pw-search__button ng-tns-c4211022679-2 icon-flat size-s ng-star-inserted state-initial']");
    }
}
