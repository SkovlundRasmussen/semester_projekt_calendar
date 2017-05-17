package Servlet;

import AppLayer.Login;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by Tolda on 16-05-2017.
 */
@WebServlet(name = "Servlet")
public class LoginServlet extends javax.servlet.http.HttpServlet
{
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException
    {
        doPostLogin(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException
    {

    }

    public void doPostLogin(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)throws javax.servlet.ServletException, IOException

    {
        Login login = new Login();

        request.setAttribute("username", request.getParameter("loginname"));
        request.setAttribute("password", request.getParameter("password"));

        if (login.isValidUserCredentials(request.getParameter("loginname"), request.getParameter("password"))) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else{
            request.setAttribute("errorMessage", "Invalid login and password. Try again");
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }
    }

}