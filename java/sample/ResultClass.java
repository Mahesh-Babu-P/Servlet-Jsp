package sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/result")
public class ResultClass extends HttpServlet
{

	private static final long serialVersionUID = 1L;


	// print data as JSON (get)
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
 	  
 	  res.setContentType("application/json");
 	  PrintWriter out = res.getWriter();
 	  
// 	  out.print("[");
// 	  for(int i =0;i<user.size();i++) {
// 		  User u = user.get(i);
// 		  
// 		  out.println("{");
// 		  out.println("\"username\":\""+u.getUsername()+"\",");
// 		  out.println("\"password\":\""+u.getPassword()+"\",");
// 		  out.println("}");
// 		  
// 		  if(i < user.size()-1) {
// 			  out.print(",");
// 		  }
// 	  }
// 	  out.print("]");
 	  
 	 String sql = "select name,email,mobilenumber,password from register";
 	 boolean first = true;
 	 StringBuffer sb = new StringBuffer(); // store all fetching data's into a stringBuffer
 	  
 	 
 	 sb.append("[");
 	 
 	//take value from init param and pass to connect method
		ServletConfig src = super.getServletConfig();
		String url = src.getInitParameter("url");
		String uname = src.getInitParameter("uname");
		String pass = src.getInitParameter("pass");

 	  try (Connection con = DBConnection.Connect(url,uname,pass);
 	       PreparedStatement pst =
 	           con.prepareStatement(sql);
 	       ResultSet rs = pst.executeQuery();)
 	  {
 		
//			
// 		  Connection con = DBConnection.Connect(url,uname,pass);
// 	       PreparedStatement pst =
// 	           con.prepareStatement(sql);
// 	       ResultSet rs = pst.executeQuery();

 	      while (rs.next()) {
 	          if (!first) {
 	        	  sb.append(",");
 	          }
 	      
 	                  sb.append("{");
 	    	          sb.append("\"name\":\"" + rs.getString("name")+"\",");
 	    	          sb.append("\"email\":\"" + rs.getString("email")+"\",");
 	    	          sb.append("\"mobilenumber\":\"" + rs.getString("mobilenumber")+"\",");
 	    	          sb.append( "\"password\":\"" + rs.getString("password")+"\"");
 	    	          sb.append("}");             
 	    	          first = false; //  just helping this variable for comma
 	      }

 	    	  } catch (Exception e) {
 	    	      e.printStackTrace();
 	    	  }

 	    	  sb.append("]");
 	    	  
 	    	  String json = sb.toString();
 	    	  out.println(json);  // print stored json via StringBuffer 
 	      }

    
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException 
    {
    	String name = req.getParameter("name");
    	String pass = req.getParameter("password");
    	
    	System.out.println(name+" "+pass);
    	
    	boolean flag = false; // validating login data matched or not 
    	
    	try {
    		// using init param for connecting JDBC 
    		ServletConfig src = super.getServletConfig();
    		String url = src.getInitParameter("url");
    		String user = src.getInitParameter("uname");
    		String password = src.getInitParameter("pass");
    		
    		Connection con = DBConnection.Connect(url,user,password);
    		
    		String sql = "select * from register where name = ? and password = ?";
    		
    		PreparedStatement ps = con.prepareStatement(sql);
    		
    		ps.setString(1,name);
    		ps.setString(2,pass);
    		
    		ResultSet rs = ps.executeQuery();
    		
    		if(rs.next()) {
    			flag = true; // given name and pass already existing means mension login successfull
    			// registered users only 
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}	
    		
    		if(flag) {
    			res.sendRedirect("home.html"); // if validation hits successfull via link go to home page
    		}else {
    			res.sendRedirect("invalidpage.html"); // if validation hits failed via link go to invalid credential page
    	
    	}	
    
    }
}
