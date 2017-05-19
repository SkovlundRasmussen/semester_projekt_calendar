package Servlet;

import Controller.Customer;
import Controller.Customers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by krist on 18-May-17.
 */
@WebServlet(name = "ShowCustomerServlet")
public class ShowCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SHOW CUSTOMERS");
        Customers customers = new Customers();
        List<Customer> customerList = customers.getCustomers();

        request.setAttribute("customers", customerList);
        request.getRequestDispatcher("/show_customers.jsp").forward(request, response);
    }
}
