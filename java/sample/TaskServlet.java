package sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

class Employee {
	private int id;
	private String name;
	private double salary;
	
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;	
	}
	 
	public int getId() {return id; }
	public String getName() {return name; }
	public double getSalary(){return salary; }
		
}

@WebServlet("/employee")
public class TaskServlet extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Employee> emp = null;
	public void loadData() {
		this.emp = new ArrayList<>(
				Arrays.asList(new Employee (1,"mahesh",89500),
						      new Employee (2, "Ravi", 72000),
						      new Employee (3, "Kiran", 65000),
						      new Employee (4, "Asha", 78000),
						      new Employee (5, "Meena", 54000)     
						));
				
	}
//    static ArrayList<Employee> arr = new ArrayList<>();
//    
//    static  { // load data only once
//    	arr.add(new Employee(1,"mahesh",89500));
//    	arr.add(new Employee(2, "Ravi", 72000));
//        arr.add(new Employee(3, "Kiran", 65000));
//        arr.add(new Employee(4, "Asha", 78000));
//        arr.add(new Employee(5, "Meena", 54000));
//        arr.add(new Employee(6, "John", 82000));
//        arr.add(new Employee(7, "Suresh", 60000));
//        arr.add(new Employee(8, "Vijay", 91000));
//        arr.add(new Employee(9, "Anita", 70000));
//        arr.add(new Employee(10, "Rahul", 58000));
//    }
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException 
    {
    	
    	loadData();
    	StringBuilder json = new StringBuilder();
    	json.append("{\"employee\":[");
    	
    	for(int i = 0;i < emp.size();i++)
    	{
    		Employee e = emp.get(i);
    		
    		json.append("{");
            json.append("\"id\":").append(e.getId()).append(",");
            json.append("\"name\":\"").append(e.getName()).append("\",");
            json.append("\"salary\":").append(e.getSalary());
            json.append("}");
            
            if(i < emp.size() -1) {
            	json.append(",");
            }
    	}
    	json.append("]}");
    	
    	res.setContentType("application/json");
    	
    	PrintWriter out = res.getWriter();
    	out.print(json.toString());
    	

    	// --------------------------->
//    	StringBuilder jsonres = new StringBuilder("employee : [ ");
//    	int last = emp.size()-1;
//    	for(int i =0;i<emp.size();i++) {
//    		Employee employee = emp.get(i);
//    		String line = String.format("{\"id", emp);
//    		if(i == last) {
//    			jsonres.append(line).append("]");
//    		}else {
//    			jsonres.append(line).append(",");
//    		}
//    	}
//    	String response = jsonres.toString();
//    	
//    	res.setCharacterEncoding("application/json");
//    	PrintWriter out = res.getWriter();    
//    	out.println(response);
    //	---------------------- >>>>> 
//    	addEmployee();
//    	
//    	out.println("[");
//    	
//    	for(int i = 0; i < arr.size();i++) {
//    		Employee e = arr.get(i);
//    		
//    		out.println(" {");
//    		out.println(" \"id\":"+e.getId()+",");
//    		out.println(" \"name\":"+e.getName()+",");
//    		out.println(" \"salary\":"+e.getSalary()+",");
//    		out.println(" }");
//    		
//    		if(i < arr.size()-1) {
//    			out.println(",");
//    		}
//    	}
//    	out.println();
//    	out.println("]");
    }
}
