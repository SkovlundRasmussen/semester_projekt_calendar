package DataLayer;

import Controller.Appointment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentHandler
{
    DatabaseHandler databaseHandler = new DatabaseHandler();

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
    //Kristian, Jamie

    public List<Appointment> getAppointments(String user_id) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Connection conn = null;

        int id;
        String appointmentStartDate;
        String appointmentSessionLength;
        String appointmentNote;

        List<Appointment> appointments = new ArrayList<Appointment>();

        String sql = "SELECT * FROM appointments INNER JOIN user_customer_app_link ON user_customer_app_link.app_id = appointments.app_id WHERE user_customer_app_link.user_id = ?"; // WHERE SESSION USER_ID = ?

        try {

            conn = databaseHandler.getConnection();


            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(user_id));

            rs = preparedStatement.executeQuery();

            while (rs.next()) // Laver et nyt Appointment objekt for hvert row i DB. Lager objekterne i en liste
            {
                id = rs.getInt("app_id");
                appointmentStartDate = rs.getString("app_start_date");
                appointmentSessionLength = rs.getString("app_session_length");
                appointmentNote = rs.getString("app_note");
                Appointment appointment = new Appointment(id, appointmentStartDate, appointmentSessionLength, appointmentNote);

                appointments.add(appointment);
            }

            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseHandler.sqlEx(preparedStatement, conn);
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
        }
        return appointments;
    }
    //Jamie

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

        String sql = "SELECT * FROM appointments WHERE app_id = ?";

        try{
            conn = databaseHandler.getConnection();

            preparedStatement =	conn.prepareStatement(sql);
            preparedStatement.setString(1, appointmentId);
            rs = preparedStatement.executeQuery();

            if(rs.next()) // Kommer der et hit fra DB bliver der lavet et nyt Customer Objekt.
            {
                appointment_id = rs.getInt("app_id");
                appointmentStartDate = rs.getString("app_start_date");
                appointmentSessionLength = rs.getString("app_session_length");
                appointmentNote = rs.getString("app_note");

                appointment = new Appointment(appointment_id, appointmentStartDate, appointmentSessionLength, appointmentNote);
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
    //Jamie

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
    //Jamie

}
