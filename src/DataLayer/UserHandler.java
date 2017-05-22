package DataLayer;

import Controller.User;

import java.sql.*;

import java.util.*;
import java.util.Date;


/**
 * Created by Nichlas B. Toldam 17-05-2017.
 */
public class UserHandler
{

    DatabaseHandler databaseHandler = new DatabaseHandler();


    public void newUser(String userName, String userPass)
    {
        PreparedStatement preparedStatement = null;
        Connection conn = null;

        String sql = "INSERT INTO users(user_type_id, user_name, user_pass) VALUES (?, ?, ?)";

        try {
            conn = databaseHandler.getConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, userPass);


            preparedStatement.executeUpdate();

            System.out.println("UPDATE");
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseHandler.sqlEx(preparedStatement, conn);
        }
    }

    public User getUser()
    {
        int userID;
        String userName;
        String userPassword;
        int userType;
        Date dateTime;

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Connection conn = null;

        String sql = "SELECT * FROM users WHERE user_id = 1"; //brug session cookie

        try {
            conn = databaseHandler.getConnection();

            rs = preparedStatement.executeQuery(sql);
            if (rs.next());
            {
                userID = rs.getInt("user_id");
                userName = rs.getString("user_name");
                userPassword = rs.getString("user_pass");
                userType = rs.getInt("user_type_id");
                dateTime = rs.getDate("creation_date");
                User user = new User(userID, userName, userPassword, dateTime, userType);

                return user;
            }
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseHandler.sqlEx(preparedStatement, conn);
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
        }

    }

}

