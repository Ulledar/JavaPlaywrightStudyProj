package models;

import java.util.Map;

public class LoginModel {

    private String userName;
    private String password;

    public static LoginModel createLoginModel(Map<String, String> entry){

        LoginModel loginModel = new LoginModel();

        loginModel.setUserName(entry.get("username"));
        loginModel.setPassword(entry.get("password"));

        return loginModel;
    }

    public LoginModel() {
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
