
package DataLayer;

import Controller.User;
import java.sql.*;

public class LoginHandler {

    DatabaseHandler databaseHandler = new DatabaseHandler();

    public User isValidUserLogin(String sUSerName, String sUserPassword){

        User user = null;

        PreparedStatement preparedStatement = null;
        Connection conn = null;

        String sql = "SELECT * FROM users WHERE user_name = ? AND user_pass = ?";

        try
        {
            conn = databaseHandler.getConnection();

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, sUSerName);
            preparedStatement.setString(2, sUserPassword);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                int id = rs.getInt("user_id");
                int userType = rs.getInt("user_type_id");
                String userName = rs.getString("user_name");
                user = new User(id, userName, userType);

                return user;
            }

            System.out.println("UPDATE");
            preparedStatement.close();
            conn.close();
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }

        finally
        {
            databaseHandler.sqlEx(preparedStatement, conn);
        }

        return user;
    }
    //Krsitian
}