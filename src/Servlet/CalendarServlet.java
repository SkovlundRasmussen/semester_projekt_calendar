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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tolda on 20-05-2017.
 */
//Nichlas
@WebServlet(name = "CalendarServlet")
public class CalendarServlet extends HttpServlet implements ServletInterface
{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int monthInt;
        int yearInt;

        //appointmentStartDate
        //appointmentSessionLength

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }










/*

    */
/*
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        Appointments appointments = new Appointments();

        int dayInt;
        int monthInt;
        int yearInt;

        *//*
*/
/*
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        *//*
*/
/*



        List<Appointment> appointmentsList = new LinkedList<>();


        JdbcDao dao = new JdbcDao();
        ArrayList<Appointment> apps = dao.getAppointments2(monthInt, yearInt, patients);

        // convert "apps" to "events"

        String json = new Gson().toJson(events);


        // Write JSON string.
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);*//*




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int dayInt;
        int monthInt;
        int yearInt;

        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");

        System.out.println("Show appointments");

        Appointments appointments = new Appointments();
        List<Appointment> appointmentsList = new LinkedList<>();

        HttpSession session = request.getSession(true);

        session.setAttribute("appointments", appointmentsList);
        request.setAttribute("appointments", appointmentsList);

        */
/*
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        *//*



*/

}

