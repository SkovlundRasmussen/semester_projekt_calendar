package Servlet;

import Controller.Users;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nichlas B. Toldam on 17-05-2017.
 */
@WebServlet(name = "CreateUserServlet")
public class CreateUserServlet extends HttpServlet implements ServletInterface
{
    //Nichlas

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("CreateUserServlet loading");
        Users users = new Users();

        requestAttributes(request);

        if(request.getParameter("userPass").equals(request.getParameter("userPass2"))) //Checks if password 1 & 2 are the same.
        {
            users.newUser(request.getParameter("userName"), request.getParameter("userPass"));
            request.setAttribute("errorMessage", "Ny bruger oprettet"); //Show confirm msg on html
            request.getRequestDispatcher("/create_user.jsp").forward(request, response);
        }

        {
            request.setAttribute("errorMessage", "Passwords stemmer ikke overens"); //Show confirm msg on html
            request.getRequestDispatcher("/create_user.jsp").forward(request, response);
        }

    }

    //Nichlas
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    //Nichlas
    public void requestAttributes(HttpServletRequest request)
    {
        //request.setAttribute("userTypeId", request.getParameter("userTypeId"));
        request.setAttribute("userName", request.getParameter("userName"));
        request.setAttribute("userPass", request.getParameter("userPass"));
        request.setAttribute("userPass2", request.getParameter("userPass2"));
    }







/*
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("CreateUserServlet loading");
        Users users = new Users();

        requestAttributes(request);

        if(request.getParameter("userPass").equals(request.getParameter("userPass2"))) //Checks if password 1 & 2 are the same.
        {
            users.newUser(request.getParameter("userName"), request.getParameter("userPass"));
            request.setAttribute("errorMessage", "Ny bruger oprettet"); //Show confirm msg on html
            request.getRequestDispatcher("/create_user.jsp").forward(request, response);
        }

        {
            request.setAttribute("errorMessage", "Passwords stemmer ikke overens"); //Show confirm msg on html
            request.getRequestDispatcher("/create_user.jsp").forward(request, response);
        }
    }

    private void requestAttributes(HttpServletRequest request)
    {
        //request.setAttribute("userTypeId", request.getParameter("userTypeId"));
        request.setAttribute("userName", request.getParameter("userName"));
        request.setAttribute("userPass", request.getParameter("userPass"));
        request.setAttribute("userPass2", request.getParameter("userPass2"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
    */
}

