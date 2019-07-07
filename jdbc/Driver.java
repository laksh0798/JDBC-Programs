package jdbc;
import java.sql.*;
public class Driver {
	public static void main(String args[]) {
	 	try
		{
	 		Class.forName("com.mysql.jdbc.Driver");
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pract", "root", "root");
			 
			 Statement st = conn.createStatement();
			 
			 ResultSet rs = st.executeQuery("select * from employee");
			 
			 while(rs.next())
			 {
				System.out.println(rs.getString("id")+ "  " + rs.getString("firstname")+ "  " +  rs.getString("lastname") + "  " + rs.getString("email"));
							
			 }
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
