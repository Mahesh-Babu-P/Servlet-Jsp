package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection Connect(String url,String uname,String pass) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//System.out.println("Driver loaded successfully...!");
//        return DriverManager.getConnection(
//            "jdbc:mysql://localhost:3306/servletdb1",
//            "root",
//            "9797*Ak"
		return DriverManager.getConnection(url,uname,pass);
        
        
	}
	
}
