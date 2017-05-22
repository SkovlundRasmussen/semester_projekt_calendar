package Controller;

import java.util.Date;

/**
 * Created by Jamie L. Ramsgaard on 5/16/2017.
 */
public class Appointment {
    private int appointmentID;
    private String appointmentDate;
    private String appointmentLength;
    private String appointmentNote;
    private int customerID;
    private int userID;

    public Appointment(int appointmentID, String appointmentDate, String appointmentLength, String appointmentNote/*, int customerID, int userID*/) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.appointmentLength = appointmentLength;
        this.appointmentNote = appointmentNote;
        //this.customerID = customerID;
        //this.userID = userID;
    }


    public int getAppointmentID() {
        return appointmentID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentLength() {
        return appointmentLength;
    }

    public String getAppointmentNote() {
        return appointmentNote;
    }

    public int getUserID() {
        return userID;
    }
}
