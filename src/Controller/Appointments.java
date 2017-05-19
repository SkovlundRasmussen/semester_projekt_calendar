package Controller;

import DataLayer.AppointmentHandler;
import DataLayer.UserHandler;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jamie L. Ramsgaard on 5/16/2017.
 */
public class Appointments {

    private List getAppointmentList()
    {
        List<Appointment> appointmentsList = new LinkedList<>();

        return appointmentsList;
    }

    public void newAppointment(String appointmentStartDate, String appointmentSessionLength, String appointmentNote)
    {
        AppointmentHandler appointmentHandler = new AppointmentHandler();

        appointmentHandler.newAppointment(appointmentStartDate, appointmentSessionLength, appointmentNote);

    }
}
