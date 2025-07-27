package ge.tbc.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoanPage {
    private final Page page;

    public LoanPage(Page page) {
        this.page = page;
    }

    public Locator loanBtn(){
        return page.locator("//a[@href='/ka/loans/consumer-loan/digital']");
    }

    public Locator moneyAndTime(){
        return page.locator("//div[@class='tbcx-text-input size-mini bg-color-high']//input");
    }

    public Locator confirmBtn() {
        return page.locator("//a[contains(@href,'tbccredit.ge/?amount=')]");
    }

    public Locator timeCalc(){
        return page.locator("//input[@id='standard-calculator-period']");
    }

    public Locator amountCalc(){
        return page.locator("//input[@placeholder='სესხის თანხა']");
    }

    public Locator employmentBtn(){
        return page.locator("//li[@data-event='accordin_ to_income_tab']");
    }

    public Locator amount(){
        return page.locator("//input[@name='calculator-period']");
    }

    public Locator acceptLoansBtn(){
        return page.locator("//button[@id='request-self-employed-loan']");
    }

    public Locator okayBtn(){
        return page.locator("//button[@class='btn yes prompt-btn size-s']");
    }

    public Locator personalId(){
        return page.locator("//input[@name='call_center_lead_personalId']");
    }

    public Locator personalNumber(){
        return page.locator("//input[@name='call_center_lead_phoneNumber']");
    }

    public Locator yesBtn(){
        return page.locator("//button[@id='lead_form_back_button']");
    }

    public Locator checkbtn(){
        return page.locator("//span[@class='checkmark']");
    }

    public Locator finalBtn(){
        return page.locator("//a[@id='Send_lead']");
    }

    public Locator youGotTheLoan(){
        return page.locator("//h2[text()='მოთხოვნა წარმატებით გაიგზავნა']");
    }

    public Locator closeBtn(){
        return page.locator("//button[@title='Close (Esc)']");
    }

    public Locator popUp(){
        return page.locator("//div[@class='snrs_popup--container']");
    }

    public Locator closePopUp(){
        return page.locator("//div[@class='snrs-modal-btn-close']");
    }
}
