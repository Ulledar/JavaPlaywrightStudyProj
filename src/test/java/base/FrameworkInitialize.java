package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import config.ConfigReader;
import config.Settings;

import java.util.List;

public class FrameworkInitialize {

    public Page InitializePlaywright(){
        /*ConfigReader configs = new ConfigReader();
        configs.PopulateSettings();*/
        new ConfigReader().PopulateSettings();

        //Browser initialize
        BrowserInitialize browserInitialize = new BrowserInitialize();

        //Set launch options
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        launchOptions.headless = Settings.Headless;
        launchOptions.devtools = Settings.DevTools;
        launchOptions.setArgs(List.of("--start-maximized"));    /*launchOptions.args = List.of("--start-maximized");*/

        //Get browser
        var browser = browserInitialize.GetBrowser(Settings.BrowserName, launchOptions);
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions();
        contextOptions.locale = Settings.Locale;
        contextOptions.setViewportSize(null);

        var context = browserInitialize.GetBrowserContext(browser, contextOptions);

        return browserInitialize.GetPage(context);
    }
}
