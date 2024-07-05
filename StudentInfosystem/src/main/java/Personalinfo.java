

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
import java.sql.ResultSetMetaData;
public class Personalinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Personalinfo() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 String jntuno=request.getParameter("jntuno");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","sravani@2004");
			 
			PreparedStatement ps = con.prepareStatement("select jntuno,name,fname,mname,address,phone,email,gender,datebirth from studentpersonalinfo where jntuno= ?");
			ps.setString(1, jntuno);
			out.print("<table width= 75% border= 1 >");
			out.print("<caption> Student Details </caption>");
			 ResultSet rs=ps.executeQuery();
			 ResultSetMetaData rsmd=rs.getMetaData();
			 int totalColumn=rsmd.getColumnCount();
			 out.print("<tr>");
			 for(int i=1;i<=totalColumn;i++) {
				 out.print("<th>"+rsmd.getColumnName(i)+"</th>");
			 }
			 out.print("</tr>");
			 while(rs.next()) {
				 out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td></tr>");
				 
			 }
			 out.print("</table>");
			 }
		catch(Exception e)
		{
			out.println(e);
		}
	}
}


