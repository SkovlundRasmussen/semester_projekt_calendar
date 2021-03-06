package Servlet;
//jamie
import Controller.Appointment;
import Controller.Appointments;
import DataLayer.AppointmentHandler;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Jamie L. Ramsgaard on 5/22/2017.
 */
@WebServlet(name = "EditAppointmentServlet")
public class EditAppointmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entering EditCustomerServlet-doPost");
        AppointmentHandler appointmentHandler = new AppointmentHandler();

        request.setAttribute("appointmentStartDate", request.getParameter("app_start_date"));
        request.setAttribute("appointmentSessionLength", request.getParameter("app_session_length"));
        request.setAttribute("appointmentNote", request.getParameter("app_note"));

        request.setAttribute("appointmentID", request.getParameter("app_id"));

        appointmentHandler.editAppointment(request.getParameter("app_start_date"), request.getParameter("app_session_length"), request.getParameter("app_note"), request.getParameter("app_id"));

        response.sendRedirect("/show_appointment");
    }
    //Jamie


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("EDIT APPOINTMENT");
        Appointments appointments = new Appointments();

        String appointmentId = request.getParameter("appointment_id");
        Appointment appointment = appointments.getAppointment(appointmentId);
        HttpSession getAppointmentSession = request.getSession(true);

        getAppointmentSession.setAttribute("appointment", appointment);

        request.getRequestDispatcher("/edit_appointment.jsp").forward(request, response);
    }
    //Jamie
}
