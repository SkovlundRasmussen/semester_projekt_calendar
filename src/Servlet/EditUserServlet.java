package Servlet;

import Controller.User;
import Controller.Users;

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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("EDIT USER");
        Users users = new Users();

        User user = users.newUser(request.getParameter("user_id"));
        HttpSession getUsersSession = request.getSession(true);

        getUsersSession.setAttribute("User", user);


        /*request.setAttribute("customers", customerList);*/

        request.getRequestDispatcher("/edit_user.jsp").forward(request, response);
    }

}
