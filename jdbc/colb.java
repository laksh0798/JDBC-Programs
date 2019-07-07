package jdbc;
import java.sql.*;
import java.io.*;

public class colb {
	public static void main(String args[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pract", "root", "root");
			PreparedStatement ps = conn.prepareStatement("insert into employee(file) value (?)");
			File f = new File("/home/laksh/Desktop/new.txt");
			FileReader fr = new FileReader(f);
			ps.setCharacterStream(1, fr);
			int i =  ps.executeUpdate();
			System.out.println(i + " row affected");
		}
		catch(Exception e)
		{
			
		}
}
}

