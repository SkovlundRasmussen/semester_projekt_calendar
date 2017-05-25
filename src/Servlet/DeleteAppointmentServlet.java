package Servlet;

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
 * Created by Jamie L. Ramsgaard on 5/24/2017.
 */
@WebServlet(name = "DeleteAppointmentServlet")
public class DeleteAppointmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Entering DeleteCustomerServlet-doPost");
        AppointmentHandler appointmentHandler = new AppointmentHandler();

        //users.newUser(request.getParameter("userName"), request.getParameter("userPass"));

        request.setAttribute("appointmentStartDate", request.getParameter("app_start_date"));
        request.setAttribute("appointmentSessionLength", request.getParameter("app_session_length"));
        request.setAttribute("appointmentNote", request.getParameter("app_note"));

        request.setAttribute("appointmentID", request.getParameter("app_id"));

        appointmentHandler.deleteAppointment(/*request.getParameter("app_start_date"), request.getParameter("app_session_length"),
                request.getParameter("app_note"),*/ request.getParameter("app_id"));

        request.getRequestDispatcher("/delete_appointment").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("DELETE APPOINTMENT");
        Appointments appointments = new Appointments();

        Appointment appointment = appointments.getAppointment(request.getParameter("appointment_id"));
        HttpSession getAppointmentSession = request.getSession(true);



        getAppointmentSession.setAttribute("appointment", appointment);

        request.getRequestDispatcher("/delete_appointment.jsp").forward(request, response);
    }
}
