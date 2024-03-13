package base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {


    @BeforeTest
    public void setupPlaywright() {
        FrameworkConfig.LocalPage = new FrameworkInitialize().InitializePlaywright();
    }

    @AfterTest
    public void cleanUp(){
        FrameworkConfig.LocalPage.close();
//        FrameworkConfig.Browser.close();
//        FrameworkConfig.Playwright.close();
    }
}
