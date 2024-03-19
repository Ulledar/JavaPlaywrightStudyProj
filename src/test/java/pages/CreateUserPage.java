package pages;

import base.FrameworkConfig;
import com.microsoft.playwright.Page;

public class CreateUserPage {
    Page page = FrameworkConfig.LocalPage;

    String txtName = "input[name=\"Name\"]";
    String txtSalary = "input[name=\"Salary\"]";
    String txtDuration = "input[name=\"DurationWorked\"]";
    String txtGrade = "#Grade";
    String txtEmail = "input[name=\"Email\"]";
    String btnCreate = "input[type=\"submit\"]";

    public HomePage CreateUser(String name, String salary, String duration, String grade, String email){
        page.fill(txtName, name);
        page.fill(txtSalary, salary);
        page.fill(txtDuration, duration);
        page.locator(txtGrade).selectOption("2");
        page.fill(txtEmail, email);

        page.click(btnCreate);

        return new HomePage();
    }
}
