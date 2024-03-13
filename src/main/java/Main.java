import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.util.List;

public class Main {

    public static void main(String[] args){
//        Navigation();
        NetworkInterception();
    }

    private static void Navigation() {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();

        var browser = browserType.launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setDevtools(true)
                .setArgs(List.of("--start-maximized")));

        var page = browser.newContext(new Browser.NewContextOptions().setViewportSize(null))
                .newPage();

        page.navigate("http://todomvc.com");
        browser.close();
        playwright.close();
    }

    public static void NetworkInterception() {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();

        var browser = browserType.launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setDevtools(true)
                .setArgs(List.of("--start-maximized")));

        var page = browser.newContext(new Browser.NewContextOptions().setViewportSize(null))
                .newPage();

        page.route("**/*", route -> {
            if(route.request().resourceType().equalsIgnoreCase("image")){
                route.abort();
            } else {
                route.resume();
            }
        });

        page.navigate("http://todomvc.com");
        browser.close();
        playwright.close();
    }
}
