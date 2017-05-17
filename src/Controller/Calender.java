package Controller;

import java.sql.Time;

/**
 * Created by Jamie L. Ramsgaard on 5/16/2017.
 */
public class Calender {
    private int userID;
    private String userName;
    private String userPassword;
    private Time userDate;
    private int userType;
    private String userTypeName;

    public Calender(int userID, String userName, String userPassword, Time userDate, int userType, String userTypeName)
    {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userDate = userDate;
        this.userType = userType;
        this.userTypeName = userTypeName;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }
}
