package base;

import com.microsoft.playwright.*;

public class BrowserInitialize {

    public Browser GetBrowser(String browserName, BrowserType.LaunchOptions launchOptions) {

        FrameworkConfig.Playwright = Playwright.create();
        BrowserType browserType = null;

        switch (browserName.toLowerCase()){
            case "firefox" -> browserType = FrameworkConfig.Playwright.firefox();
            case "webkit" -> browserType = FrameworkConfig.Playwright.webkit();
            default -> browserType = FrameworkConfig.Playwright.chromium();
        }

        return browserType.launch(launchOptions);
    }

    public BrowserContext GetBrowserContext(Browser browser, Browser.NewContextOptions newContextOptions){
        return browser.newContext(newContextOptions);
    }

    public Page GetPage(BrowserContext browserContext){
        return browserContext.newPage();
    }
}
