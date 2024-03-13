package pages;

import base.FrameworkConfig;
import com.microsoft.playwright.Page;

public class HomePage {

    Page page = FrameworkConfig.LocalPage;

    String lnkLogin = "text='Login'";
    String lnkLogOff = "text='Log off'";
    String lnkEmployeeList = "text='Employee List'";
    String lnkCreateNew = "text='Create New'";
    String btnDelete = "input[type=\"submit\"";

    public LoginPage ClickLogin() {
        page.click(lnkLogin);

        return new LoginPage();
    }

    public void ClickLogOff() { page.click(lnkLogOff); }

    public void ClickEmployeeList() { page.click(lnkEmployeeList); }

    public CreateUserPage ClickCreateNew() {
        page.click(lnkCreateNew);

        return new CreateUserPage();
    }
    
    public void ClickDelete() { page.click(btnDelete); }
}
