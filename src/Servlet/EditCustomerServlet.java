package Servlet;

import Controller.Customer;
import Controller.Customers;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

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
