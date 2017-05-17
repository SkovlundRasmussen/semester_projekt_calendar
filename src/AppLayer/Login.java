package AppLayer;

import DataLayer.LoginHandler;
/**
 * Created by Jamie L. Ramsgaard on 5/16/2017.
 */
public class Login {
    public boolean isValidUserCredentials(String sUserName, String sUserPassword){

        LoginHandler LoginHandler_object = new LoginHandler();

        return LoginHandler_object.isValidUserLogin(sUserName,sUserPassword);
    }
}