package sample;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//class User
//{
//	private String username;
//	private String password;
//	
//	public User(String username,String password) {
//		this.username = username;
//		this.password = password;
//	}
//	
//	public String getUsername() {
//		return username;
//	}
//	
//	public String getPassword() {
//		return password;
//	}
//}


@WebServlet("/login")
public class LoginForm extends HttpServlet
{
      public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
      {
    	  res.setContentType("text/html");
    	  res.getWriter().println("""
    			  <!DOCTYPE html>
    			  <html>
    			  <head>
    			      <title>Login Form</title>

    			      <style>
    			          body {
    			              margin: 0;
    			              padding: 0;
    			              height: 100vh;
    			              background: linear-gradient(to right, #4facfe, #00f2fe);
    			              display: flex;
    			              justify-content: center;
    			              align-items: center;
    			              font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    			          }

    			          .login-box {
    			              background: #ffffff;
    			              padding: 30px 40px;
    			              width: 350px;
    			              border-radius: 10px;
    			              box-shadow: 0 10px 25px rgba(0,0,0,0.2);
    			          }

    			          .login-box h2 {
    			              text-align: center;
    			              margin-bottom: 25px;
    			              color: #333;
    			          }

    			          label {
    			              font-weight: bold;
    			              color: #555;
    			          }

    			          input[type="text"],
    			          input[type="password"] {
    			              width: 100%;
    			              padding: 10px;
    			              margin-top: 6px;
    			              margin-bottom: 18px;
    			              border-radius: 5px;
    			              border: 1px solid #ccc;
    			              font-size: 14px;
    			          }

    			          button {
    			              width: 100%;
    			              padding: 12px;
    			              background-color: #4facfe;
    			              border: none;
    			              border-radius: 5px;
    			              color: white;
    			              font-size: 16px;
    			              font-weight: bold;
    			              cursor: pointer;
    			          }

    			          button:hover {
    			              background-color: #00c6fb;
    			          }

    			          .json-link {
    			              text-align: center;
    			              margin-top: 15px;
    			          }

    			          .json-link a {
    			              text-decoration: none;
    			              color: #4facfe;
    			              font-weight: bold;
    			          }

    			          .json-link a:hover {
    			              text-decoration: underline;
    			          }
    			      </style>
    			  </head>

    			  <body>
    			      <div class="login-box">
    			          <h2>Login</h2>

    			          <form action="validate" method="">
    			              <label>Username</label>
    			              <input type="text" name="username" required>

    			              <label>Password</label>
    			              <input type="password" name="password" required>

    			              <button type="submit">Login</button>
    			          </form>

    			          <div class="json-link">
    			              <a href="validate">View All Users (JSON)</a>
    			          </div>
    			      </div>
    			  </body>
    			  </html>
    			  """); // paste  html page
      }
}
