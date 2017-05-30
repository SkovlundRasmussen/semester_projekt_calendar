package Servlet;

import Controller.Customer;
import Controller.Customers;
import DataLayer.CustomerHandler;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EditCustomerServlet")
public class EditCustomerServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entering EditAppointmentServlet-doPost");
        CustomerHandler customerHandler = new CustomerHandler();

        request.setAttribute("firstName", request.getParameter("firstName"));
        request.setAttribute("lastName", request.getParameter("lastName"));
        request.setAttribute("phoneNumber", request.getParameter("phoneNumber"));
        request.setAttribute("customer_id", request.getParameter("customerID"));

        customerHandler.editCustomer(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("phoneNumber"), request.getParameter("customerID"));

        response.sendRedirect("/show_customers");
    }
    //Nichlas

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("EDIT CUSTOMERS");
        Customers customers = new Customers();

        Customer customer = customers.getCustomer(request.getParameter("customer_id"));
        HttpSession getCustomerSession = request.getSession(true);

        getCustomerSession.setAttribute("customer", customer);

        request.getRequestDispatcher("/edit_customer.jsp").forward(request, response);
    }
    //Kristian

}
