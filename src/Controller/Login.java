package Controller;

import DataLayer.LoginHandler;

/**
 * Created by Jamie L. Ramsgaard on 5/19/2017.
 */
public class Login {
    public User isValidUserCredentials(String sUserName, String sUserPassword)
    {
        LoginHandler loginHandler = new LoginHandler();

        return loginHandler.isValidUserLogin(sUserName,sUserPassword);
    }
    // Kristan
}
