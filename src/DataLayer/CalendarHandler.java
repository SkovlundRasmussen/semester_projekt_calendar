package DataLayer;

import Controller.Appointment;
import Controller.Calendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalendarHandler {

    DatabaseHandler databaseHandler = new DatabaseHandler();

    public List<Calendar> getAppointments(String user_id) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Connection conn = null;

        String id;
        String appointmentStartDate;
        String appointmentSessionLength;
        String appointmentTitle;
        String appointmentNote;

        List<Calendar> appointments = new ArrayList<Calendar>();

        String sql = "SELECT * FROM appointments INNER JOIN user_customer_app_link ON user_customer_app_link.app_id = appointments.app_id INNER JOIN customers ON customers.customer_id = user_customer_app_link.customer_id WHERE user_customer_app_link.user_id = ?"; // WHERE SESSION USER_ID = ?

        try {

            conn = databaseHandler.getConnection();


            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(user_id));

            rs = preparedStatement.executeQuery();

            while (rs.next()) // Laver et nyt Appointment objekt for hvert row i DB. Lager objekterne i en liste
            {
                id = rs.getString("app_id");
                appointmentStartDate = rs.getString("app_start_date");
             //   appointmentSessionLength = rs.getString("app_session_length");
                appointmentTitle = rs.getString("customer_first_name") + " " + rs.getString("customer_last_name");
                // appointmentNote = rs.getString("app_note");
                Calendar calendar = new Calendar(id, appointmentTitle, appointmentStartDate);

                appointments.add(calendar);
            }

            preparedStatement.close();
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
