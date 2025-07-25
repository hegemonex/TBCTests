package ge.tbc.automation.setUp;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Arrays;

import static ge.tbc.automation.constants.Constants.MAIN_URL;

public class BaseTest {
    Playwright playwright;
    Browser browser;
    static public Page page;

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(Arrays.asList("--disable-gpu", "--disable-extensions"));

        browser = playwright.chromium().launch(launchOptions);

        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080)
                .setDeviceScaleFactor(1)
                .setIsMobile(false)
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/113 Safari/537.36")
        );

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
