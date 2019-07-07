package jdbc;
import java.sql.*;
public class Delete {
	public static void main(String args[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pract", "root", "root");
			
			Statement st = conn.createStatement();
			
			String sql = "delete from employee where id= 1";
			int ra =  st.executeUpdate(sql);
			
			System.out.println("Row affected: " + ra);
			System.out.println("delete complete");		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
