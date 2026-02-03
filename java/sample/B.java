package sample;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/b")
public class B extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
    {
		String name = (String) req.getAttribute("name");
		String password = (String) req.getAttribute("password");
		
		
		System.out.println(name +" - "+ password);
    }
}
