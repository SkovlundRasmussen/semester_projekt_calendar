package Servlet;

import DataLayer.UserHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Peter on 22-05-2017.
 */
@WebServlet(name = "EditUserServlet")
public class EditUserServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        UserHandler userHandler = new UserHandler();

        request.setAttribute("userID", request.getParameter("userID"));
        request.setAttribute("userPass", request.getParameter("userPass"));
        request.setAttribute("userPass2", request.getParameter("userPass2"));

        if(request.getParameter("userPass").equals(request.getParameter("userPass2"))) //Checks if password 1 & 2 are the same.
        {
            userHandler.editUser(request.getParameter("userPass"), request.getParameter("userID"));
            request.setAttribute("errorMessage", "Dit password er nu ændret");
            request.getRequestDispatcher("/edit_user.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("errorMessage", "Passwords stemmer ikke overens"); //Shows confirm msg on html
            request.getRequestDispatcher("/edit_user.jsp").forward(request, response);
        }

    }
    //Peter

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        HttpSession session = request.getSession(true);
        String user_id = session.getAttribute("user_id").toString();
        String user_name = session.getAttribute("user_name").toString();

        if(user_id != null) {
            request.setAttribute("user_name", user_name);
            request.setAttribute("user_id", user_id);
            request.getRequestDispatcher("/edit_user.jsp").forward(request, response);
        }
    }
    //Peter


}
