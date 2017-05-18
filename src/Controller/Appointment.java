package Controller;

import java.util.Date;

/**
 * Created by Jamie L. Ramsgaard on 5/16/2017.
 */
public class Appointment {
    private int appointmentID;
    private Date appointmentDate;
    private int customerID;
    private int userID;

    public void newAppointment(Date appointmentStartDate, String appointmentSessionLength, String appointmentNote)
    {

    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getUserID() {
        return userID;
    }
}
