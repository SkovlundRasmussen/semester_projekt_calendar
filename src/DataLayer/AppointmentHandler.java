package DataLayer;

import Controller.Appointment;
import Controller.Customer;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<Appointment> getAppointments() {
        PreparedStatement preparedStatement = null;
        Statement smtp = null;
        ResultSet rs = null;
        Connection conn = null;

        int id;
        String appointmentStartDate;
        String appointmentSessionLength;
        String appointmentNote;

        List<Appointment> appointments = new ArrayList<Appointment>();

        String sql = "SELECT * FROM appointments"; // WHERE SESSION USER_ID = ?

        try {

            conn = databaseHandler.getConnection();

            smtp = conn.createStatement();
            rs = smtp.executeQuery(sql);

            while (rs.next()) // Laver et nyt Customer objekt for hvert row i DB. Lager objekterne i en liste
            {
                id = rs.getInt("app_id");
                appointmentStartDate = rs.getString("app_start_date");
                appointmentSessionLength = rs.getString("app_session_length");
                appointmentNote = rs.getString("app_note");
                Appointment appointment = new Appointment(id, appointmentStartDate, appointmentSessionLength, appointmentNote);

                appointments.add(appointment);
            }
            smtp.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseHandler.sqlEx(preparedStatement, conn);
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
        }
//Slet senere
        return appointments;
    }
}
