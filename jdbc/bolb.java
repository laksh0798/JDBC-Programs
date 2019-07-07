package jdbc;
import java.sql.*;
import java.io.*;
public class bolb {
		public static void main(String args[])
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/pract", "root", "root");
				PreparedStatement ps = conn.prepareStatement("insert into employee(image) value (?)");
				FileInputStream fis = new FileInputStream("/home/laksh/Desktop/1.jpg");
				ps.setBinaryStream(1, fis);
				int i = ps.executeUpdate();
				System.out.println("row affected "+ i  );
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
}
