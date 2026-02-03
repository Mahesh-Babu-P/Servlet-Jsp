package sample;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/js")
public class ContentTypeJson extends HttpServlet
{
    @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		res.setContentType("application/json");
		PrintWriter out =  res.getWriter();	
		out.println("{");
		out.println("\"id\":101,");
		out.println("\"name\": \"mahesh\",");
		out.println("\"salary\":62500.32");
		out.println("}");
		
//		res.getWriter().print(
//	            "{\"id\":101,\"name\":\"mahesh\",\"salary\":62500.32}"
//	        );
		
	}
	
}
