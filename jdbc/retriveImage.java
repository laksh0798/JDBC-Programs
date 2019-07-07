package jdbc;
import java.sql.*;
import java.io.*;
public class retriveImage {
	public static void main(String args[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pract", "root", "root");
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			ResultSet rs  = ps.executeQuery();
			if(rs.next())
			{
				Blob b = rs.getBlob(6);
				byte barr[]=b.getBytes(1,(int)b.length());
				FileOutputStream fos = new FileOutputStream("/home/laksh/Documents/2.jpeg");
				fos.write(barr);
				fos.close();
				System.out.println("image retrived");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
