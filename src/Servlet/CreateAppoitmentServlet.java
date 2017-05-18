package Servlet;

import Controller.Appointment;

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
public class CreateAppoitmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("CreateAppoitmentServlet loading");
        Appointment appointment = new Appointment();

        request.setAttribute("appointmentStartDate", request.getParameter("appointmentStartDate"));
        request.setAttribute("appointmentSessionLength", request.getParameter("appointSessionLength"));
        request.setAttribute("appointmentNote", request.getParameter("appointmentNote"));

        appointment.newAppointment(request.getParameter("appointmentStartDate"), request.getParameter
                ("appointSessionLength"), request.getParameter("appointmentNote"));
        request.getRequestDispatcher()



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
