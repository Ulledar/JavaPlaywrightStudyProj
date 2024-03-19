package pages;

import base.FrameworkConfig;
import com.microsoft.playwright.Page;
import models.LoginModel;

public class LoginPage {

    Page page = FrameworkConfig.LocalPage;

    String txtUserName = "#UserName";
    String txtPassword = "#Password";
    String btnLogin = "input:text('Log in')";


    public HomePage login(String userName, String password) {
        page.fill(txtUserName, userName);
        page.fill(txtPassword, password);
        page.click(btnLogin);

        return new HomePage();
    }

    public HomePage login(LoginModel loginModel) {
        page.fill(txtUserName, loginModel.getUserName());
        page.fill(txtPassword, loginModel.getPassword());
        page.click(btnLogin);

        return new HomePage();
    }
}
