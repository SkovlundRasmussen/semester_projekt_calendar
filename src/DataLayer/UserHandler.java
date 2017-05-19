package DataLayer;

import java.sql.*;


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

        try
        {
            conn = databaseHandler.getConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, userPass);


            preparedStatement.executeUpdate();

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
    }
}
