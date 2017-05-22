package Servlet;
//jamie
import Controller.Appointment;
import Controller.Appointments;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jamie L. Ramsgaard on 5/18/2017.
 */
@WebServlet(name = "CreateAppoitmentServlet")
public class CreateAppoitmentServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("CreateAppoitmentServlet loading");
        Appointments appointments = new Appointments();

        request.setAttribute("appointmentStartDate", request.getDateHeader("app_start_date"));
        request.setAttribute("appointmentSessionLength", request.getParameter("app_session_length"));
        request.setAttribute("appointmentNote", request.getParameter("app_note"));

        appointments.newAppointment(request.getParameter("app_start_date"),
                request.getParameter("app_session_length"), request.getParameter("app_note"));
        request.getRequestDispatcher("/create_appointment.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
