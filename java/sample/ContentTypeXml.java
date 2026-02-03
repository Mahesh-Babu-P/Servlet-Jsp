package sample;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/xml")
public class ContentTypeXml extends HttpServlet
{
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
     {
    	   res.setContentType("application/xml");
    	   
    	   PrintWriter out =  res.getWriter();
    	   out.println("<employee>");
    	   out.println("<id>101</id>");
    	   out.println("<name>mahesh</name>");
    	   out.println("<salary>62500.32</salary>");
    	   out.println("</employee>");
     }
	
	
}
