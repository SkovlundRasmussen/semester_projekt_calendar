package DataLayer;
import java.sql.*;

/**
 * Created by Toldam on 16-05-2017.
 */
public class ConnectToDB
{
    public static void main(String[] args)
    {
        connectToBD("admin", "1234");
    }
    public static boolean connectToBD(String sUsername, String sUserPassword)
    {
        boolean bResult = false;
        Connection conn = null;
        Statement stmt = null;

        try
        {
            //
            Class.forName("com.mysql.jdbc.Driver");

                System.out.println("Connecting to database...");

            String DB_Url = System.getProperty("JDBC_CONNECTION_STRING");
            String DB_Pass = "&password=" + System.getProperty("JDBC_PASSWORD");
            System.out.println(DB_Url + DB_Pass);

            conn = DriverManager.getConnection(DB_Url + DB_Pass);

            //
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            // prevent sql inject
            String selectSQL = "SELECT * FROM users WHERE user_name = ? AND user_pass = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
            preparedStatement.setString(1, sUsername);
            preparedStatement.setString(2, sUserPassword);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next())
            {
                bResult = true;
            }
            else
            {
                bResult = false;
            }

            rs.close();
            stmt.close();
            conn.close();

        }
        catch(SQLException se)
        {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch (Exception e)
        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally
        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2)
            {
                // nothing we can do
            }
            try
            {
                if (conn != null)
                    conn.close();
            } catch (SQLException se)
            {
                se.printStackTrace(); //end finally try
            }
        }
        System.out.println("Goodbye!");
        return bResult;
    }

}
