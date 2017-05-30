package Controller;

public class Appointment {
    private int appointmentID;
    private String appointmentDate;
    private String appointmentLength;
    private String appointmentNote;

    public Appointment(int appointmentID, String appointmentDate, String appointmentLength, String appointmentNote) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.appointmentLength = appointmentLength;
        this.appointmentNote = appointmentNote;
    }


    public int getAppointmentID() {
        return appointmentID;
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

}
