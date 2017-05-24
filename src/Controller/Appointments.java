package Controller;

import DataLayer.AppointmentHandler;
import DataLayer.CustomerHandler;
import DataLayer.UserHandler;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jamie L. Ramsgaard on 5/16/2017.
 */
public class Appointments {

    public List<Appointment> getAppointments() // Returnere et Appointment Objekter
    {
        AppointmentHandler appointmentHandler = new AppointmentHandler();
        List<Appointment> appointments;

        appointments = appointmentHandler.getAppointments();
        return appointments;
    }

    public void newAppointment(String appointmentStartDate, String appointmentSessionLength, String appointmentNote, String userId, String customerId)
    public Appointment getAppointment (String appointmentID) // Returnere et Appointment Objekt
    {
        AppointmentHandler appointmentHandler = new AppointmentHandler();
        Appointment appointment = appointmentHandler.getAppointment(appointmentID);
        return appointment;

    }

    public void newAppointment(String appointmentStartDate, String appointmentSessionLength, String appointmentNote)
    {
        AppointmentHandler appointmentHandler = new AppointmentHandler();

        appointmentHandler.newAppointment(appointmentStartDate, appointmentSessionLength, appointmentNote, userId, customerId);

    }
}
