package Servlet;

import Controller.Customers;
import Controller.ErrorHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateCustomerServlet")
public class CreateCustomerServlet extends HttpServlet implements ServletInterface
{

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Entering CreateCustomerServlet");
        boolean error = true;
        Customers customers = new Customers();

        requestAttributes(request); // load Attributes

        error = isErrorPhoneNumber(request, response, error); // Check for errors in phone number
        error = isErrorFirstName(request, response, error); // Check for errors in first name
        error = isErrorLastName(request, response, error);  // Check for errors in last name
        noError(request, response, error, customers); // if no error. confirm and submit attributes to database

    }
    //Kristian og Nichlas

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Entering doGet Create Customer");

        HttpSession session = request.getSession(true);
        String user_id = session.getAttribute("user_id").toString();

        if(user_id != null)
        {
            request.setAttribute("userId", user_id);
        }

        request.getRequestDispatcher("/create_customers.jsp").forward(request, response);
    }
    //Nichlas, Kristian

    public void requestAttributes(HttpServletRequest request)
    {
        request.setAttribute("firstName", request.getParameter("firstName"));
        request.setAttribute("lastName", request.getParameter("lastName"));
        request.setAttribute("phoneNumber", request.getParameter("phoneNumber"));

    }
    //Nichlas

    public void noError(HttpServletRequest request, HttpServletResponse response, boolean error, Customers customers) throws ServletException, IOException
    {
        if (error)
        {
            System.out.println("Data is stored in database");
            customers.newCustomer(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("phoneNumber"), request.getParameter("user_id"));
            request.setAttribute("errorMessage", "Ny kunde er blevet oprettet"); //Show confirm msg on jsp
            request.getRequestDispatcher("/create_customers.jsp").forward(request, response);
        }
    }
    //Nichlas

    private boolean isErrorPhoneNumber(HttpServletRequest request, HttpServletResponse response, boolean error) throws ServletException, IOException
    {
        if (ErrorHandler.IsAValidNumber(request.getParameter("phoneNumber")))
        {
            System.out.println("phoneNumber error");
            error = false;
            request.setAttribute("errorMessage", "Telefonnummeret må ikke indeholde bogstaver, prøv igen"); //Show error msg on jsp
            request.getRequestDispatcher("/create_customers.jsp").forward(request, response);
        }
        return error;
    }
    //Nichlas

    private boolean isErrorLastName(HttpServletRequest request, HttpServletResponse response, boolean error) throws ServletException, IOException
    {
        if (ErrorHandler.IsAValidName(request.getParameter("lastName")))
        {
            System.out.println("lastName error");
            error = false;
            request.setAttribute("errorMessage", "Efternavnet må ikke indeholde tal, prøv igen"); //Show error msg on jsp
            request.getRequestDispatcher("/create_customers.jsp").forward(request, response);
        }
        return error;
    }
    //Nichlas

    private boolean isErrorFirstName(HttpServletRequest request, HttpServletResponse response, boolean error) throws ServletException, IOException
    {
        if (ErrorHandler.IsAValidName(request.getParameter("firstName")))
        {
            System.out.println("firstName error");
            error = false;
            request.setAttribute("errorMessage", "Fornavnet må ikke indeholde tal, prøv igen"); //Show error msg on jsp
            request.getRequestDispatcher("/create_customers.jsp").forward(request, response);
        }
        return error;
    }
    //Nichlas
}