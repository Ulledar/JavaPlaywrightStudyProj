package tests;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;

import static base.FrameworkConfig.*;

public class FirstTest extends TestBase {

    @Test
    public void testLogOff(){
        LocalPage.navigate("http://eaapp.somee.com");

        HomePage homePage = new HomePage();
        var loginPage = homePage.ClickLogin();
        homePage = loginPage.login("admin", "password");
        homePage.ClickEmployeeList();

        homePage.ClickLogOff();
    }

    @Test
    public void testLogin(){
        LocalPage.navigate("http://eaapp.somee.com");

        HomePage homePage = new HomePage();
        var loginPage = homePage.ClickLogin();
        homePage = loginPage.login("admin", "password");
        homePage.ClickEmployeeList();

        var createUserPage = homePage.ClickCreateNew();
        homePage = createUserPage.CreateUser("AutoTestUser1", "2000", "40", "2", "autotest@tester.com");
    }

    @Test
    public void testNavigation(){
        LocalPage.navigate("https://executeautomation.com");
    }
}
