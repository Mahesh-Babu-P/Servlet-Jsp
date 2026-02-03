package sample;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/sayHello")
public class HelloSample extends HttpServlet{
	
//    @Override
//	public void doGet(HttpServletRequest req, HttpServletResponse res ) throws IOException {
//		PrintWriter out =  res.getWriter();
//		out.println("hello servlet world");
//	}
	
	// using postman tool for getting unique response
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res ) throws IOException {
		PrintWriter out = res.getWriter();
		out.println("Get method activated....!");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res ) throws IOException {
		PrintWriter out = res.getWriter();
		out.println("post method activated....!");
	}
	
	@Override
	public void doPut(HttpServletRequest req, HttpServletResponse res ) throws IOException {
		PrintWriter out = res.getWriter();
		out.println("put method activated....!");
	}
	
	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res ) throws IOException {
		PrintWriter out = res.getWriter();
		out.println("delete method activated....!");
	}
	
//	@Override
//	public void init()
//	{
//		System.out.println("init method initialised...!");
//	}
	
//	@Override
//	public void service(HttpServletRequest req, HttpServletResponse res) {
//		
//		System.out.println("service method....");
//	}
	
//	@Override
//	public void destroy()
//	{
//		System.out.println("Destroyed...");
//	}
}


