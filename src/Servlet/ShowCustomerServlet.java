package Servlet;

import Controller.Customer;
import Controller.Customers;
import Controller.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowCustomerServlet")
public class ShowCustomerServlet extends HttpServlet implements ServletInterface
{

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        String user_id = session.getAttribute("user_id").toString();

        if(user_id != null)
        {
            Customers customers = new Customers();
            List<Customer> customerList = customers.getCustomers(user_id);
            request.setAttribute("customers", customerList);
            request.getRequestDispatcher("/show_customers.jsp").forward(request, response);
        }
        else
        {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
    //Kristian




// OLD CODE
/*  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
        System.out.println("SHOW CUSTOMERS");
        Customers customers = new Customers();
        List<Customer> customerList = customers.getCustomers();

        HttpSession session = request.getSession(true);

        session.setAttribute("customers", customerList);

        request.setAttribute("customers", customerList);

        request.getRequestDispatcher("/show_customers.jsp").forward(request, response);
    }
*/
}
