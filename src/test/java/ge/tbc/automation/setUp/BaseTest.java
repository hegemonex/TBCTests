package ge.tbc.automation.setUp;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;

import java.util.Arrays;

import static ge.tbc.automation.constants.Constants.MAIN_URL;

public class BaseTest {
    Playwright playwright;
    Browser browser;
    static public Page page;

    @BeforeMethod
    @Step("Set up browser and navigate to main URL")
    public void setUp() {
        playwright = Playwright.create();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(true)
                .setArgs(Arrays.asList("--disable-gpu", "--disable-extensions"));

        browser = playwright.chromium().launch(launchOptions);

        BrowserContext context = browser.newContext();

        page = context.newPage();
        page.setDefaultTimeout(10000);

        page.navigate(MAIN_URL);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

//    @AfterMethod
//    public void tearDown(){
//        browser.close();
//        playwright.close();
//    }
}
