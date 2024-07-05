
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	import com.mysql.cj.xdevapi.Statement;

	public class RegisterDemo { 
		private String dbUrl ="jdbc:mysql://localhost:3306/studentinfo";
		private String dbUname = "root";
		private String dbPassword ="sravani@2004";
		private String dbDriver ="com.mysql.cj.jdbc.Driver";
		 public void loadDriver(String dbDriver) {
			 try {
				Class.forName(dbDriver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 public Connection getConnection(){
			 Connection con=null;
			 try {
			 con=DriverManager.getConnection(dbUrl,dbUname,dbPassword);
			 }
			 catch(SQLException e) {
				 e.printStackTrace();
			 }
			 return con;
		 
		 }
		
		public String insert(studentpersonalinfo studentpersonalinfo) {
			
			loadDriver(dbDriver);
			Connection con =getConnection();
			String result="data entered successfully";
			String sql="insert into studentpersonalinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps;
			
			try {
				
				java.sql.Statement ps1= con.createStatement();
		     ps=con.prepareStatement(sql);
		
			 ((PreparedStatement) ps1).setString(1, studentpersonalinfo.getJntuno());
			((PreparedStatement) ps1).setString(2, studentpersonalinfo.getName());
			((PreparedStatement) ps1).setString(3, studentpersonalinfo.getFname());
			((PreparedStatement) ps1).setString(4, studentpersonalinfo.getMname());
			((PreparedStatement) ps1).setString(5, studentpersonalinfo.getAddress());
			((PreparedStatement) ps1).setString(6, studentpersonalinfo.getPhone());
			((PreparedStatement) ps1).setString(7, studentpersonalinfo.getEmail());
			((PreparedStatement) ps1).setString(8, studentpersonalinfo.getGender());
			((PreparedStatement) ps1).setString(9, studentpersonalinfo.getDateofbirth());
			((PreparedStatement) ps1).setString(10, studentpersonalinfo.getPassword());
			((PreparedStatement) ps1).setString(11, studentpersonalinfo.getCollege());
			((PreparedStatement) ps1).setString(12, studentpersonalinfo.getBranch());
			((PreparedStatement) ps1).setString(13, studentpersonalinfo.getYear());
			((PreparedStatement) ps1).setString(14, studentpersonalinfo.getSemester());
			((PreparedStatement) ps1).setString(15, studentpersonalinfo.getCgpa());
							
			
			ps1.executeUpdate(sql);
			con.close();
			}
			catch(SQLException e) {
				 e.printStackTrace();
				 result="data  is not inserted";
			 }
			return result;
			
		}

	}


