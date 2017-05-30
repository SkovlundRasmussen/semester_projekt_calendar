package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by krist on 22-May-17.
 */
@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String user_id = session.getAttribute("user_id").toString();
        if(user_id != null)
        {
            request.getSession().removeAttribute("user_id");
            request.getSession().removeAttribute("user_name");
            request.getSession().removeAttribute("user_type");
            response.sendRedirect("/login.jsp");
        }
        else
        {
            response.sendRedirect("/login.jsp");
        }
    }
    //Kristian
}
