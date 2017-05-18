package DataLayer;
import java.sql.*;

/**
 * Created by Toldam on 16-05-2017.
 */

//push test
public class DatabaseHandler
{
    public static Connection getConnection()
    {
        Connection conn = null;

        try
        {
            //
            Class.forName("com.mysql.jdbc.Driver");

                System.out.println("Connecting to database...");

            String DB_Url = System.getProperty("JDBC_CONNECTION_STRING");
            String DB_Pass = "&password=" + System.getProperty("JDBC_PASSWORD");
            System.out.println(DB_Url + DB_Pass);

            conn = DriverManager.getConnection(DB_Url + DB_Pass);

            return conn;

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


        return null;
    }

    public void sqlEx(PreparedStatement preparedStatement, Connection conn)
    {
        try
        {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
