

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 PrintWriter out=response.getWriter();
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","sravani@2004");
			 String n=request.getParameter("username");
			 String p=request.getParameter("password");
			PreparedStatement ps=con.prepareStatement("select jntuno from studentpersonalinfo where jntuno=? and password=?");
			ps.setString(1,n);
			ps.setString(2, p);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				RequestDispatcher rd=request.getRequestDispatcher("info.html");
				rd.forward(request, response);
			}
			else
			{
				out.println("<font color size=18>LOGIN FAILED!! ...TRY AGAIN<br>");
				out.println("<a href=register.html>PLEASE REGISTER!!!</a>");
			}
		  }
		  catch(ClassNotFoundException e) {
			  e.printStackTrace();
			  }catch(SQLException e) {
				  e.printStackTrace();  
			  }
	  }
	}

