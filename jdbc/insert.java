package jdbc;
import java.sql.*;
public class insert {
	public static void main(String args[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pract", "root", "root");
			
			Statement st = conn.createStatement();
			
			String sql = "insert into employee  values(4, 'rahul', 'ughade', 'rahul@gmail.com')";
			st.executeUpdate(sql);
			
			System.out.println("data inserted");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
