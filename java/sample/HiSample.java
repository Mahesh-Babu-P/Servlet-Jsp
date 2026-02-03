package sample;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/sayhi")
public class HiSample extends HttpServlet{
//	@Override
//	public void doGet(HttpServletRequest req, HttpServletResponse res ) throws IOException {
//		PrintWriter out =  res.getWriter();
//		out.println("hello servlet another world...!");
//	}
//	
//	
	
	// servlet's life cycle
	
	@Override
	public void init()
	{
		System.out.println("init method initialised...!");
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println("service method....");
	}
	
	@Override
	public void destroy()
	{
		System.out.println("Destroyed...");
	}
}
