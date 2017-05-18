
package DataLayer;

import java.sql.*;

/**
 * Created by Tolda on 16-05-2017.
 */
public class LoginHandler {

    DatabaseHandler databaseHandler = new DatabaseHandler();



    public boolean isValidUserLogin(String sUSerName, String sUserPassword){

        boolean isValidUser = false;

        PreparedStatement preparedStatement = null;
        Connection conn = null;
        Statement stmt = null;

        String sql = "SELECT * FROM users WHERE user_name = ? AND user_pass = ?";

        try
        {
            conn = databaseHandler.getConnection();

            preparedStatement = conn.prepareStatement(sql);


            preparedStatement.setString(1, sUSerName);
            preparedStatement.setString(2, sUserPassword);

            ResultSet rs = preparedStatement.executeQuery();


            if (rs.next()){
                isValidUser = true;
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

        return isValidUser;
    }
}