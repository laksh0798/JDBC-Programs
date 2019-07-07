package jdbc;
import java.sql.*;
public class Update {
	public static void main(String args[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pract", "root", "root");
			
			Statement st = conn.createStatement();
			
			String sql = "update employee  set lastname = 'Tidake' where id= 4";
			st.executeUpdate(sql);
			
			
				System.out.println("data updated");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
