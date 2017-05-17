package Controller;


import java.util.Date;

public class User {
    private int userID;
    private String userName;
    private String userPassword;
    private Date dateTime;
    private int userType;
    private String userTypeName;

    public User(int userID, String userName, String userPassword, Date dateTime, int userType, String userTypeName)
    {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.dateTime = dateTime;
        this.userType = userType;
        this.userTypeName = userTypeName;
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
}
