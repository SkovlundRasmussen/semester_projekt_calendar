package Servlet;

import Controller.Users;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nichlas B. Toldam on 17-05-2017.
 */
@WebServlet(name = "CreateUserServlet")
public class CreateUserServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("CreateUserServlet loading");
        Users users = new Users();

        //request.setAttribute("userTypeId", request.getParameter("userTypeId"));
        request.setAttribute("userName", request.getParameter("userName"));
        request.setAttribute("userPass", request.getParameter("userPass"));

        users.newUser(request.getParameter("userName"), request.getParameter("userPass"));
        request.getRequestDispatcher("/create_user.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}

