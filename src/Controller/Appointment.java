package Controller;

import java.util.*;

/**
 * Created by Jamie L. Ramsgaard on 5/16/2017.
 */
public class Appointment {
    private int appointmentID;
    private Date appointmentDate;
    private int customerID;
    private int userID;

    public Appointment(int appointmentID, Date appointmentDate, int customerID, int userID) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.customerID = customerID;
        this.userID = userID;
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
