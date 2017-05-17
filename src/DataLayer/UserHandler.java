package DataLayer;

import java.sql.*;


/**
 * Created by Nichlas B. Toldamon 17-05-2017.
 */
public class UserHandler
{
    ConnectToDB connectToDB = new ConnectToDB();

    public void newUser(String userTypeId, String userName, String userPass)
    {
        PreparedStatement preparedStatement = null;
        Connection conn = null;

        String sql = "INSERT INTO users(user_type_id, user_name, user_pass) VALUES (?, ?, ?)";

        try
        {
            conn = connectToDB.getConnection();

            preparedStatement = conn.prepareStatement(sql);


            preparedStatement.setString(1, userTypeId);
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
            try
            {
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }

                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
