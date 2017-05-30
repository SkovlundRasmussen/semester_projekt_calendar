package Controller;

import DataLayer.AppointmentHandler;
import DataLayer.CalendarHandler;
import java.util.List;

public class Appointments {

    public List<Appointment> getAppointments(String user_id) // Returnere en liste med Appointment Objekter
    {
        AppointmentHandler appointmentHandler = new AppointmentHandler();
        List<Appointment> appointments;

        appointments = appointmentHandler.getAppointments(user_id);
        return appointments;
    }
    //Jamie

    public Appointment getAppointment (String appointmentID) // Returnere et Appointment Objekt
    {
        AppointmentHandler appointmentHandler = new AppointmentHandler();
        Appointment appointment = appointmentHandler.getAppointment(appointmentID);
        return appointment;

    }
    //Jamie

    public void newAppointment(String appointmentStartDate, String appointmentSessionLength, String appointmentNote, String userId, String customerId)
    {
        AppointmentHandler appointmentHandler = new AppointmentHandler();

        appointmentHandler.newAppointment(appointmentStartDate, appointmentSessionLength, appointmentNote, userId, customerId);
    }
    //Jamie

    public List<Calendar> getCalendars(String user_id) // Returnere et Appointment Objekter
    {
        CalendarHandler calendarHandler = new CalendarHandler();
        List<Calendar> appointments;
        appointments = calendarHandler.getAppointments(user_id);
        return appointments;
    }
    //Kristan
}
