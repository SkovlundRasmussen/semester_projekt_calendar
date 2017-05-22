package Controller;


import java.util.Date;

public class User {
    private int userID;
    private String userName;
    private int userType;

    public User(int userID, String userName, int userType)
    {
        this.userID = userID;
        this.userName = userName;
        this.userType = userType;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

}
