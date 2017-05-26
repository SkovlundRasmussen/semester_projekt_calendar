package Servlet;

import Controller.Appointment;
import Controller.Appointments;
import Controller.Customer;
import Controller.Customers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Jamie L. Ramsgaard on 5/21/2017.
 */
@WebServlet(name = "ShowAppointmentServlet")
public class ShowAppointmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SHOW APPOINTMENTS");
        Appointments appointments = new Appointments();

        HttpSession session = request.getSession(true);

        String user_id = session.getAttribute("user_id").toString();

        if(user_id != null)
        {
            List<Appointment> appointmentList = appointments.getAppointments(user_id);
            request.setAttribute("appointments", appointmentList);
        }

        /*
        request.setAttribute("customers", customerList);*/

        request.getRequestDispatcher("/show_appointments.jsp").forward(request, response);
    }
}
