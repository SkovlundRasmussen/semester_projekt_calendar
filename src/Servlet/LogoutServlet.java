package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by krist on 22-May-17.
 */
@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession(false).getAttribute("loginSession") != null)
        {
            request.getSession().removeAttribute("loginSession");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        else
        {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
