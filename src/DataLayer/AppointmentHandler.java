package DataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Jamie L. Ramsgaard on 5/18/2017.
 */
public class AppointmentHandler
{
    DatabaseHandler databaseHandler = new DatabaseHandler();

    public void newAppointment (String appointmentStartDate, String appointmentSessionLength, String appointmentNote) {
        PreparedStatement preparedStatement = null;
        Connection conn = null;

        String sql = "INSERT INTO appointments (app_start_date, app_session_length, app_note) VALUES (?, ?, ?)";

        try
        {
            conn = databaseHandler.getConnection();

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, appointmentStartDate);
            preparedStatement.setString(2, appointmentSessionLength);
            preparedStatement.setString(3, appointmentNote);

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
