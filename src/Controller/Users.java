package Controller;

import DataLayer.UserHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nichlas B. Toldam on 5/16/2017.
 */

//Nichlas Buer Toldam
public class Users
{
    private List getUserList()
    {
        List<User> userList = new LinkedList<>();

        return userList;
    }

    public void newUser(String userName, String userPass)
    {
        UserHandler userHandler = new UserHandler();

        userHandler.newUser(userName, userPass);

    }
}
