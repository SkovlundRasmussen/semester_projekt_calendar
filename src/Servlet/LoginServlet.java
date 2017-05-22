package Servlet;

import Controller.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Login login = new Login();

        request.setAttribute("username", request.getParameter("loginname"));
        request.setAttribute("password", request.getParameter("password"));

        if (login.isValidUserCredentials(request.getParameter("loginname"), request.getParameter("password")) != null) {

            HttpSession loginSession = request.getSession(true);
            loginSession.setAttribute("loginSession",login.isValidUserCredentials(request.getParameter("loginname"), request.getParameter("password")));
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else{
            request.setAttribute("errorMessage", "Invalid login and password. Try again");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}