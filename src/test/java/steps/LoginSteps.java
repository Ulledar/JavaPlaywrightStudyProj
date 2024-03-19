package steps;
import base.FrameworkConfig;
import base.FrameworkInitialize;
import config.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;
import models.LoginModel;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    HomePage homePage;
    LoginPage loginPage;

    @DataTableType
    public LoginModel convertLoginModel(Map<String, String> entry){
        return LoginModel.createLoginModel(entry);
    }

    @Before
    public void setUp() {
        ConfigReader.PopulateSettings();
        FrameworkConfig.LocalPage = new FrameworkInitialize().InitializePlaywright();
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @After
    public void tearDown(){
        FrameworkConfig.LocalPage.close();
    }

    @Given("I navigate to the application")
    public void iNavigateToTheApplication(){
        FrameworkConfig.LocalPage.navigate("http://eaapp.somee.com");
    }

    @And("I click Login link")
    public void iClickLoginLink(){
        loginPage = homePage.ClickLogin();
    }

    @And("I enter following login details")
    public void iEnterFollowingLoginDetails(List<LoginModel> loginModelList){
        homePage = loginPage.login(loginModelList.stream().findFirst().get());
        homePage.ClickEmployeeList();
    }

    @Then("I click Log off")
    public void iLickLogOff(){
        FrameworkConfig.LocalPage.navigate("http://eaapp.somee.com");
    }
}
