package Servlet;

import Controller.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        System.out.println("SHOW CALENDAR");
        Appointments appointments = new Appointments();


        List<Calendar> calendars;

        HttpSession session = request.getSession(true);
        String user_id = session.getAttribute("user_id").toString();


        calendars = appointments.getCalendars(user_id);


/*
        CalendarTest calendarTest = new CalendarTest("bob", "2017-05-05");

        List<CalendarTest> calendarTestList = new ArrayList<>();

        calendarTestList.add(calendarTest);
*/

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(new Gson().toJson(calendars));
    }


}

