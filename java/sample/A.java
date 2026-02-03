package sample;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/a")
public class A extends HttpServlet
{
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
     {
//    	 req.setAttribute("name", "mahesh");
//    	 req.setAttribute("password","pass123");
//    	 req.getRequestDispatcher("/b").forward(req, res);
    	 
    	 
//    	 ServletContext con = req.getServletContext();
//    	 String value = (String) con.getAttribute("name");
//    	 System.out.println(value);
//    	 
    	ServletConfig config = super.getServletConfig();
    	String name = config.getInitParameter("name");
    	System.out.println(name);
     }
}
