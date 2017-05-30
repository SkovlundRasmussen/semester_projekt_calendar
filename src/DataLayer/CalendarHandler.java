package DataLayer;

import Controller.Calendar;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class CalendarHandler {

    DatabaseHandler databaseHandler = new DatabaseHandler();
    public static final long HOUR = 3600*1000; // in milli-seconds.

    public List<Calendar> getAppointments(String user_id) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Connection conn = null;
        Timestamp timestamp;
        TimeZone tz = TimeZone.getTimeZone("GMT+1");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);

        String id;
        Date appointmentStartDate;
        Date appointmentEndDate;
        String convertedStatDate;
        String convertedEndDate;
        int appointmentSessionLength;
        String appointmentTitle;

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
                appointmentSessionLength = rs.getInt("app_session_length");
                timestamp = rs.getTimestamp("app_start_date");

                appointmentStartDate = new Date(timestamp.getTime());
                appointmentEndDate = new Date(appointmentStartDate.getTime() + appointmentSessionLength * HOUR); // Lægger session length til start dato i timer
                convertedStatDate = df.format(appointmentStartDate); // Convertere startDate til et datetime format kalenderen kan læse
                convertedEndDate = df.format(appointmentEndDate); // Convertere endDate til et datetime format kalenderen kan læse
                appointmentTitle = rs.getString("customer_first_name") + " " + rs.getString("customer_last_name"); // Lægger for og efternavn sammen til titel

                Calendar calendar = new Calendar(id, appointmentTitle, convertedStatDate, convertedEndDate);
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
        return appointments;
    }
    //Kristian

}
