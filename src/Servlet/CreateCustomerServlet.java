package Servlet;

import Controller.Customers;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by krist on 17-May-17.
 */
@WebServlet(name = "CreateCustomerServlet")
public class CreateCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SERVLET!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Customers customers = new Customers();

        request.setAttribute("firstName", request.getParameter("firstName"));
        request.setAttribute("lastName", request.getParameter("lastName"));
        request.setAttribute("phoneNumber", request.getParameter("phoneNumber"));

        customers.newCustomer(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("phoneNumber"));
        request.getRequestDispatcher("/create_customers.jsp").forward(request, response);

       /* if (login.isValidUserCredentials(request.getParameter("loginname"), request.getParameter("password"))) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else{
            request.setAttribute("errorMessage", "Invalid login and password. Try again");
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
