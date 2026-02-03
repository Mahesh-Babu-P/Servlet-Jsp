package sample;

import java.io.BufferedReader;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/request")
public class ReaderRequest extends HttpServlet
{
     @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	    BufferedReader in = req.getReader();
    	    
    	    int i = 1;
    	    
    	    while((i = in.read()) != -1)
    	    {
    	    	char ch = (char) i;
    	    	System.out.print(ch);
    	    }
    	    
    	    
    }
}
