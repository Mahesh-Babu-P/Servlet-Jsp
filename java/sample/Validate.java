package sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//@WebServlet("/validate")
public class Validate extends HttpServlet
{
	 // shared ArrayList for storing users
	
	// private static ArrayList<User> user = new ArrayList<>();
	
	private static final long serialVersionUID = 1L;

	   // collect data (Post)
	   @Override
       public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
       {
		  String name = req.getParameter("name");
		  String email = req.getParameter("email");
    	  String mobilenumber = req.getParameter("mobilenumber");
    	  String password = req.getParameter("password");
    	  
    	  //System.out.println(username+" - "+password);
    	  
    	  // store data in arraylist
    	  
    	  // user.add(new User(username,password));+
    	  try {ServletConfig src = super.getServletConfig();
    			String url = src.getInitParameter("url");
    			String uname = src.getInitParameter("uname");
    			String pass = src.getInitParameter("pass");
    			  
    			  Connection con = DBConnection.Connect(url,uname,pass);
    		         PreparedStatement pst =
    		             con.prepareStatement("INSERT INTO register(name,email,mobilenumber,password) VALUES (?,?,?,?)");
    		        pst.setString(1, name);
		            pst.setString(2, email);
    		        pst.setString(3, mobilenumber);
    		        pst.setString(4, password);
    		       int rows =  pst.executeUpdate(); // to get how many rows affected as int rows
    		       System.out.println(rows+" row/s affected...");

    		       // res.getWriter().println("<h3>Inserted Successfully</h3>"); // ** Response already committed.

    		    } catch (Exception e) {
    		        res.getWriter().println("<pre>");
    		        e.printStackTrace(res.getWriter());
    		    }
    	  
//    	  res.setContentType("text/html");
//          res.getWriter().println("""
//              <h3>Data Stored in Database Successfully!</h3>
//              <a href="login">Back to Login</a><br>
//              <a href="validate">View JSON Data</a>
//          """);
    	  res.sendRedirect("loginlink.html"); // redirection to register successfull message page
       }
	   
	   public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
			res.sendRedirect("login.html");
		
	  
       }
}
