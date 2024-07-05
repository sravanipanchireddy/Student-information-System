

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Update() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    String phone=request.getParameter("phone");
		 String year=request.getParameter("year");
		 String semester=request.getParameter("semester");
		 String cgpa=request.getParameter("cgpa");
		 String jntuno=request.getParameter("jntuno");
		 int status=0;
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","sravani@2004");
			PreparedStatement ps = con.prepareStatement("update studentpersonalinfo set phone=?, year=?, semester=?, cgpa=? where jntuno= ?");
			ps.setString(1, phone);	
			ps.setString(2, year);	
			ps.setString(3, semester);	
			ps.setString(4, cgpa);
			ps.setString(5, jntuno);
			status=ps.executeUpdate();
			if (status>0)
			{
				out.println("<H1> Record Updated successfully!!!</h1>");
		   }
			else
			{
				out.println("<p> sorry !!! record not Updated please try again</p>");
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 }
	}
