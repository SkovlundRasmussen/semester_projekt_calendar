package Servlet;

import Controller.Appointments;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        request.setAttribute("customer_id", request.getParameter("customer_id"));

        HttpSession session = request.getSession(true);
        String user_id = session.getAttribute("user_id").toString();
        String customer_id = request.getParameter("customer_id");

        if(user_id != null)
        {
            appointments.newAppointment(request.getParameter("app_start_date"), request.getParameter("app_session_length"), request.getParameter("app_note"), user_id, customer_id);
        }

        response.sendRedirect("/index.jsp");
    }
    // Jamie, Kristian

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String user_id = session.getAttribute("user_id").toString();
        request.setAttribute("user_id", user_id);
        request.setAttribute("customer_id", request.getParameter("customer_id"));
        request.getRequestDispatcher("/create_appointment.jsp").forward(request, response);
    }
    //Jamie
}
