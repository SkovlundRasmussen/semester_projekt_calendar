package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tolda on 21-05-2017.
 */
public interface ServletInterface
{
    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
