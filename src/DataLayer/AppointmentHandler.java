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

    public void deleteAppointment(String id)
    {

    }

    public void newAppointment (String appointmentStartDate, String appointmentSessionLength, String appointmentNote, String userId, String customerId) {
        PreparedStatement preparedStatement = null;
        Connection conn = null;
        int key;
        String sql = "INSERT INTO appointments (app_start_date, app_session_length, app_note) VALUES (?, ?, ?)";
        String customer_user_app_sql = "INSERT INTO user_customer_app_link (user_id, customer_id, app_id) VALUES(?, ?, ?)";

        try
        {
            conn = databaseHandler.getConnection();
            preparedStatement =	conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, appointmentStartDate);
            preparedStatement.setString(2, appointmentSessionLength);
            preparedStatement.setString(3, appointmentNote);

            preparedStatement.executeUpdate();

            ResultSet keys = preparedStatement.getGeneratedKeys();

            keys.next();
            key = keys.getInt(1);

            preparedStatement =	conn.prepareStatement(customer_user_app_sql);
            preparedStatement.setInt(1, Integer.parseInt(userId));
            preparedStatement.setInt(2, Integer.parseInt(customerId));
            preparedStatement.setInt(3, key);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();

            System.out.println("UPDATE");
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

            while (rs.next()) // Laver et nyt Appointment objekt for hvert row i DB. Lager objekterne i en liste
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

    public Appointment getAppointment (String appointmentId)
    {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Connection conn = null;

        Appointment appointment = null;

        int appointment_id;
        String appointmentStartDate;
        String appointmentSessionLength;
        String appointmentNote;


        String sql = "SELECT app_id, app_start_date, app_session_length, app_note  FROM appointments WHERE app_id=?";


        try{
            conn = databaseHandler.getConnection();

            preparedStatement =	conn.prepareStatement(sql);
            preparedStatement.setString(1, appointmentId);
            rs = preparedStatement.executeQuery();

            if(rs.next()) // Kommer der et hit ud fra DB bliver der lavet et nyt Customer Objekt.
            {
                appointment_id = rs.getInt("app_id");
                appointmentStartDate = rs.getString("app_start_date");
                appointmentSessionLength = rs.getString("app_session_length");
                appointmentNote = rs.getString("app_note");

                appointment = new Appointment(appointment_id, appointmentStartDate, appointmentSessionLength, appointmentNote);

                // Eksekvere return før finally?
                return appointment;
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseHandler.sqlEx(preparedStatement, conn);
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
        }
        return appointment;
    }
    public void editAppointment (String appointmentStartDate, String appointmentSessionLength, String appointmentNote, String id)
    {
        PreparedStatement preparedStatement = null;

        Connection conn = null;

        String sql = "UPDATE appointments SET app_start_date = ?, app_session_length = ?, app_note = ? WHERE app_id = ?;";

        try
        {
            conn = databaseHandler.getConnection();

            preparedStatement =    conn.prepareStatement(sql);

            preparedStatement.setString(1, appointmentStartDate);
            preparedStatement.setString(2, appointmentSessionLength);
            preparedStatement.setString(3, appointmentNote);
            preparedStatement.setString(4, id);

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
