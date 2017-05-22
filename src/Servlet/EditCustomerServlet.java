package Servlet;

import Controller.Customer;
import Controller.Customers;
import DataLayer.CustomerHandler;
import DataLayer.UserHandler;

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
@WebServlet(name = "EditCustomerServlet")
public class EditCustomerServlet extends HttpServlet {
    //Nichlas
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entering EditCustomerServlet-doPost");
        CustomerHandler customerHandler = new CustomerHandler();

        //users.newUser(request.getParameter("userName"), request.getParameter("userPass"));

        request.setAttribute("firstName", request.getParameter("firstName"));
        request.setAttribute("lastName", request.getParameter("lastName"));
        request.setAttribute("phoneNumber", request.getParameter("phoneNumber"));

        request.setAttribute("customer_id", request.getParameter("customerID"));

        customerHandler.editCustomer(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("phoneNumber"), request.getParameter("customerID"));

        request.getRequestDispatcher("/show_customers").forward(request, response);
    }

    //Kristian
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("EDIT CUSTOMERS");
        Customers customers = new Customers();

        Customer customer = customers.getCustomer(request.getParameter("customer_id"));
        HttpSession getCustomerSession = request.getSession(true);

        getCustomerSession.setAttribute("customer", customer);


        /*request.setAttribute("customers", customerList);*/

        request.getRequestDispatcher("/edit_customer.jsp").forward(request, response);
    }


}
