

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
public class Newpwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Newpwd() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 String password=request.getParameter("password");
		 String jntuno=request.getParameter("jntuno");
		 int status=0;
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","sravani@2004");
			PreparedStatement ps = con.prepareStatement("update studentpersonalinfo set password=? where jntuno= ?");
			ps.setString(1, password);	
			ps.setString(2, jntuno);
			status=ps.executeUpdate();
			if (status>0)
			{
				out.println("<H1>PASSWORD IS CHANGED!!!</h1>");
				out.println("<H1>LOGIN HERE TO GET YOUR DETAILS</h1>");
				out.println("<a href=login.html>LOGIN HERE</a>");
				
			}
			else
			{
				out.println("<p> sorry !!! PLEASE TRY AGAIN</p>");
				
			}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
            }
}

