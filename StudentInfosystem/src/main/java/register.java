

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.ByteArrayOutputStream;
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public register() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jntuno=request.getParameter("jntuno");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String fname=request.getParameter("fname");
		String mname=request.getParameter("mname");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String dateofbirth=request.getParameter("dateofbirth");
		String college=request.getParameter("college");
		String branch=request.getParameter("branch");
		String year=request.getParameter("year");
		String semester=request.getParameter("semester");
		String cgpa=request.getParameter("cgpa");
		int status;
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","sravani@2004");
			PreparedStatement ps = con.prepareStatement("insert into studentpersonalinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, jntuno);
             ps.setString(2,name);
             ps.setString(3,fname );
             ps.setString(4,mname );
             ps.setString(5,address );
             ps.setString(6,phone );
             ps.setString(7,email );
             ps.setString(8,gender );
             ps.setString(9,dateofbirth );
             ps.setString(10,password );
             ps.setString(11,college );
             ps.setString(12,branch );
             ps.setString(13,year );
             ps.setString(14,semester );
             ps.setString(15,cgpa );
            status=ps.executeUpdate();
		    if (status>0)
		   {
			   
			    response.sendRedirect("success.html");
		   }
		  else
		  {
			  response.sendRedirect("failure.html");
		  }
      } catch (Exception e) {
		e.printStackTrace();
	}
}
}
